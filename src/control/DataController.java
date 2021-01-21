package control;

import java.sql.SQLException;
import java.util.HashMap;

import modelo.Configurations;
import modelo.Libreria;
import modelo.Libro;

public class DataController {
	private Libreria libreria = new Libreria();
	private IOHandler ioHandler = new IOHandler();
	private Configurations config = new Configurations();
	private CallerHandler acceso;

	public DataController() {
		try {
			acceso = new CallerHandler();
		} catch (Exception e) {
			e.printStackTrace();
		}
		loadConfigurations();
	}

	public void loadBBDD() throws SQLException {
		HashMap<String, Libro> nueva = acceso.getLista();
		updateLibrary(nueva);
	}

	public void saveConfigurations() {
		ioHandler.writer(this.config, this.config.getRUTA_CONFIG());
	}

	public void loadConfigurations() {
		try {
			config = (Configurations) ioHandler.reader(this.config.getRUTA_CONFIG());
			loadBBDD();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void reset() {
		try {
			this.acceso.vaciarTabla();
			this.libreria.reset();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateLibrary(HashMap<String, Libro> nueva) {
		this.libreria.update(nueva);
	}

	public void borrarLibroCantidad(String isbn, int cantidad) {
		try {
			this.acceso.updateCantidad(isbn, cantidad);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.libreria.borrarLibroCantidad(isbn, cantidad);
	}

	public void borrarLibro(String isbn) {
		try {
			this.acceso.removeLibro(isbn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.libreria.borrarLibro(isbn);
	}

	public void addBook(Libro libro) {
		try {
			this.acceso.addLibro(libro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.libreria.addBook(libro);
	}
	
	public Libro getLibroISBN(String ISBN) {
		return this.libreria.getLibroISBN(ISBN);
	}

	public HashMap<String, Libro> getLista() {
		return this.libreria.getLista();
	}

	public Configurations getConfig() {
		return this.config;
	}

	public void setOscuroConfig(boolean b) {
		this.config.setOscuro(b);
	}

	public boolean getOscuroConfig() {
		return this.config.isOscuro();
	}
}
