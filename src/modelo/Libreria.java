package modelo;

import java.util.HashMap;

public class Libreria {
	private HashMap<String, Libro> lista = new HashMap<String, Libro>();
	
	public void update(HashMap<String, Libro> nueva) {
		this.lista = nueva;
	}
	
	public void reset() {
		this.lista = new HashMap<String, Libro>();
	}
	
	public void addBook(Libro libro) {
		lista.put(libro.getISBN(), libro);
	}
	
	public int getSize() {
		return lista.size();
	}
	
	public Libro getLibroISBN(String ISBN) {
		return lista.get(ISBN);
	}
	
	public void borrarLibroCantidad(String isbn, int cantidad) {
		Libro libro = lista.get(isbn);
		if (Integer.valueOf(libro.getCantidad())>cantidad) {
			libro.removeCantidad(cantidad);
		}else {
			libro.setCantidad(0);
		}
	}
	
	public void borrarLibro(String isbn) {
		lista.remove(isbn);
	}

	public HashMap<String, Libro> getLista() {
		return lista;
	}
	
}
