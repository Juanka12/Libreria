package control;

import modelo.Libro;
import utiles.ButtonsTools;
import vista.Inicial;
import vista.InputFrame;
import vista.RutaPanel;
import vista.Version;
import vista.VistaHeredable;

public class ViewController {
	private Version versionPanel = new Version();
	private Inicial inicialPanel = new Inicial();
	private RutaPanel rutaPanel = new RutaPanel();
	
	public Version getVersionPanel() {
		return this.versionPanel;
	}

	public Inicial getInicialPanel() {
		return this.inicialPanel;
	}
	
	public RutaPanel getRutaPanel() {
		return this.rutaPanel;
	}
	
	public void newInputFrame(RutaPanel rp) {
		InputFrame ip = new InputFrame();
		ip.main(rp);
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
		getInicialPanel().grupoFormato.setSelected(ButtonsTools.getButtonModel(getInicialPanel().grupoFormato, libro.getFormato()),true);
		getInicialPanel().grupoEstado.setSelected(ButtonsTools.getButtonModel(getInicialPanel().grupoEstado, libro.getEstado()),true);
		getInicialPanel().tabbedPane.setSelectedIndex(0);
	}
	
}
