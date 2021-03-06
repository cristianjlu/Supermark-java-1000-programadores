package controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion_BD {

	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	// org.postgresql.Driver
	public static final String DB_URL = "jdbc:mysql://localhost:3306/miprimera_bd";
	// jdbc:postgresql://192.168.0.26:5432/customerdb
	public static String USER = "root";
	public static String PASS = "";

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		
		try {
			// 2 registrar el diver
			Class.forName(JDBC_DRIVER);

			// 3 abrir conexion
			System.out.println("conectando");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// 4 ejecutar consulta sql
			System.out.println("***creando statement...*****");
			stmt = conn.createStatement();
			String sql;
			// 5 probar las consultas
			sql= findAll();
			ResultSet rs = stmt.executeQuery(sql);
			
			
			 
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				double precio = rs.getDouble("precio");
				int cate = rs.getInt("id_categoria");
				System.out.print("id:" + id);
				System.out.print(", nombre:" + nombre);
				System.out.print(", precio:" + precio);
				System.out.println(" , id_categoria:" + cate);
				
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println(e +" algun error al conectar");
		}
		System.out.println("****termino****");

	}

	public static String findAll() {
		/*
		sql = findAll();
		ResultSet rs = stmt.executeQuery(sql);
		// 5 extraer datos
		while (rs.next()) {
			int id = rs.getInt("id_prod");
			String nombre = rs.getString("nombre");
			double precio = rs.getDouble("precio");
			int cate = rs.getInt("c_categoria");
			System.out.print("id:" + id);
			System.out.print(", nombre:" + nombre);
			System.out.print(", precio:" + precio);
			System.out.println(" , id cate:" + cate);
			System.out.println();
		}

		rs.close();
		*/
		return "SELECT * from productos";
	}
	public static String findAllXNombre(String nombre) {
		/*
		sql = findAllXNombre("galletas");
			ResultSet rs = stmt.executeQuery(sql);
			// 5 extraer datos
			while (rs.next()) {
				int id = rs.getInt("id_prod");
				String nombre = rs.getString("nombre");
				double precio = rs.getDouble("precio");
				int cate = rs.getInt("c_categoria");
				System.out.print("id:" + id);
				System.out.print(", nombre:" + nombre);
				System.out.print(", precio:" + precio);
				System.out.println(" , id cate:" + cate);
				System.out.println();
			}

			rs.close();
		*/
		return "SELECT * from productos where nombre='"+nombre+"'";
	}
	public static String findAllXNombreXPrecio(String nombre, double precio) {
		/*
		sql = findAllXNombreXPrecio("galletas",200);
			ResultSet rs = stmt.executeQuery(sql);
			// 5 extraer datos
			while (rs.next()) {
				int id = rs.getInt("id_prod");
				String nombre = rs.getString("nombre");
				double precio = rs.getDouble("precio");
				int cate = rs.getInt("c_categoria");
				System.out.print("id:" + id);
				System.out.print(", nombre:" + nombre);
				System.out.print(", precio:" + precio);
				System.out.println(" , id cate:" + cate);
				System.out.println();
			}

			rs.close();
		*/
		return "SELECT * from productos where nombre='"+nombre+"' and precio>"+precio;
	}

	public static String insert(int id, String nombre, double precio, int idcat) {
		// sql = insert(100,"nuevo", 200, 1);//insertar
		// stmt.executeUpdate(sql);
		return "INSERT INTO productos (id_prod, nombre, precio, c_categoria) VALUES (" + id + ",'" + nombre + "'," + precio + "," + idcat + ");";
	}
	public static String insert2(String nombre, double precio, int idcat) {
		/*
		sql = insert2("nuevo 2", 400, 2);//insertar
		stmt.executeUpdate(sql);
		*/
		return "INSERT INTO productos (id_prod, nombre, precio, c_categoria) VALUES (null ,'" + nombre + "'," + precio + "," + idcat + ");";
	}

	public static String get(int id) {
		/*
		sql = get(1);
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt("id_prod");
			String nombre = rs.getString("nombre");
			double precio = rs.getDouble("precio");
			int cate = rs.getInt("c_categoria");
			System.out.print("id:"+id);
			System.out.print(", nombre:"+nombre);
			System.out.print(", precio:"+precio);
			System.out.println(" , id cate:"+cate);
			System.out.println();
		}
		rs.close();
		*/
		
		return "SELECT * from productos where id_prod= " + id;
	}

	public static String update(int id, String nombre, double precio, int idcat) {
		/*
		sql = update(10,"nuevo modificado 2",400,1);
		stmt.executeUpdate(sql);
		*/
		return "UPDATE productos SET nombre='" + nombre + "', precio=" + precio + ", c_categoria=" + idcat
				+ " where id_prod=" + id;
	}

	public static String delete(int id) {
		/*
		sql = delete(101);
		stmt.executeUpdate(sql);
		*/
		return "delete from productos where id_prod= " + id;
	}
	
	
	
}
