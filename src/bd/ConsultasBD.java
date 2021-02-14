package bd;
import entidades.Productos;
import entidades.Usuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;



public class ConsultasBD {

	public static LinkedList<Productos> getListado() throws SQLException, ClassNotFoundException {
		
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    
	    LinkedList<Productos> listaProductos=new LinkedList<Productos>();
		
		Connection miConexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/daw", "root", "daw1234");
		Statement miStatement = miConexion.createStatement();
		ResultSet resultado = miStatement.executeQuery("SELECT * FROM producto");
		
		while (resultado.next()) {
			Productos producto = new Productos();
			producto.setCod(resultado.getInt("cod"));
			producto.setNombre(resultado.getString("nombre"));
			producto.setPrecio(resultado.getInt("precio"));
			listaProductos.add(producto);
		}
		miConexion.close();
		miStatement.close();
		resultado.close();
		
		return listaProductos;
	}
	
	public static LinkedList<Usuarios> login(String nombreUseuario, String contrasenia) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
				
		Connection miConexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/daw", "root", "daw1234");
		Statement miStatement = miConexion.createStatement();
		ResultSet datosUsuario = miStatement.executeQuery("SELECT user, password FROM user WHERE (user = '" + nombreUseuario + "') AND (password = '"+ contrasenia + "')");
		
	    LinkedList<Usuarios> usuarios=new LinkedList<Usuarios>();

		while (datosUsuario.next()) {
			Usuarios usuario = new Usuarios();
			usuario.setUserName(datosUsuario.getString("user"));
			usuario.setPassword(datosUsuario.getString("password"));
			usuarios.add(usuario);
		}
		
		miConexion.close();
		miStatement.close();
		datosUsuario.close();
		
		return usuarios;
	}
}


