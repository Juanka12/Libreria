package control;
import java.sql.*;

public class AccesoBBDD {
	public final String USUARIO = "root";
	public final String PASS = "";
	public final String BBDD = "jdbc:mysql://localhost:3306/libreria";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	private Connection connection;
	private static AccesoBBDD acceso = null;
	
	public AccesoBBDD() throws SQLException {
		this.connection = DriverManager.getConnection(BBDD, USUARIO, PASS);
	}
	public static AccesoBBDD getInstance() throws SQLException {
		if (acceso==null) {
			acceso = new AccesoBBDD();
		}
		return acceso;
	}
	public Connection getConnection() {
		return this.connection;
	}
	
}
