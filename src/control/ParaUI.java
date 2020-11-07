package control;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import vista.Inicial;
import vista.RutaPanel;
import vista.UI;
import vista.Version;
import vista.VistaHeredable;

public class ParaUI extends UI {
	private DataController dataController = new DataController();
	private ViewController viewController = new ViewController();

	public ParaUI(ViewController vc, DataController dc) {
		this.viewController = vc;
		this.dataController = dc;
		
		cambioPanel(getInicialPanel());
		
		mntmPrincipal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				viewController.ModoOscuro(getInicialPanel(), chckbxmntmOscuro.isSelected());
				cambioPanel(getInicialPanel());
			}
		});
		
		mntmCargar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				getRutaPanel().test = 0;
				viewController.ModoOscuro(getRutaPanel(), chckbxmntmOscuro.isSelected());
				viewController.newInputFrame(getRutaPanel());
			}
		});

		mntmGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				getRutaPanel().test = 1;
				viewController.ModoOscuro(getRutaPanel(), chckbxmntmOscuro.isSelected());
				viewController.newInputFrame(getRutaPanel());
			}
		});
		
		mntmBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getRutaPanel().test = 2;
				viewController.ModoOscuro(getRutaPanel(), chckbxmntmOscuro.isSelected());
				viewController.newInputFrame(getRutaPanel());
			}
		});
		
		chckbxmntmOscuro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				viewController.ModoOscuro((VistaHeredable) getContentPane(), chckbxmntmOscuro.isSelected());
			}
		});
		
		mntmReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dataController.reset();
				getInicialPanel().UpdateTabla(dataController.getLista());
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
					  Desktop desktop = java.awt.Desktop.getDesktop();
					  URI oURL = new URI("http://www.google.com");
					  desktop.browse(oURL);
					} catch (Exception e1) {
						System.out.println(e1);
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
	
	private RutaPanel getRutaPanel() {
		return viewController.getRutaPanel();
	}
}
