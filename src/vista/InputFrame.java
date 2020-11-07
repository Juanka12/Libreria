package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class InputFrame extends JFrame {


	/**
	 * Launch the application.
	 */
	public void main(JPanel jp) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputFrame frame = new InputFrame();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setContentPane(jp);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InputFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(200, 200, 277, 350);
	}
}
