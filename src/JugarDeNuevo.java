

import javax.swing.JFrame;
import javax.swing.JButton;


import java.awt.Font;


import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JugarDeNuevo extends JFrame {
	
	public JugarDeNuevo(String nombre) {
		setTitle("¡Fin del Juego!");
		this.setLocationRelativeTo(InterfazTablero.getInterfazTablero());


		
		JButton btnNewButton = new JButton("Si");
		btnNewButton.setBounds(73, 88, 99, 34);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				InterfazTablero.getInterfazTablero().volverAJugar();
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("No");
		btnNewButton_1.setBounds(227, 88, 99, 34);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPuntuaciones v = new VentanaPuntuaciones(nombre);
				v.setVisible(true);
			}
		});
		getContentPane().add(btnNewButton_1);
		
		JLabel label_volver_jugar = new JLabel("¿Quieres volver a jugar?");
		label_volver_jugar.setBounds(112, 11, 173, 50);
		label_volver_jugar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_volver_jugar.setEnabled(false);
		getContentPane().add(label_volver_jugar);
		
	}
}
