package Models;

import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;


public class Login {
	private String email;
	private String pass;

	
	public Login(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
	public String toString() {
		return "Login [email=" + email + ", pass=" + pass + "]";
	}


//	metodos de ingresar
	
	public Usuario ingresar() throws SQLException {
		Usuario usuario = null; //solo declaramos un usuario para llenarlo al final
	Conexion conexion = new Conexion(); //llamamos al contructor de la consulta
	String consultaSql = "select * from usuario where email=" + "'"+this.email+"'"
			+" and contrasenia="+"'"+this.pass+"'";
//		rs = contiene la consulta
	ResultSet rs = conexion.traerConsulta(consultaSql);
		
		while(rs.next()) {
			
			int id  = rs.getInt("ID");
			String nombre = rs.getString("NOMBRE");
			String apellido = rs.getString("APELLIDO");
			String email =rs.getString("EMAIL");
			String contrasenia = rs.getString("CONTRASENIA");
			boolean tieneTarjeta=rs.getBoolean("TIENETARJETA");
			int idTipoUsuario  =rs.getInt("ID_TIPODEUSUARIO");
			

			usuario =new Usuario(id, nombre, apellido, email, contrasenia, idTipoUsuario, tieneTarjeta);
					
		}
			return usuario;
	
		
	}


}

