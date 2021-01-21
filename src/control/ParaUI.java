package control;

import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URI;

import javax.swing.JOptionPane;

import modelo.Error;
import utiles.Tools;
import vista.Inicial;
import vista.UI;
import vista.Version;
import vista.VistaHeredable;

public class ParaUI extends UI {
	private DataController dataController = new DataController();
	private ViewController viewController = new ViewController();

	public ParaUI(ViewController vc, DataController dc) {
		this.viewController = vc;
		this.dataController = dc;
		initialConfig();

		mntmPrincipal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				viewController.ModoOscuro(getInicialPanel(), chckbxmntmOscuro.isSelected());
				cambioPanel(getInicialPanel());
			}
		});

		chckbxmntmOscuro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				viewController.ModoOscuro((VistaHeredable) getContentPane(), chckbxmntmOscuro.isSelected());
				dataController.setOscuroConfig(chckbxmntmOscuro.isSelected());
			}
		});

		mntmReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] buttons = { "Borrar Todo", "Cancelar"};    
				int returnValue = JOptionPane.showOptionDialog(null, "Seguro que quieres borrar todos los libros el inventario ?", "Input",
				        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
				if (returnValue==0) {
					dataController.reset();
					getInicialPanel().UpdateTabla(dataController.getLista());
				}
			}
		});

		mntmVersion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				viewController.ModoOscuro(getVersionPanel(), chckbxmntmOscuro.isSelected());
				cambioPanel(getVersionPanel());
			}
		});

		mntmRepositorio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					URI oURL = new URI("https://github.com/Juanka12/Libreria");
					Desktop.getDesktop().browse(oURL);
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Quieres salir de la aplicacion ?", "Cerrar Ventana",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					try {
						dataController.saveConfigurations();
					} catch (Exception e2) {
						System.out.println(e2);
					}
					System.exit(0);
				}
			}
		});

	}

	private Inicial getInicialPanel() {
		return viewController.getInicialPanel();
	}

	private Version getVersionPanel() {
		return viewController.getVersionPanel();
	}

	private void initialConfig() {
		try {
			chckbxmntmOscuro.setSelected(dataController.getOscuroConfig());
			cambioPanel(getInicialPanel());
			viewController.ModoOscuro((VistaHeredable) getContentPane(), chckbxmntmOscuro.isSelected());
			getInicialPanel().UpdateTabla(dataController.getLista());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
