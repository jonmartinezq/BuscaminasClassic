
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BD {

	private static Thread hilo = null;
	private static Vector<Runnable> tareasPendientes; // Vector es synchronized con lo que se puede a la vez manejar
														// desde varios hilos
	static {
		tareasPendientes = new Vector<>();
	}

	private static void initHilo() {
		hilo = new Thread() {
			@Override
			public void run() {
				while (!interrupted()) {
					while (!tareasPendientes.isEmpty()) {
						Runnable r = tareasPendientes.remove(0);
						r.run();
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						break;
					}
				}
				hilo = null;
				System.out.println("Cierre de hilo.");
			}
		};
		hilo.start();
	}

	private static Exception lastError = null; // Información de último error SQL ocurrido

	/**
	 * Inicializa una BD SQLITE y devuelve una conexión con ella
	 * 
	 * @param nombreBD
	 *            Nombre de fichero de la base de datos
	 * @return Conexión con la base de datos indicada. Si hay algún error, se
	 *         devuelve null
	 */
	public static Connection initBD(String nombreBD) {
		if (hilo == null)
			initHilo();
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);
			log(Level.INFO, "Conectada base de datos " + nombreBD, null);
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			lastError = e;
			log(Level.SEVERE, "Error en conexión de base de datos " + nombreBD, e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Devuelve statement para usar la base de datos
	 * 
	 * @param con
	 *            Conexión ya creada y abierta a la base de datos
	 * @return sentencia de trabajo si se crea correctamente, null si hay cualquier
	 *         error
	 */
	public static Statement usarBD(Connection con) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg
			return statement;
		} catch (SQLException e) {
			lastError = e;
			log(Level.SEVERE, "Error en uso de base de datos", e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Crea las tablas de la base de datos. Si ya existen, las deja tal cual
	 * 
	 * @param con
	 *            Conexión ya creada y abierta a la base de datos
	 * @return sentencia de trabajo si se crea correctamente, null si hay cualquier
	 *         error
	 */
	public static Statement usarCrearTablasBD(Connection con) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg
			try {
				statement.executeUpdate(
						"create table puntuacion " + "(nombre string, casillas integer, segundos integer)");
			} catch (SQLException e) {
			} // Tabla ya existe. Nada que hacer
			log(Level.INFO, "Creada base de datos", null);
			return statement;
		} catch (SQLException e) {
			lastError = e;
			log(Level.SEVERE, "Error en creación de base de datos", e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Reinicia en blanco las tablas de la base de datos. UTILIZAR ESTE MËTODO CON
	 * PRECAUCIÓN. Borra todos los datos que hubiera ya en las tablas
	 * 
	 * @param con
	 *            Conexión ya creada y abierta a la base de datos
	 * @return sentencia de trabajo si se borra correctamente, null si hay cualquier
	 *         error
	 */
	public static Statement reiniciarBD(Connection con) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // poner timeout 30 msg
			statement.executeUpdate("drop table if exists puntuacion");
			log(Level.INFO, "Reiniciada base de datos", null);
			return usarCrearTablasBD(con);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error en reinicio de base de datos", e);
			lastError = e;
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Cierra la base de datos abierta y cierra el hilo de proceso de base de datos
	 * 
	 * @param con
	 *            Conexión abierta de la BD
	 * @param st
	 *            Sentencia abierta de la BD
	 */
	public static void cerrarBD(final Connection con, final Statement st) {
		tareasPendientes.add(new Runnable() {
			@Override
			public void run() {
				try {
					if (st != null)
						st.close();
					if (con != null)
						con.close();
					log(Level.INFO, "Cierre de base de datos", null);
				} catch (SQLException e) {
					lastError = e;
					log(Level.SEVERE, "Error en cierre de base de datos", e);
					e.printStackTrace();
				}
				if (hilo != null)
					hilo.interrupt();
			}
		});
	}

	/**
	 * Devuelve la información de excepción del último error producido por
	 * cualquiera de los métodos de gestión de base de datos
	 */
	public static Exception getLastError() {
		return lastError;
	}

	// 111
	public static void insertarNuevaPuntuacion(Statement st, Puntuacion p) {
		tareasPendientes.add(new Runnable() {
			@Override
			public void run() {
				String sentSQL = "";
				try {
					sentSQL = "INSERT INTO puntuacion (nombre,casillas, segundos) VALUES ('" + p.getUsuario() + "',"
							+ p.getPuntuacion() + "," + p.getSegundos() + ")";
					int val = st.executeUpdate(sentSQL);
					log(Level.INFO, "BD añadida " + val + " fila\t" + sentSQL, null);
					if (val != 1) { // Se tiene que añadir 1 - error si no
						log(Level.SEVERE, "Error en insert de BD\t" + sentSQL, null);
					}
				} catch (SQLException e) {
					log(Level.SEVERE, "Error en BD\t" + sentSQL, e);
					lastError = e;
					e.printStackTrace();
				}
			}
		});

	}

	// 1
	public static ArrayList<Puntuacion> obtenerPuntuaciones(Statement st, String nombre) {
		ArrayList<Puntuacion> aPuntuaciones = new ArrayList<Puntuacion>();
		String sentSQL = "SELECT * FROM puntuacion";
		if(nombre != null && nombre.length() > 0)
			sentSQL += " WHERE nombre = '"+nombre+"'";
		try {
			ResultSet rs = st.executeQuery(sentSQL);
			while (rs.next()) {
				Puntuacion p = new Puntuacion(rs.getString("nombre"), rs.getInt("casillas"), rs.getInt("segundos"));
				aPuntuaciones.add(p);
			}
			log(Level.INFO, "BD Tabla puntuaciones registros obtenidos "+aPuntuaciones.size()  + "\t" + sentSQL, null);
			rs.close();
		} catch (SQLException e) {
			log(Level.SEVERE, "Error en BD\t" + sentSQL, e);
			lastError = e;
			e.printStackTrace();
		}
		return aPuntuaciones;
	}
	
	public static ResultSet obtenerPuntuacionesResultSet(Statement st, String nombre) {
		String sentSQL = "SELECT nombre, casillas, segundos FROM puntuacion";
		ResultSet rs = null;
		if(nombre != null && nombre.length() > 0)
			sentSQL += " WHERE nombre = '"+nombre+"'";
		try {
			rs = st.executeQuery(sentSQL);
			log(Level.INFO, "BD Tabla puntuaciones registros obtenidos" + "\t" + sentSQL, null);
			rs.close();
		} catch (SQLException e) {
			log(Level.SEVERE, "Error en BD\t" + sentSQL, e);
			lastError = e;
			e.printStackTrace();
		}
		return rs;
	}

	private static Logger logger = null;

	// Método público para asignar un logger externo
	/**
	 * Asigna un logger ya creado para que se haga log de las operaciones de base de
	 * datos
	 * 
	 * @param logger
	 *            Logger ya creado
	 */
	public static void setLogger(Logger logger) {
		BD.logger = logger;
	}

	// Método local para loggear (si no se asigna un logger externo, se asigna uno
	// local)
	private static void log(Level level, String msg, Throwable excepcion) {
		if (logger == null) { // Logger por defecto local:
			logger = Logger.getLogger(BD.class.getName()); // Nombre del logger - el de la clase
			logger.setLevel(Level.ALL); // Loguea todos los niveles
			try {
				// logger.addHandler( new FileHandler( "bd-" + System.currentTimeMillis() +
				// ".log.xml" ) ); // Y saca el log a fichero xml
				logger.addHandler(new FileHandler("bd.log.xml", true)); // Y saca el log a fichero xml
			} catch (Exception e) {
				logger.log(Level.SEVERE, "No se pudo crear fichero de log", e);
			}
		}
		if (excepcion == null)
			logger.log(level, msg);
		else
			logger.log(level, msg, excepcion);
	}
}
