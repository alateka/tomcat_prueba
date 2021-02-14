package bd;
import entidades.Productos;
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
}


