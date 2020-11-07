package control;

import java.util.HashMap;

import modelo.Libreria;
import modelo.Libro;

public class DataController {
	private Libreria libreria = new Libreria();
	private IOHandler ioHandler = new IOHandler();
	private String rutaFile;

	public void deleteFile() {
		ioHandler.deleter(rutaFile);
	}
	public void loadFile() {
		HashMap<String, Libro> nueva = ioHandler.reader(rutaFile);
		updateLibrary(nueva);
	}
	public void saveFile() {
		ioHandler.writer(getLista(),rutaFile);
	}
	public void reset() {
		this.libreria.reset();
	}
	public void updateLibrary(HashMap<String, Libro> nueva) {
		this.libreria.update(nueva);
	}
	public Libreria getLibreria() {
		return this.libreria;
	}
	public void borrarLibroCantidad(String isbn, int cantidad) {
		this.libreria.borrarLibroCantidad(isbn, cantidad);
	}
	public void borrarLibro(String isbn) {
		this.libreria.borrarLibro(isbn);
	}
 	public Libro getLibroISBN(String ISBN) {
		return this.libreria.getLibroISBN(ISBN);
	}
	public void addBook(Libro libro) {
		this.libreria.addBook(libro);
	}
	public int getSize() {
		return this.libreria.getSize();
	}
	public HashMap<String, Libro> getLista() {
		return this.libreria.getLista();
	}
	public void setRuta(String r) {
		this.rutaFile = r;
	}
	public String getRuta() {
		return this.rutaFile;
	}
}
