package controlador;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Models.InicioAdminstrador;
import Models.InicioUsuario;
import Models.Login;
import Models.Producto;
import Models.Registro;
import Models.Usuario;
import conexion.Conexion;

public class Principal {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido al supermark..");
		System.out.println("Elije las opciones..\r\n"+ 
				"1.- ingresar\r\n" + 
				" 2.- Registrarse");

		int respuesta = sc.nextInt();
		sc.nextLine();
		
		
		if(respuesta == 1) {
			System.out.println("- ingrese su email..");
			String email =sc.next();
			System.out.println("- ingrese su contrasenia..");
			String pass=sc.next();
			Login logiarse = new Login(email, pass);
			Usuario usuario = logiarse.ingresar();
			if(usuario != null) {
					if(usuario.getTipodeusuario()==1) {
						InicioUsuario inicioUsu = new InicioUsuario();
						inicioUsu.menu(usuario);
						
						
					}else {
//						inicioadmin .
					}
				
				
			}else{
				System.out.println("datos incorrectos");
			}
			
			
			
		}else {
			Registro registro= new Registro();
			registro.validaDatos();
		}
		
		
		
		
		
		
		
	}

}

		
		
		
		
		
		
		
		
		
		
/*
		switch (respuesta) {
		case 1:

			// login
			System.out.println("LOGIN");
			System.out.println("ingrese email");
			String email = sc.nextLine();

			System.out.println("ingrese contraseña");
			String pass = sc.nextLine();

			Login logiarse = new Login(email, pass);
			Usuario usuario = logiarse.ingresar();

			if (usuario != null) {
				System.out.println(
						"ingreso exitoso " + "bienvenido " + usuario.getNombre() + " " +
				usuario.getApellido());

				System.out.println("ingrese una opcion:");
				System.out.println(
						"1- Selecionar categoria de productos\r\n" + 
								"2- ver listado de productos seleccionados\r\n"
								+ "3- Autorizar la compra de los productos selecionados");
				int opcion = sc.nextInt();

				switch (opcion) {
				case 1:
					usuario.selecionarCategoria();
					usuario.verProductos();
					usuario.AgregarProducto();
					System.out.println();
					

					break;
				case 2:
					System.out.println("ver listado de productos seleccionados");
					
					break;
				case 3:
					System.out.println("Autorizar la compra de los productos selecionados");

					break;

				default:
					System.out.println("dato incorrecto");
					break;
				}

				
			} else {
				System.out.println("datos incorrectos");
			}
			break;
			
			
			

		case 2:
			// registro

			System.out.println("Registro: ingrese sus datos");
			System.out.println("ingrese el nombre");
			String nombre = sc.nextLine();

			System.out.println("ingrese el apellido");
			String apellido = sc.nextLine();
			System.out.println("ingrese el email");
			String correo = sc.nextLine();
			System.out.println("ingrese la contrasenia");
			String contra = sc.nextLine();

			Registro registro = new Registro(nombre, apellido, correo, contra, false, 1);
			registro.validaDatos();

			break;

		default:
			System.out.println("opcion incorrecta");
			break;

			
		}

		
		
		
*/		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


		// FLUJO DEL PROGRAMA

		// TENER UN MENU DE SI ES ADMIN O USUARIO

		// PARA USUARIO NORMAL MOSTRAR OTRO MENU CON DOS OPCIONES ( LOGEARSE O
		// REGISTRARSE )

		// UNA VEZ LOGEADO INSTANCIAMOS UN USUARIO Y MOSTRAMOS EL MENU

		// 1 menu principal para registrarse / iniciar sesion

		// 2 para el login se instancia un objeto tipo login y se verifica si esta en la
		// bdd

		// 3 en el caso de registrarse capturar los datos e insertarlos en la tabla de
		// usuarios

		// 4 una vez logeado con exito, instanciar una clase "home o inicio"

		// 5. dependiendo si es tipo admin o cliente se muestra su menu correspondiente

		// 6.

		/*
		 * Para el cliente: Registrarse. Iniciar sesión. Seleccionar productos ver
		 * listado de productos seleccionados. Autorizar la compra de los productos
		 * seleccionados
		 */

		/*
		 * Para la Administración: Cargar productos a la aplicación Modificar los datos
		 * de los productos cargados Ver todos los usuarios que realizaron una compra
		 * Ver listado de productos seleccionados por el usuario
		 */
