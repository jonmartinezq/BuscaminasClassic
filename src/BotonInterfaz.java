import javax.swing.JPanel;
import java.awt.GridLayout;



public class BotonInterfaz extends JPanel {
	
	private static final long serialVersionUID = 1L;
	//Atributos
	private Boton [][] arraybotones; 
	int x;
	int y;
	
	
	//Constructor
	public BotonInterfaz(int pX, int pY){
		x = pX;
		y = pY;
		crearBotones();
	}
	
	
	
	//Métodos	
	public void crearBotones(){
		arraybotones = new Boton [x][y];
		setLayout(new GridLayout(x,y,0,0));
		for(int i=0; i<x; i++){
			for(int j=0; j<y; j++){
				Boton boton= new Boton(i, j);
				arraybotones[i][j]= boton;
				add(arraybotones[i][j]);
				Buscaminas.getBuscaminas().anadirObserver(boton, i, j);		
			}
		}
	}
	
}
