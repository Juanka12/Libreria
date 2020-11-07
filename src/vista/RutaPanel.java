package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RutaPanel extends VistaHeredable {
	public JTextField textFieldRuta;
	public JButton btnAceptarRuta;
	public int test = 0;

	/**
	 * Create the panel.
	 */
	public RutaPanel() {
		this.setBackground(TEMA1[2]);
		setBounds(200, 200, 277, 350);
		setLayout(null);
		
		JLabel lblRuta = new JLabel("Ruta : ");
		lblRuta.setBounds(20, 59, 64, 34);
		add(lblRuta);
		
		textFieldRuta = new JTextField();
		textFieldRuta.setBounds(67, 66, 183, 20);
		add(textFieldRuta);
		textFieldRuta.setColumns(10);
		
		btnAceptarRuta = new JButton("Aceptar");
		btnAceptarRuta.setBounds(83, 208, 108, 34);
		add(btnAceptarRuta);
		
	}

	@Override
	public void oscuro() {
		super.oscuro();
		setBackground(TEMA_OSCURO[1]);
	}
	@Override
	public void claro() {
		super.claro();
		setBackground(TEMA1[2]);
	}
}
