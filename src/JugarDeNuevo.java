

import javax.swing.JFrame;
import javax.swing.JButton;


import java.awt.Font;


import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JugarDeNuevo extends JFrame {
	
	public JugarDeNuevo() {
		setTitle("¡Fin del Juego!");
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);


		
		JButton btnNewButton = new JButton("Si");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				InterfazTablero.getInterfazTablero().volverAJugar();
			}
		});
		btnNewButton.setBounds(73, 88, 99, 34);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("No");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(227, 88, 99, 34);
		getContentPane().add(btnNewButton_1);
		
		JLabel label_volver_jugar = new JLabel("¿Quieres volver a jugar?");
		label_volver_jugar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_volver_jugar.setEnabled(false);
		label_volver_jugar.setBounds(112, 11, 173, 50);
		getContentPane().add(label_volver_jugar);
		
	}
}
