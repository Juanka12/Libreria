package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import vista.Inicial;
import vista.RutaPanel;

public class ParaRutaPanel {
	private ViewController viewController = new ViewController();
	private DataController dataController = new DataController();

	public ParaRutaPanel(ViewController vc, DataController dc) {
		this.viewController = vc;
		this.dataController = dc;
		
		getRutaPanel().btnAceptarRuta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dataController.setRuta(getRutaPanel().textFieldRuta.getText());
				switch (getRutaPanel().test) {
				case 0:
					dataController.loadFile();
					SwingUtilities.getWindowAncestor(getRutaPanel()).dispose();
					break;

				case 1:
					dataController.saveFile();
					SwingUtilities.getWindowAncestor(getRutaPanel()).dispose();
					break;
				case 2:
					dataController.deleteFile();
					SwingUtilities.getWindowAncestor(getRutaPanel()).dispose();
					break;
				}
				try {
					getInicialPanel().UpdateTabla(dataController.getLista());
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
	}

	public RutaPanel getRutaPanel() {
		return viewController.getRutaPanel();
	}
	public Inicial getInicialPanel() {
		return viewController.getInicialPanel();
	}
}
