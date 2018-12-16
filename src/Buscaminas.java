

import java.io.IOException;
import java.util.Observer;

import javax.swing.JOptionPane;

public class Buscaminas {
	//Atributos
	private static Buscaminas miBuscaminas = new Buscaminas();
	private Tablero tablero;
	private String usuarioActual;
	private int dificultadActual;
	private Puntuaciones punt;


	//Constructor
	private Buscaminas(){
	}


	//Métodos
	public static Buscaminas getBuscaminas(){
		return miBuscaminas;
	}


	public void terminarPartida(int p){

		tablero=null;
		switch(dificultadActual)
		{
		case 1:punt = PuntuacionesFacil.getPuntuacionesFacil();break;
		case 2:punt = PuntuacionesMedio.getPuntuacionesMedio();break;
		case 3:punt = PuntuacionesDificil.getPuntuacionesDificil();break;
		}
		if (p!=0)
		{			
			punt.anadirPuntuacion(new Puntuacion(usuarioActual,p));
			try {
				punt.escribirPuntuaciones();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String ps =punt.mostrarPuntuaciones();
		JOptionPane.showMessageDialog(null,ps, "Puntuaciones " + 1, JOptionPane.INFORMATION_MESSAGE, null);

		
		JugarDeNuevo frame = new JugarDeNuevo();
		frame.setVisible(true);
		frame.setSize(400, 275);
		frame.setResizable(false);


		}

		public void crearTablero(int pDificultad){
			tablero = Builder.getBuilder().crearTablero(pDificultad);
			this.dificultadActual=pDificultad;
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
	
		
		public void setUsuario(String u)
		{
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