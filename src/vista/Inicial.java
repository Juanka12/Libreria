package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modelo.Generos;
import modelo.Libro;
import utiles.ButtonsTools;
import utiles.Validaciones;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Inicial extends VistaHeredable {

	public JPanel panel;
	public JPanel panel_1;
	public JButton btnGuardar;
	public JButton btnConsultar;
	public JButton btnBorrar;
	public JButton btnAdd;
	public JButton btnSalir;
	public JTabbedPane tabbedPane;
	public JPanel PanelLibro;
	public JRadioButton rdbtnReedicion;
	public JRadioButton rdbtnNovedad;
	public JRadioButton rdbtnCartone;
	public JRadioButton rdbtnRustica;
	public JRadioButton rdbtnGrapada;
	public JRadioButton rdbtnEspiral;
	public JTextField textFieldISBN;
	public JTextField textFieldTitulo;
	public JTextField textFieldAutor;
	public JTextField textFieldEditorial;
	public JTextField textFieldPrecio;
	public JSpinner spinner;
	public JPanel PanelEstanteria;
	public JTable tablaLibros;
	public ButtonGroup grupoFormato;
	public ButtonGroup grupoEstado;
	public JComboBox comboBoxGeneros;

	/**
	 * Create the panel.
	 */
	public Inicial() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBackground(TEMA1[0]);
		add(panel, BorderLayout.NORTH);

		JLabel lblLibreria = new JLabel("Libreria");
		lblLibreria.setFont(new Font("Stencil", Font.PLAIN, 18));
		panel.add(lblLibreria);

		panel_1 = new JPanel();
		panel_1.setBackground(TEMA1[1]);
		FlowLayout fl_panel_1 = (FlowLayout) panel_1.getLayout();
		fl_panel_1.setHgap(20);
		add(panel_1, BorderLayout.SOUTH);

		btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(Inicial.class.getResource("/img/save.png")));
		panel_1.add(btnGuardar);

		btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon(Inicial.class.getResource("/img/search.png")));
		panel_1.add(btnConsultar);
		btnConsultar.setEnabled(false);

		btnBorrar = new JButton("");
		btnBorrar.setIcon(new ImageIcon(Inicial.class.getResource("/img/borrar.png")));
		panel_1.add(btnBorrar);
		btnBorrar.setEnabled(false);
		
		btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(Inicial.class.getResource("/img/add.png")));
		panel_1.add(btnAdd);
		btnAdd.setEnabled(false);

		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(Inicial.class.getResource("/img/cerrar.png")));
		panel_1.add(btnSalir);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);

		PanelLibro = new JPanel();
		PanelLibro.setBackground(TEMA1[2]);
		tabbedPane.addTab("Libro", null, PanelLibro, null);

		JPanel labels = new JPanel();
		labels.setBorder(new LineBorder(new Color(128, 128, 128)));
		labels.setBackground(TEMA1[2]);
		labels.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblISBN = new JLabel("ISBN");
		lblISBN.setHorizontalAlignment(SwingConstants.CENTER);
		labels.add(lblISBN);

		JLabel lbltitulo = new JLabel("Titulo");
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labels.add(lbltitulo);

		JLabel lblautor = new JLabel("Autor");
		lblautor.setHorizontalAlignment(SwingConstants.CENTER);
		labels.add(lblautor);

		JLabel lbleditorial = new JLabel("Editorial");
		lbleditorial.setHorizontalAlignment(SwingConstants.CENTER);
		labels.add(lbleditorial);

		JLabel lblprecio = new JLabel("Precio");
		lblprecio.setHorizontalAlignment(SwingConstants.CENTER);
		labels.add(lblprecio);

		JPanel Icon = new JPanel();
		Icon.setBackground(TEMA1[2]);

		JLabel Iconlbl = new JLabel("");
		Iconlbl.setIcon(new ImageIcon(Inicial.class.getResource("/img/book.png")));
		
		GroupLayout gl_Icon = new GroupLayout(Icon);
		gl_Icon.setHorizontalGroup(
			gl_Icon.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Icon.createSequentialGroup()
					.addGap(10)
					.addComponent(Iconlbl, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_Icon.setVerticalGroup(
			gl_Icon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Icon.createSequentialGroup()
					.addComponent(Iconlbl, GroupLayout.PREFERRED_SIZE, 172, Short.MAX_VALUE)
					.addGap(0))
		);
		Icon.setLayout(gl_Icon);

		JPanel textfields = new JPanel();
		textfields.setBackground(TEMA1[2]);

		JPanel panelFormato = new JPanel();
		panelFormato.setBorder(new LineBorder(Color.GRAY, 1, true));
		panelFormato.setBackground(TEMA1[2]);

		JPanel panelEstado = new JPanel();
		panelEstado.setBackground(TEMA1[2]);
		panelEstado.setBorder(new LineBorder(Color.GRAY, 1, true));
		FlowLayout flowLayout_1 = (FlowLayout) panelEstado.getLayout();
		GroupLayout gl_PanelLibro = new GroupLayout(PanelLibro);
		gl_PanelLibro.setHorizontalGroup(
			gl_PanelLibro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PanelLibro.createSequentialGroup()
					.addContainerGap()
					.addComponent(labels, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addGroup(gl_PanelLibro.createParallelGroup(Alignment.LEADING)
						.addComponent(panelEstado, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
						.addGroup(gl_PanelLibro.createSequentialGroup()
							.addComponent(textfields, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addGap(122)
							.addComponent(Icon, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
							.addGap(100))
						.addComponent(panelFormato, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_PanelLibro.setVerticalGroup(
			gl_PanelLibro.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PanelLibro.createSequentialGroup()
					.addGroup(gl_PanelLibro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_PanelLibro.createSequentialGroup()
							.addGap(14)
							.addGroup(gl_PanelLibro.createParallelGroup(Alignment.TRAILING)
								.addComponent(textfields, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
								.addComponent(Icon, GroupLayout.PREFERRED_SIZE, 201, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelFormato, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelEstado, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_PanelLibro.createSequentialGroup()
							.addContainerGap()
							.addComponent(labels, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)))
					.addContainerGap())
		);

		rdbtnReedicion = new JRadioButton("Reedici\u00F3n");
		rdbtnReedicion.setOpaque(false);
		panelEstado.add(rdbtnReedicion);

		rdbtnNovedad = new JRadioButton("Novedad");
		rdbtnNovedad.setOpaque(false);
		panelEstado.add(rdbtnNovedad);

		rdbtnCartone = new JRadioButton("Carton\u00E9");
		rdbtnCartone.setOpaque(false);
		panelFormato.add(rdbtnCartone);

		rdbtnRustica = new JRadioButton("R\u00FAstica");
		rdbtnRustica.setOpaque(false);
		panelFormato.add(rdbtnRustica);

		rdbtnGrapada = new JRadioButton("Grapada");
		rdbtnGrapada.setOpaque(false);
		panelFormato.add(rdbtnGrapada);

		rdbtnEspiral = new JRadioButton("Espiral");
		rdbtnEspiral.setOpaque(false);
		panelFormato.add(rdbtnEspiral);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		labels.add(lblCantidad);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
		labels.add(lblGenero);

		JLabel lblFormato = new JLabel("Formato");
		lblFormato.setHorizontalAlignment(SwingConstants.CENTER);
		labels.add(lblFormato);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		labels.add(lblEstado);
		textfields.setLayout(new GridLayout(0, 1, 0, 10));

		textFieldISBN = new JTextField();
		textfields.add(textFieldISBN);
		textFieldISBN.setColumns(10);

		textFieldTitulo = new JTextField();
		textfields.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);

		textFieldAutor = new JTextField();
		textfields.add(textFieldAutor);
		textFieldAutor.setColumns(10);

		textFieldEditorial = new JTextField();
		textfields.add(textFieldEditorial);
		textFieldEditorial.setColumns(10);

		textFieldPrecio = new JTextField();
		textfields.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		textfields.add(spinner);
		
		comboBoxGeneros = new JComboBox();
		comboBoxGeneros.setModel(new DefaultComboBoxModel(Generos.values()));
		textfields.add(comboBoxGeneros);
		PanelLibro.setLayout(gl_PanelLibro);

		PanelEstanteria = new JPanel();
		tabbedPane.addTab("Estanteria", null, PanelEstanteria, null);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_estanteria = new GroupLayout(PanelEstanteria);
		gl_estanteria.setHorizontalGroup(gl_estanteria.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE));
		gl_estanteria.setVerticalGroup(gl_estanteria.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE));

		tablaLibros = new JTable();
		scrollPane.setViewportView(tablaLibros);
		PanelEstanteria.setLayout(gl_estanteria);

		grupoFormato = new ButtonGroup();
		grupoFormato.add(rdbtnCartone);
		grupoFormato.add(rdbtnEspiral);
		grupoFormato.add(rdbtnGrapada);
		grupoFormato.add(rdbtnRustica);

		grupoEstado = new ButtonGroup();
		grupoEstado.add(rdbtnNovedad);
		grupoEstado.add(rdbtnReedicion);

	}
	@Override
	public void vaciarCampos() {
		textFieldISBN.setText("");
		textFieldISBN.setBackground(Color.WHITE);
		textFieldTitulo.setText("");
		textFieldAutor.setText("");
		textFieldEditorial.setText("");
		textFieldPrecio.setText("");
		spinner.setValue(0);
		grupoFormato.clearSelection();
		grupoEstado.clearSelection();
	}
	
	@Override
	public void oscuro() {
		super.oscuro();
		panel_1.setBackground(TEMA_OSCURO[0]);
		panel.setBackground(TEMA_OSCURO[1]);
		PanelLibro.setBackground(TEMA_OSCURO[1]);
		for (Component compo : PanelLibro.getComponents()) {
			compo.setBackground(TEMA_OSCURO[1]);
		}
	}
	@Override
	public void claro() {
		super.claro();
		panel_1.setBackground(TEMA1[1]);
		panel.setBackground(TEMA1[0]);
		PanelLibro.setBackground(TEMA1[2]);
		for (Component compo : PanelLibro.getComponents()) {
			compo.setBackground(TEMA1[2]);
		}
	}
	@Override
	public void tema1() {
		super.tema1();
		panel_1.setBackground(TEMA1[1]);
		panel.setBackground(TEMA1[0]);
		PanelLibro.setBackground(TEMA1[2]);
		for (Component compo : PanelLibro.getComponents()) {
			compo.setBackground(TEMA1[2]);
		}
	}
	@Override
	public boolean comprobarCampos() {
		if (!Validaciones.validateISBN(textFieldISBN.getText())
				|| !Validaciones.isNumberFloat(textFieldPrecio.getText())
				|| !Validaciones.validateLetters(textFieldAutor.getText()) || textFieldEditorial.getText().equals("")
				|| textFieldTitulo.getText().equals("") || ButtonsTools.getSelectedButtonText(grupoEstado) == null
				|| ButtonsTools.getSelectedButtonText(grupoFormato) == null) {
			return true;
		}
		return false;
	}
	public void UpdateTabla(HashMap<String, Libro> lista) {
		String nombresColumnas[] = { "ISBN", "Titulo", "Editorial", "Autor", "Precio","Cantidad" };
		String[][] filasTabla = new String[lista.size()][nombresColumnas.length];
		int i = 0;
		for (Libro libro : lista.values()) {
			filasTabla[i][0] = libro.getISBN();
			filasTabla[i][1] = libro.getTitulo();
			filasTabla[i][2] = libro.getEditorial();
			filasTabla[i][3] = libro.getAutor();
			filasTabla[i][4] = libro.getPrecio();
			filasTabla[i][5] = String.valueOf(libro.getCantidad());
			i++;
		}
		DefaultTableModel tablaCompleta = new DefaultTableModel(filasTabla, nombresColumnas) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablaLibros.setModel(tablaCompleta);
		DefaultTableCellRenderer alineado = new DefaultTableCellRenderer();
		alineado.setHorizontalAlignment(SwingConstants.CENTER);
		for (i = 0; i < nombresColumnas.length; i++) {
			tablaLibros.getColumnModel().getColumn(i).setCellRenderer(alineado);
		}
		if (tablaLibros.getRowCount() <= 0) {
			btnBorrar.setEnabled(false);
			btnConsultar.setEnabled(false);
			btnAdd.setEnabled(false);
		} else {
			btnBorrar.setEnabled(true);
			btnConsultar.setEnabled(true);
			btnAdd.setEnabled(true);
		}
	}
}
