package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.SwingConstants;

public class UI extends JFrame {

	private JMenuBar menuBar;
	private JMenu mnArchivo;
	protected JMenuItem mntmCargar;
	protected JMenuItem mntmGuardar;
	private JMenu mnOpciones;
	protected JCheckBoxMenuItem chckbxmntmOscuro;
	private JMenu mnAyuda;
	protected JMenuItem mntmVersion;
	private JMenu mnInicio;
	protected JMenuItem mntmPrincipal;
	protected JMenuItem mntmReset;
	protected JMenuItem mntmBorrar;
	protected JMenuItem mntmRepositorio;

	/**
	 * Create the frame.
	 */
	public UI() {
		setTitle("Libreria Juan Carlos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(200, 200, 800, 520);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);

		mntmPrincipal = new JMenuItem("Menu Principal");
		mnInicio.add(mntmPrincipal);

		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		mntmCargar = new JMenuItem("Cargar");
		mnArchivo.add(mntmCargar);

		mntmGuardar = new JMenuItem("Guardar");
		mnArchivo.add(mntmGuardar);
		
		mntmBorrar = new JMenuItem("Borrar");
		mnArchivo.add(mntmBorrar);

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
