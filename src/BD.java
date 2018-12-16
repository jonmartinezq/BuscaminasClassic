


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class BD {
	
	private Connection con;
	private static Statement stmt;
	
	/**
	 * Metodo que crea una sentencia para acceder a la base de datos 
	 */
	public void crearSentencia()
	{
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Metodo que permite conectarse a la base de datos
	 */

	public void conectar()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			con= DriverManager.getConnection("jdbc:sqlite:BaseDeDatos.db");
			crearSentencia();
		}catch(Exception e)
		{
			System.out.println("No se ha podido conectar a la base de datos");
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que cierra una sentencia 
	 */
	public void cerrarSentencia()
	{
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que permite desconectarse de la base de datos
	 */
	public void desconectar()
	{
		try {
			cerrarSentencia();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BD(){
		conectar();
	}
	
	
	//111
	public void insertarNuevaPuntuacion(Puntuacion p)
	{
		String s = "INSERT INTO puntuacion(nombre,punt) VALUES ('"+p.getUsuario()+"',"+p.getPuntuacion()+")";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int obtenerPuntuacionTotal(String usu) {
		String query="SELECT SUM(punt) FROM puntuacion WHERE nombre='"+usu+"'";
		int suma=0;
		try {
			ResultSet rs = stmt.executeQuery(query);
			suma = rs.getInt(1);
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return suma;
	}
	
	
	// 1
	public ArrayList<Puntuacion> obtenerPuntuaciones(){
		ArrayList<Puntuacion> aPuntuaciones = new ArrayList<Puntuacion>();
		String query = "SELECT * FROM puntuacion";
		try {
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Puntuacion p = new Puntuacion(rs.getString("nombre"),rs.getInt("punt"));
				aPuntuaciones.add(p);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aPuntuaciones;
	}
}
