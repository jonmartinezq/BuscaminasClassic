import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class InterfazTablero {
	
	private JMenuBar menuBar;
	private JMenu mnDificultad;
	private JMenuItem Facil, Normal, Dificil;
	private boolean facil, normal, dificil;
	private static InterfazTablero miInterfazTablero  = new InterfazTablero();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String user=JOptionPane.showInputDialog(null, "", "Usuario", JOptionPane.INFORMATION_MESSAGE);
					Buscaminas.getBuscaminas().setUsuario(user);
					Cronometro.getCronometro().iniciarCronometro();
					miInterfazTablero.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	private InterfazTablero(){
		
	}
	
	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		//Mal
	}
	
	public void volverAJugar(){
		
	}
	
	
}
