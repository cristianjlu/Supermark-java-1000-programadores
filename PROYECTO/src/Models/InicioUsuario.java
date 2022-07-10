package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import conexion.Conexion;

public class InicioUsuario {
	private Conexion conexion;
	

	public InicioUsuario() {
		conexion = new Conexion();
	}
	
	public void menu (Usuario usuario) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"ingreso exitoso " + "bienvenido " + usuario.getNombre() + " " +
		usuario.getApellido());
		
		int condicion=0; //esta es del do while
		
		
		do {
		System.out.println("ingrese una opcion:");
		System.out.println(
				"1- Selecionar categoria de productos\r\n" + 
						"2- ver listado de productos seleccionados\r\n"
						+ "3- Autorizar la compra de los productos selecionados");
		int opcion = sc.nextInt();
		
		switch (opcion) {
		case 1:
			
			System.out.println("Categorias");
			String sql= "Select * from categoria";
			ResultSet rs =conexion.traerConsulta(sql); 
			
			while(rs.next()) {
				int id= rs.getInt("ID");
				String nombre= rs.getString("NOMBRE");
				System.out.println("codigo : "+id +" " + nombre );
				
			}
			
			System.out.println("Ingrese el codigo de la categoria");
				int opcionCategoria =sc.nextInt();
				String sql2= "Select ID,NOMBRE,PRECIO,FECHA_VENCIMIENTO "
						+ "from productos where ID_CATEGORIA = " + "'" + opcionCategoria + "';";
				ResultSet rs2 = conexion.traerConsulta(sql2);
				
				
				while(rs2.next()) {
					int id = rs2.getInt("id");
					String nombre =rs2.getString("nombre");
					rs2.getString("fecha_vencimiento");
					double precio= rs2.getDouble("precio");
					
					System.out.println(id +" "+  nombre +" "+ precio);
					
				}
				
				System.out.println("ingrese codigo del producto :");
				int codigoProducto =sc.nextInt();
				System.out.println("ingrese la cantidad");
				int cantidadProducto = sc.nextInt();
				
				String sql3 = "Select * from productos where id="+"'"+codigoProducto+"';";
				ResultSet rs3 =conexion.traerConsulta(sql3);
				
				
				if(rs3.next()) {
					int id = rs3.getInt("ID");
					String nombre = rs3.getString("NOMBRE");
					int stock = rs3.getInt("STOCK");
					String fecha = rs3.getString("FECHA_VENCIMIENTO");
					double precio = rs3.getDouble("PRECIO");
					
					if(stock > cantidadProducto) {
						Producto producto =new Producto(id, nombre, cantidadProducto, fecha, precio);
						usuario.agregaCarritoU(producto);
						System.out.println("producto agregado");
						
					}
					
				}else {
					System.out.println("No hay Stock");
				}
				
				
			break;
		case 2:
			System.out.println("Mostrar productos del carrito");
			Carrito carrito2 = usuario.getCarritoCompraU();
			carrito2.recorrerCarrito();
			break;
		case 3:
			System.out.println("Autorizar compra");
			Carrito carrito3 = usuario.getCarritoCompraU();
			carrito3.autorizarCompra(usuario);
			break;

		default:System.out.println("Opcion incorrecta");
			break;
		
		
			}
			
			
			
		System.out.println(" volver al menu principal?");
		System.out.println("si =1 o no= 0 ?");
		condicion = sc.nextInt();

		
		}while(condicion !=0); 
			
		System.out.println("Gracias por su compra...");
	
		
		
	}
	
}
