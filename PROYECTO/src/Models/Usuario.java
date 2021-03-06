
package Models;

public class Usuario {
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasenia;
	private int tipodeusuario;
	private boolean tieneTarjeta;
	private Carrito carritoCompraU;

	public Usuario(int id, String nombre, String apellido, String email, String contrasenia, int tipodeusuario,
			boolean tieneTarjeta) {
	
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasenia = contrasenia;
		this.tipodeusuario = tipodeusuario;
		this.tieneTarjeta = tieneTarjeta;
		this.carritoCompraU = new Carrito();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getTipodeusuario() {
		return tipodeusuario;
	}

	public void setTipodeusuario(int tipodeusuario) {
		this.tipodeusuario = tipodeusuario;
	}

	public boolean isTieneTarjeta() {
		return tieneTarjeta;
	}

	public void setTieneTarjeta(boolean tieneTarjeta) {
		this.tieneTarjeta = tieneTarjeta;
	}

	public Carrito getCarritoCompraU() {
		return carritoCompraU;
	}

	public void setCarritoCompraU(Carrito carritoCompraU) {
		this.carritoCompraU = carritoCompraU;
	}
	
	public void agregaCarritoU(Producto prod) {
		this.carritoCompraU.agragarProducto(prod);
	}
	
	
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", contrasenia=" + contrasenia + ", tipodeusuario=" + tipodeusuario + ", tieneTarjeta=" + tieneTarjeta
				+ ", carritoCompraU=" + carritoCompraU + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//
//	public void selecionarCategoria() throws SQLException{
//		Conexion conexion = new Conexion();
//	String consulta = "select * from categoria;";
//	ResultSet rs = conexion.traerConsulta(consulta);
//	while (rs.next()) {
//		int id = rs.getInt("ID");
//		String nombre = rs.getString("NOMBRE");
//		System.out.println(id + " " + nombre);
//		};
//	
//	}
//		
//		public void verProductos() throws SQLException{
//			
//			System.out.println("Elija la opcion:");
//			int opcion = sc.nextInt();
//
//			String consulta = "select ID, nombre,precio,FECHA_VENCIMIENTO "
//					+ "from productos where id_categoria = " + "'" + opcion + "';";
//			Conexion conexion = new Conexion();
//			ResultSet rs2 = conexion.traerConsulta(consulta);
//
//			while (rs2.next()) {
//				int id = rs2.getInt("ID");
//				String nombre = rs2.getString("nombre");
//				rs2.getDate("FECHA_VENCIMIENTO");
//				double precio = rs2.getDouble("precio");
//				System.out.println(id + " " + nombre + " " + " precio: "
//				+ precio + " " + "vencimineto: "
//						+ rs2.getDate("FECHA_VENCIMIENTO"));
//				
//		}
//			
//		
//		}
//		
//		
//		public ArrayList<Producto> AgregarProducto() throws SQLException {
//			System.out.println("Elije los productos");
//			ArrayList<Producto> lista=new ArrayList<Producto>();
//			Conexion conexion =new Conexion();
//			
//			int opcion=sc.nextInt();
//			String consulta = "select ID, nombre,precio,FECHA_VENCIMIENTO "
//					+ "from productos where iD = " + "'" + opcion + "';";
//			
//			ResultSet rs= conexion.traerConsulta(consulta);
//			while(rs.next()){
//				
//				int id = rs.getInt("ID");
//				String nombre = rs.getString("nombre");
//				rs.getDate("FECHA_VENCIMIENTO");
//				double precio = rs.getDouble("precio");
//				System.out.println(id + " " + nombre + " " + " precio: "
//				+ precio + " " + "vencimineto: "
//						+ rs.getDate("FECHA_VENCIMIENTO"));
//				Producto p1= new Producto(id, nombre, precio);
//				lista.add(p1);
//				System.out.println(p1);
//			}
//			
//	
//			return lista;
//		}
//		

}
