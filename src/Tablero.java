
import javax.swing.JOptionPane;
import java.util.Observer;

public class Tablero {
		//Falta dificultad
		//Atributos
	private Casilla[][] tablaCasillas;
	private int x;
	private int y;
	private int casillasSinMina;
	
		//Constructor
	public Tablero(int pX,int pY){
		tablaCasillas = new Casilla[pX][pY];
		x = pX;
		y = pY;
		
	}
	
		//metodos
	public void destaparMinas(){
		for (int i=0 ; i<=x-1 ; i++){
			for (int j=0 ; j<=y-1 ; j++){
				if(esMina(i,j)){
					tablaCasillas[i][j].mostrar();
				}
			}
		}
		Cronometro.getCronometro().pararCronometro();
		JOptionPane.showMessageDialog(null,"Has perdido");
	}
	
	
	
	public void insertarCasilla(int pLongitud, int pAltura, Casilla unaCasilla){		
		tablaCasillas[pLongitud][pAltura] = unaCasilla;
	}
	
	
	
	public int numMinas(int pNum){	
		return (x*pNum);
	}
	
	
	public boolean esMina(int pX, int pY){
		if((0<=pX && pX<=x-1) && (0<=pY && pY<=x-1)){
			if(tablaCasillas[pX][pY] instanceof CasillaMina){
				return true;
			}
		}
		return false;
	}
	
	
	public void destapar(int pX, int pY){

		if((0<=pX && pX<=x-1) && (0<=pY && pY<=y-1)){
			tablaCasillas[pX][pY].destapar(pX, pY);	
		}

	}
	
	public void marcar(int pX , int pY){
		if((0<=pX && pX<=x-1) && (0<=pY && pY<=y-1)){
			tablaCasillas[pX][pY].marcar(pX, pY);	
		}

	}
	
	public void destaparVecinos(int px, int py){
		
		this.destapar(px+1,py);
		this.destapar(px+1,py-1);
		this.destapar(px,py-1);
		this.destapar(px-1,py-1);
		this.destapar(px-1,py);
		this.destapar(px-1,py+1);
		this.destapar(px,py+1);
		this.destapar(px+1,py+1);
	}
	
	public void decrementar(){
		casillasSinMina--;
		if(casillasSinMina<=1){
			int punt = Cronometro.getCronometro().pararCronometro();
			JOptionPane.showMessageDialog(null,"Has ganado");
			Buscaminas.getBuscaminas().terminarPartida(punt);
		}
	}
	
	public void anadirObserver(Observer pObservador, int x, int y){
		this.tablaCasillas[x][y].addObserver(pObservador);
	}
	


}
