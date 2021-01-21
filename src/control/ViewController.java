package control;

import modelo.Estados;
import modelo.Formatos;
import modelo.Generos;
import modelo.Libro;
import utiles.ButtonsTools;
import vista.Inicial;
import vista.Version;
import vista.VistaHeredable;

public class ViewController {
	private Version versionPanel = new Version();
	private Inicial inicialPanel = new Inicial();
	
	public Version getVersionPanel() {
		return this.versionPanel;
	}

	public Inicial getInicialPanel() {
		return this.inicialPanel;
	}
	
	public void ModoOscuro(VistaHeredable jp, boolean check) {
		if (check) {
			jp.oscuro();
		}else {
			jp.claro();
		}
	}
	
	public boolean comprobarCampos(VistaHeredable jp) {
		return jp.comprobarCampos();
	}
	
	public void rellenarModificacion(Libro libro) {
		getInicialPanel().textFieldISBN.setText(libro.getISBN());
		getInicialPanel().textFieldTitulo.setText(libro.getTitulo());
		getInicialPanel().textFieldAutor.setText(libro.getAutor());
		getInicialPanel().textFieldEditorial.setText(libro.getEditorial());
		getInicialPanel().textFieldPrecio.setText(libro.getPrecio());
		getInicialPanel().spinner.setValue(Integer.valueOf(libro.getCantidad()));
		getInicialPanel().comboBoxGeneros.setSelectedIndex(Generos.valueOf(libro.getGenero()).ordinal());
		getInicialPanel().comboBoxFormatos.setSelectedIndex(Formatos.valueOf(libro.getFormato()).ordinal());
		getInicialPanel().comboBoxEstados.setSelectedIndex(Estados.valueOf(libro.getEstado()).ordinal());
		getInicialPanel().tabbedPane.setSelectedIndex(0);
	}
	
}
