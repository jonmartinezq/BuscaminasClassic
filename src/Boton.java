import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Boton extends JButton implements Observer{

	//Atributos
	int x;
	int y;

	//Constructor
	public Boton(int px, int py){
		
		x= px;
		y= py;
		this.setIcon(new ImageIcon(Boton.class.getResource("/Img/10.png")));
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
		// TODO Auto-generated method stub
		
	}


}
