

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





public class InterfazTablero extends JFrame{

	private JMenuBar menuBar;
	private JMenu mnDificultad;
	private JMenuItem Facil, Normal, Dificil;
	private boolean facil, normal, dificil;
	private static InterfazTablero miInterfazTablero  = new InterfazTablero();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String user=JOptionPane.showInputDialog(null, "", "Introduzca nombre de usuario:", JOptionPane.INFORMATION_MESSAGE);
					Buscaminas.getBuscaminas().setUsuario(user);
					Cronometro.getCronometro().iniciarCronometro();
					miInterfazTablero.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private InterfazTablero() {
		
		setTitle("Buscaminas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(275, 275);
		setResizable(false);
		
		JPanel panel= new JPanel();
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(facil){
					
					Cronometro.getCronometro().pararCronometro();
					add(Cronometro.getCronometro());
					getContentPane().add(Cronometro.getCronometro(), BorderLayout.SOUTH);
					Cronometro.getCronometro().iniciarCronometro();
					
					Buscaminas.getBuscaminas().crearTablero(1);
					BotonesInterfaz i = new BotonesInterfaz(7, 10);
					getContentPane().remove(1);
					getContentPane().add(i, BorderLayout.CENTER);
					setSize(270, 270);
					setResizable(false);
					i.updateUI();
					
				}
				else if(normal){
					
					Cronometro.getCronometro().pararCronometro();
					add(Cronometro.getCronometro());
					getContentPane().add(Cronometro.getCronometro(), BorderLayout.SOUTH);
					Cronometro.getCronometro().iniciarCronometro();
					
					Buscaminas.getBuscaminas().crearTablero(2);
					BotonesInterfaz i = new BotonesInterfaz(10, 15);
					getContentPane().remove(1);
					getContentPane().add(i, BorderLayout.CENTER);
					setSize(350, 350);
					setResizable(false);
					i.updateUI();
					
				}
				else if(dificil){
					
					Cronometro.getCronometro().pararCronometro();
					add(Cronometro.getCronometro());
					getContentPane().add(Cronometro.getCronometro(), BorderLayout.SOUTH);
					Cronometro.getCronometro().iniciarCronometro();
					
					Buscaminas.getBuscaminas().crearTablero(3);
					BotonesInterfaz i = new BotonesInterfaz(12, 25);
					getContentPane().remove(1);
					getContentPane().add(i, BorderLayout.CENTER);
					setSize(500, 375);
					setResizable(false);
					i.updateUI();
					
				}
			}
		});
		button.setIcon(new ImageIcon(InterfazTablero.class.getResource("nueva.png")));
		button.setBounds(202, 11, 0, 0);
		panel.add(button);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnDificultad = new JMenu("Dificultad");
		menuBar.add(mnDificultad);
		
		Facil = new JMenuItem("Facil");
		Facil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cronometro.getCronometro().pararCronometro();
				add(Cronometro.getCronometro());
				getContentPane().add(Cronometro.getCronometro(), BorderLayout.SOUTH);
				Cronometro.getCronometro().iniciarCronometro();
				
				miInterfazTablero.setVisible(false);
				setVisible(true);
				Buscaminas.getBuscaminas().crearTablero(1);
				BotonesInterfaz i = new BotonesInterfaz(7, 10);
				getContentPane().remove(1);
				getContentPane().add(i, BorderLayout.CENTER);
				facil = true;
				normal = false;
				dificil = false;
				setSize(270, 270);
				setResizable(false);
				i.updateUI();
			}
			}
		);
		mnDificultad.add(Facil);
		
		Normal = new JMenuItem("Normal");
		Normal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cronometro.getCronometro().pararCronometro();
				add(Cronometro.getCronometro());
				getContentPane().add(Cronometro.getCronometro(), BorderLayout.SOUTH);
				Cronometro.getCronometro().iniciarCronometro();
				
				miInterfazTablero.setVisible(false);
				setVisible(true);
				Buscaminas.getBuscaminas().crearTablero(2);
				BotonesInterfaz i = new BotonesInterfaz(10, 15);
				getContentPane().remove(1);
				getContentPane().add(i, BorderLayout.CENTER);
				facil = false;
				normal = true;
				dificil = false;
				setSize(350, 350);
				setResizable(false);
				i.updateUI();
			}
		});
		mnDificultad.add(Normal);
		
		Dificil = new JMenuItem("Dificil");
		Dificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cronometro.getCronometro().pararCronometro();
				add(Cronometro.getCronometro());
				getContentPane().add(Cronometro.getCronometro(), BorderLayout.SOUTH);
				Cronometro.getCronometro().iniciarCronometro();
				
				miInterfazTablero.setVisible(false);
				setVisible(true);
				Buscaminas.getBuscaminas().crearTablero(3);
				BotonesInterfaz i = new BotonesInterfaz(12, 25);
				getContentPane().remove(1);
				getContentPane().add(i, BorderLayout.CENTER);
				facil = false;
				normal = false;
				dificil = true;
				setSize(500, 375);
				setResizable(false);
				i.updateUI();
				}
		});
		mnDificultad.add(Dificil);
		
	
			//por defecto lo crea de dificultad facil
		
		add(Cronometro.getCronometro());
		getContentPane().add(Cronometro.getCronometro(), BorderLayout.SOUTH);
		
		Buscaminas.getBuscaminas().crearTablero(1);
		BotonesInterfaz i = new BotonesInterfaz(7, 10);
		getContentPane().add(i, BorderLayout.CENTER);
		facil = true;
		normal = false;
		dificil = false;
		setSize(270, 270);
		setResizable(false);
	}
	
	public static InterfazTablero getInterfazTablero(){
		return miInterfazTablero;
	}
		
	public void volverAJugar(){
		
		if (facil){	
			
			add(Cronometro.getCronometro());
			getContentPane().add(Cronometro.getCronometro(), BorderLayout.SOUTH);
			Cronometro.getCronometro().iniciarCronometro();
			
			miInterfazTablero.setVisible(false);
			setVisible(true);
			Buscaminas.getBuscaminas().crearTablero(1);
			BotonesInterfaz i = new BotonesInterfaz(7, 10);
			getContentPane().remove(1);
			getContentPane().add(i, BorderLayout.CENTER);
			facil = true;
			normal = false;
			dificil = false;
			setSize(270, 270);
			setResizable(false);
			i.updateUI();
			
		}
		
		else if (normal){
			
			add(Cronometro.getCronometro());
			getContentPane().add(Cronometro.getCronometro(), BorderLayout.SOUTH);
			Cronometro.getCronometro().iniciarCronometro();
			
			miInterfazTablero.setVisible(true);
			Buscaminas.getBuscaminas().crearTablero(2);
			BotonesInterfaz i = new BotonesInterfaz(10, 15);
			miInterfazTablero.getContentPane().remove(1);
			miInterfazTablero.getContentPane().add(i, BorderLayout.CENTER);
			facil = false;
			normal = true;
			dificil = false;
			setSize(350, 350);
			setResizable(false);
			i.updateUI();
		}
		
		else if(dificil){
			
			add(Cronometro.getCronometro());
			getContentPane().add(Cronometro.getCronometro(), BorderLayout.SOUTH);
			Cronometro.getCronometro().iniciarCronometro();
			
			miInterfazTablero.setVisible(true);
			Buscaminas.getBuscaminas().crearTablero(3);
			BotonesInterfaz i = new BotonesInterfaz(12, 25);
			miInterfazTablero.getContentPane().remove(1);
			miInterfazTablero.getContentPane().add(i, BorderLayout.CENTER);
			facil = false;
			normal = false;
			dificil = true;
			setSize(500, 375);
			setResizable(false);
			i.updateUI();
		}
	}
	
}
	
	

