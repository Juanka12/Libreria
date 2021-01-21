package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;

public class UI extends JFrame {

	private JMenuBar menuBar;
	private JMenu mnOpciones;
	protected JCheckBoxMenuItem chckbxmntmOscuro;
	private JMenu mnAyuda;
	protected JMenuItem mntmVersion;
	private JMenu mnInicio;
	protected JMenuItem mntmPrincipal;
	protected JMenuItem mntmReset;
	protected JMenuItem mntmRepositorio;

	/**
	 * Create the frame.
	 */
	public UI() {
		setTitle("Libreria Juan Carlos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(200, 200, 800, 578);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);

		mntmPrincipal = new JMenuItem("Menu Principal");
		mnInicio.add(mntmPrincipal);

		mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
		mntmReset = new JMenuItem("Borrar Todo");
		mnOpciones.add(mntmReset);

		chckbxmntmOscuro = new JCheckBoxMenuItem("Modo Oscuro");
		mnOpciones.add(chckbxmntmOscuro);

		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		mntmVersion = new JMenuItem("Version");
		mnAyuda.add(mntmVersion);
		
		mntmRepositorio = new JMenuItem("Repositorio");
		mnAyuda.add(mntmRepositorio);
		
	}

	protected void cambioPanel(JPanel cp) {
		this.setContentPane(cp);
		this.revalidate();
		this.repaint();
	}

}
