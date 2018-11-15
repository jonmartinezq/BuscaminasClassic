
import java.io.IOException;
import java.util.Observer;

import javax.swing.JOptionPane;

public class Buscaminas {
	//Atributos
	
	private static Buscaminas miBuscaminas = new Buscaminas();

	private String usuarioActual;
	private int dificultadActual;
	private Tablero tablero;
	



	//Constructor
	private Buscaminas(){
	}


	//Métodos
	public static Buscaminas getBuscaminas(){
		return miBuscaminas;
	}


	public void terminarPartida(int p){

	}

	public void crearTablero(int pDificultad){
		//Primero la clase Builder
	}


	public void abrirCasilla(int pX, int pY){
		if(tablero!=null)
		{
			this.tablero.destapar(pX, pY);
		}
		
	}

	
	public void marcarCasilla(int pX, int pY){
		if (tablero!=null)
			this.tablero.marcar(pX, pY);
	}

	
	public void setUsuario(String u){
		this.usuarioActual=u;
	}
	
	
	public void destaparMinas(){
		tablero.destaparMinas();
	}
	
	
	public void decrementar(){
		tablero.decrementar();
	}
	
	
	public void destaparVecinos(int px, int py){
		tablero.destaparVecinos(px, py);
	}
	public void anadirObserver(Observer pObservador, int x, int y){
		this.tablero.anadirObserver(pObservador, x, y);
	}
	
	

}