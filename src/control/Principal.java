package control;

import java.awt.EventQueue;

import vista.UI;

public class Principal {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewController viewController = new ViewController();
					DataController dataController = new DataController();
					ParaInicial paraInicial = new ParaInicial(viewController, dataController);
					ParaUI frame = new ParaUI(viewController, dataController);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
