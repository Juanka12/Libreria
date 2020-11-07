package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import modelo.Error;
import modelo.Libro;
import utiles.ButtonsTools;
import utiles.Validaciones;
import vista.Inicial;
import vista.VistaHeredable;

public class ParaInicial {
	private ViewController viewController = new ViewController();
	private DataController dataController = new DataController();

	public ParaInicial(ViewController vc, DataController dc) {
		this.viewController = vc;
		this.dataController = dc;

		ActionListener guardar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (viewController.comprobarCampos((VistaHeredable) getInicialPanel())) {
					JOptionPane.showMessageDialog(null,Error.Campos.getDisplay(),"Error",JOptionPane.ERROR_MESSAGE);
				} else if (dataController.getLibroISBN(getInicialPanel().textFieldISBN.getText()) != null) {
					JOptionPane.showMessageDialog(null, Error.Existente.getDisplay(),"Error",JOptionPane.ERROR_MESSAGE);
				} else {
					Libro libro = new Libro(getInicialPanel().textFieldISBN.getText(),
							getInicialPanel().textFieldTitulo.getText(), getInicialPanel().textFieldAutor.getText(),
							getInicialPanel().textFieldEditorial.getText(), getInicialPanel().textFieldPrecio.getText(),
							ButtonsTools.getSelectedButtonText(getInicialPanel().grupoFormato),
							ButtonsTools.getSelectedButtonText(getInicialPanel().grupoEstado),
							String.valueOf(getInicialPanel().spinner.getValue()),getInicialPanel().comboBoxGeneros.getSelectedItem().toString());
					dataController.addBook(libro);
					UpdateTabla();
					getInicialPanel().vaciarCampos();
					getInicialPanel().textFieldISBN.setEditable(true);
				}
			}

		};

		ActionListener modificar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int indice = getInicialPanel().tablaLibros.getSelectedRow();
				if (indice < 0) {
					JOptionPane.showMessageDialog(null, Error.SinSeleccion.getDisplay(),"Error",JOptionPane.ERROR_MESSAGE);
				} else {
					Libro libro = dataController
							.getLibroISBN((String) getInicialPanel().tablaLibros.getValueAt(indice, 0));
					viewController.rellenarModificacion(libro);
					dataController.borrarLibro(libro.getISBN());
					UpdateTabla();
					getInicialPanel().textFieldISBN.setEditable(false);
				}
			}
		};

		getInicialPanel().btnGuardar.addActionListener(guardar);
		
		getInicialPanel().btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		getInicialPanel().btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice = getInicialPanel().tablaLibros.getSelectedRow();
				if (indice < 0) {
					JOptionPane.showMessageDialog(null, Error.SinSeleccion.getDisplay(),"Error",JOptionPane.ERROR_MESSAGE);
				} else {
					String[] buttons = { "Todo", "Definir cantidad"};    
					int returnValue = JOptionPane.showOptionDialog(null, "Cuantos libros quiere borrar ?", "Input",
					        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
					switch (returnValue) {
					case 0:
						dataController.borrarLibro((String) getInicialPanel().tablaLibros.getValueAt(indice, 0));
						UpdateTabla();
						break;
						
					case 1:
						String cantidad = JOptionPane.showInputDialog("Cuantas cantidades a borrar ?");
						if (cantidad != null && !cantidad.equals("") && Integer.valueOf(cantidad) > 0) {
							dataController.borrarLibroCantidad((String) getInicialPanel().tablaLibros.getValueAt(indice, 0), Integer.valueOf(cantidad));
							UpdateTabla();
							JOptionPane.showMessageDialog(null, "Libro borrado");
						} else {
							JOptionPane.showMessageDialog(null, Error.Cantidad.getDisplay(),"Error",JOptionPane.ERROR_MESSAGE);
						}
						break;
						
					default:
						break;
					}
				}
			}
		});
		getInicialPanel().btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice = getInicialPanel().tablaLibros.getSelectedRow();
				if (indice >= 0) {
					String isbn = (String) getInicialPanel().tablaLibros.getValueAt(indice, 0);
					JOptionPane.showMessageDialog(null, dataController.getLibroISBN(isbn).toString());
				} else {
					String consulta = JOptionPane.showInputDialog("Introduce ISBN");
					if (consulta != null) {
						Libro libro = dataController.getLibroISBN(consulta);
						if (libro != null) {
							JOptionPane.showMessageDialog(null, libro.toString());
						} else {
							JOptionPane.showMessageDialog(null, Error.SinSeleccion.getDisplay(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		getInicialPanel().btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice = getInicialPanel().tablaLibros.getSelectedRow();
				if (indice < 0) {
					JOptionPane.showMessageDialog(null, Error.SinSeleccion.getDisplay(),"Error",JOptionPane.ERROR_MESSAGE);
				} else {
					String cantidad = JOptionPane.showInputDialog("Introduce cantidad a añadir");
					if (cantidad != null && !cantidad.equals("") && Integer.valueOf(cantidad) > 0) {
						dataController.getLibroISBN((String) getInicialPanel().tablaLibros.getValueAt(indice, 0))
								.addCantidad(Integer.valueOf(cantidad));
						UpdateTabla();
					} else {
						JOptionPane.showMessageDialog(null, Error.Cantidad.getDisplay(),"Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		getInicialPanel().textFieldISBN.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (Validaciones.validateISBN(getInicialPanel().textFieldISBN.getText())) {
					getInicialPanel().textFieldISBN.setBackground(Color.GREEN);
				} else {
					getInicialPanel().textFieldISBN.setBackground(Color.RED);
				}
			}
		});

		getInicialPanel().tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				JTabbedPane sourcePanel = (JTabbedPane) e.getSource();
				int index = sourcePanel.getSelectedIndex();
				if (index == 0) {
					ButtonsTools.clearListeners(getInicialPanel().btnGuardar);
					getInicialPanel().btnGuardar.addActionListener(guardar);
					getInicialPanel().btnGuardar.setIcon(new ImageIcon(ParaInicial.class.getResource("/img/save.png")));
					getInicialPanel().tablaLibros.clearSelection();
				} else {
					ButtonsTools.clearListeners(getInicialPanel().btnGuardar);
					getInicialPanel().btnGuardar.addActionListener(modificar);
					getInicialPanel().btnGuardar.setIcon(new ImageIcon(ParaInicial.class.getResource("/img/editar.png")));
				}
			}
		});
	}

	public Inicial getInicialPanel() {
		return viewController.getInicialPanel();
	}

	public void UpdateTabla() {
		getInicialPanel().UpdateTabla(dataController.getLista());
	}
}
