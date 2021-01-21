package vista;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Version extends VistaHeredable{
	private final String VERSION = "4.11.16";
	private final String DESCRIPTION = "Libreria creada por Juan Carlos";

	/**
	 * Create the panel.
	 */
	public Version() {
		this.setBackground(TEMA1[2]);
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblVersion = new JLabel("Version "+VERSION);
		lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblVersion);
		
		JLabel lblDescripcion = new JLabel(DESCRIPTION);
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDescripcion);
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
