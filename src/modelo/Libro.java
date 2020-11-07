package modelo;

import java.io.Serializable;

public class Libro implements Serializable{

	private String ISBN;
	private String titulo;
	private String autor;
	private String editorial;
	private String precio;
	private String formato;
	private String estado;
	private String cantidad;
	private String genero;
	
	public Libro(String iSBN, String titulo, String autor, String editorial, String precio, String formato, String estado, String cantidad, String genero) {
		this.ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.precio = precio;
		this.formato = formato;
		this.estado = estado;
		this.cantidad = cantidad;
		this.genero = genero;
	}

	public String getFormato() {
		return this.formato;
	}

	public String getEstado() {
		return this.estado;
	}

	public String getISBN() {
		return this.ISBN;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getAutor() {
		return this.autor;
	}

	public String getEditorial() {
		return this.editorial;
	}

	public String getPrecio() {
		return this.precio;
	}
	
	public String getCantidad() {
		return this.cantidad;
	}
	
	public String getGenero() {
		return this.genero;
	}
	
	public void addCantidad(int i) {
		int value = Integer.valueOf(this.cantidad);
		value += i;
		this.cantidad = String.valueOf(value);
	}
	
	public void setCantidad(int i) {
		this.cantidad = String.valueOf(i);
	}
	
	public void removeCantidad(int cantidad) {
		int value = Integer.valueOf(this.cantidad);
		value -= cantidad;
		this.cantidad = String.valueOf(value);
	}

	@Override
	public String toString() {
		return "ISBN: "+ this.ISBN + "\nTitulo: "+ this.titulo+ "\nAutor: "+ this.autor+ "\nEditorial: "+ this.editorial+ "\nPrecio: "+this.precio+"\nFormato: "+this.formato+"\nEstado: "+this.estado+"\nCantidad: "+this.cantidad+"\nGenero: "+this.genero;
	}
	
}