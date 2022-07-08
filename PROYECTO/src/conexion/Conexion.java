package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
//	creamos objetos global
	Connection conn = null;
	Statement stmt = null;

	// contructor

	public Conexion() {
		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		// org.postgresql.Driver
		final String DB_URL = "jdbc:mysql://localhost:3306/super";
		// jdbc:postgresql://192.168.0.26:5432/customerdb
		final String USER = "root";
		final String PASS = "";
		
		

		try {
			// 2 registrar el diver
			Class.forName(JDBC_DRIVER);

			// 3 abrir conexion
			System.out.println("conectando");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (Exception e) {
			System.out.println(e + " algun error al conectar");
		}

	}

	// metodos objeto resultSet para traer consulta
	public ResultSet traerConsulta(String sql) throws SQLException {
		// 4 ejecutar consulta sql
		System.out.println("***creando Consulta O Statement*****");
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	
	public void agregarConsulta(String sql) throws SQLException {
		// 4 ejecutar consulta sql
		System.out.println("***creando Consulta O Statement*****");
		stmt =conn.createStatement();
		stmt.executeUpdate(sql);
			
		
	};

}
