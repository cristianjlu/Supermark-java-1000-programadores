package Models;

import java.sql.SQLException;
import java.util.Scanner;

import conexion.Conexion;

public class Registro {
		
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenia;
	private boolean tieneTarjeta;
	private int tipodeusuario;

	
	
	
	public Registro(String nombre, String apellido, String email, String contrasenia, boolean tieneTarjeta,
			int idTipodeusuario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasenia = contrasenia;
		this.tieneTarjeta = tieneTarjeta;
		this.tipodeusuario = idTipodeusuario;
	}

	public Registro() {
		Scanner sc = new Scanner(System.in);

		System.out.println("ingrese su nombre: ");
		this.nombre = sc.nextLine();
		System.out.println("ingrese su apellido: ");
		this.apellido = sc.nextLine();
		System.out.println("ingrese su email: ");
		this.email = sc.nextLine();
		System.out.println("ingrese su contrasenia: ");
		this.contrasenia = sc.nextLine();
		this.tieneTarjeta = false; // le ponemos false por que es usuario nuevo
		this.tipodeusuario = 1;// 1 = tipo usuario cliente 2 = admin

	}

	public  void validaDatos() throws SQLException {

		if (this.nombre != "" && this.apellido != "" 
			&& this.email != "" && this.contrasenia != "") {
			
			String sql = "insert into usuario values(null,"+"'"+this.nombre+"',"+
					"'"+this.apellido+"',"+"'"+this.email+"',"+"'"+this.contrasenia	+"',"+"false,1);";

			Conexion conexion =new Conexion();
			conexion.agregarConsulta(sql);
			
			System.out.println("usuario cargado");
			

		}else {
			System.out.println("datos mal ingresados");
		}

		
	}
}
