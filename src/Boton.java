import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;


@SuppressWarnings("deprecation")
public class Boton extends JButton implements Observer{

	//Atributos
	int x;
	int y;

	//Constructora
	public Boton(int px, int py){
		
		x= px;
		y= py;
		this.setIcon(new ImageIcon(Boton.class.getResource("10.png")));
		this.addMouseListener(new MouseListener()
		{


			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1)
				{
					Buscaminas.getBuscaminas().abrirCasilla(x, y);
				}
				else if (e.getButton()==MouseEvent.BUTTON3)
				{
					Buscaminas.getBuscaminas().marcarCasilla(x, y);	
				}

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		int temp =(Integer)arg;
		switch (temp) {
		case 0: this.setIcon(new ImageIcon(Boton.class.getResource("0.png"))); break;
		case 1: this.setIcon(new ImageIcon(Boton.class.getResource("1.png"))); break;
		case 2: this.setIcon(new ImageIcon(Boton.class.getResource("2.png"))); break;
		case 3: this.setIcon(new ImageIcon(Boton.class.getResource("3.png"))); break;
		case 4: this.setIcon(new ImageIcon(Boton.class.getResource("4.png"))); break;
		case 5: this.setIcon(new ImageIcon(Boton.class.getResource("5.png"))); break;
		case 6: this.setIcon(new ImageIcon(Boton.class.getResource("6.png"))); break;
		case 7: this.setIcon(new ImageIcon(Boton.class.getResource("7.png"))); break;
		case 8: this.setIcon(new ImageIcon(Boton.class.getResource("8.png"))); break;
		case 9: this.setIcon(new ImageIcon(Boton.class.getResource("9.png"))); break;
		case 10:this.setIcon(new ImageIcon(Boton.class.getResource("true.png"))); break;
		case 11:this.setIcon(new ImageIcon(Boton.class.getResource("10.png"))); break;
		}
		updateUI();	
	}

	



}
