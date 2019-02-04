import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;

public class VentanaPuntuaciones extends JFrame {

	private JPanel contentPane;
	private JTable tbPuntuaciones;
	boolean showAll;
	String nombre;
	private JButton btnCerrar;
	private JTextField txtPuntuacin;
	private JTextField txtDuracin;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPuntuaciones frame = new VentanaPuntuaciones("igor");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPuntuaciones(String nombre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(56, 371, 424, 27);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnMisPuntuaciones = new JButton("Mis Puntuaciones");
		btnMisPuntuaciones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (showAll) {
					showAll = false;
					cargarPuntuacionesDesdeArray();
					btnMisPuntuaciones.setText("Mostrar todas");
				} else {
					showAll = true;
					cargarPuntuacionesDesdeArray();
					btnMisPuntuaciones.setText("Mis Puntuaciones");
				}
			}
		});
		btnMisPuntuaciones.setBounds(282, 0, 132, 23);
		panel.add(btnMisPuntuaciones);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCerrar.setBounds(10, 0, 132, 23);
		panel.add(btnCerrar);

		tbPuntuaciones = new JTable();
		tbPuntuaciones.setBounds(10, 23, 523, 340);
		contentPane.add(tbPuntuaciones);
		
		txtPuntuacin = new JTextField();
		txtPuntuacin.setText("               Puntuaci\u00F3n");
		txtPuntuacin.setBounds(193, 0, 156, 20);
		contentPane.add(txtPuntuacin);
		txtPuntuacin.setColumns(10);
		
		txtDuracin = new JTextField();
		txtDuracin.setText("         Duraci\u00F3n (Segundos)");
		txtDuracin.setColumns(10);
		txtDuracin.setBounds(377, 0, 156, 20);
		contentPane.add(txtDuracin);
		
		txtNombre = new JTextField();
		txtNombre.setText("                 Nombre");
		txtNombre.setColumns(10);
		txtNombre.setBounds(10, 0, 156, 20);
		contentPane.add(txtNombre);
		showAll = true;
		this.nombre = nombre;
		// cargarPuntuaciones();

		cargarPuntuacionesDesdeArray();
	}

	private void cargarPuntuacionesDesdeArray() {
		Connection con = BD.initBD("buscaminas.bd");
		Statement st = BD.usarBD(con);
		ArrayList<Puntuacion> puntuaciones = null;
		if (showAll)
			puntuaciones = BD.obtenerPuntuaciones(st, null);
		else {
			puntuaciones = BD.obtenerPuntuaciones(st, nombre);
		}
		String[] columnas = { "nombre", "casillas", "segundos" };
		DefaultTableModel dtm = new DefaultTableModel(columnas, 0);
		for (Puntuacion p : puntuaciones) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(p.getUsuario());
			vector.add(p.getPuntuacion());
			vector.add(p.getSegundos());
			dtm.addRow(vector);
		}
		tbPuntuaciones.setModel(dtm);
		
	}

	private void cargarPuntuaciones() {
		Connection con = BD.initBD("buscaminas.bd");
		Statement st = BD.usarBD(con);
		ResultSet rs = null;
		if (showAll)
			rs = BD.obtenerPuntuacionesResultSet(st, null);
		else {
			rs = BD.obtenerPuntuacionesResultSet(st, nombre);
		}
		try {
			tbPuntuaciones.setModel(buildTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);

	}
}
