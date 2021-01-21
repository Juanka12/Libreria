package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import modelo.Estados;
import modelo.Formatos;
import modelo.Generos;
import modelo.Libro;

public class CallerHandler{
	private AccesoBBDD acceso = null;
	private Connection connection = null;

	public CallerHandler() throws SQLException {
		acceso = AccesoBBDD.getInstance();
		connection = acceso.getConnection();
	}

	public void addLibro(Libro libro) throws SQLException {
		CallableStatement cstmt = (CallableStatement) connection.prepareCall("{call addBook(?,?,?,?,?,?,?,?,?)}");
		cstmt.setString(1, libro.getISBN());
		cstmt.setString(2, libro.getAutor());
		cstmt.setString(3, libro.getTitulo());
		cstmt.setString(4, libro.getEditorial());
		cstmt.setInt(5, Generos.valueOf(libro.getGenero()).ordinal()+1);
		cstmt.setInt(6, Estados.valueOf(libro.getEstado()).ordinal()+1);
		cstmt.setInt(7, Formatos.valueOf(libro.getFormato()).ordinal()+1);
		cstmt.setInt(8, Integer.parseInt(libro.getCantidad()));
		cstmt.setFloat(9, Float.parseFloat(libro.getPrecio()));
		cstmt.execute();
	}
	public void removeLibro(String isbn) throws SQLException {
		CallableStatement cstmt = (CallableStatement) connection.prepareCall("{call removeBook(?)}");
		cstmt.setString(1, isbn);
		cstmt.execute();
	}
	public void updateCantidad(String isbn,int cantidad) throws SQLException {
		CallableStatement cstmt = (CallableStatement) connection.prepareCall("{call updateCantidad(?,?)}");
		cstmt.setString(1, isbn);
		cstmt.setInt(2, cantidad);
		cstmt.execute();
	}
	public HashMap<String, Libro> getLista() throws SQLException {
		HashMap<String, Libro> lista = new HashMap<String, Libro>();
		
		RowSetFactory rowsetFactory = RowSetProvider.newFactory();
		JdbcRowSet rowset = rowsetFactory.createJdbcRowSet();
		rowset.setUrl(acceso.BBDD);
		rowset.setUsername(acceso.USUARIO);
		rowset.setPassword(acceso.PASS);
		rowset.setCommand("SELECT * FROM libro");
//		rowset.setKeyColumns(new int[] { 1 });
		rowset.execute();
		while (rowset.next()) {
			Libro libro = new Libro(rowset.getString("isbn"),rowset.getString("titulo"),rowset.getString("autor"),rowset.getString("editorial"),rowset.getString("precio"),
					Estados.values()[rowset.getInt("formato")-1].toString(),Formatos.values()[rowset.getInt("estado")-1].toString(),rowset.getString("unidades"),Generos.values()[rowset.getInt("tematica")-1].toString());
			lista.put(libro.getISBN(),libro);
		}
//		rowset.acceptChanges();
		rowset.close();
		
		return lista;
	}
	public void vaciarTabla() throws SQLException {
		CallableStatement cstmt = (CallableStatement) connection.prepareCall("{call vaciarTabla()}");
		cstmt.execute();
	}
}
