

//import javax.swing.JOptionPane;

public class Tablero {
	
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
	/**
		//metodos
	public void destaparMinas(){
		for (int i=0 ; i<=x-1 ; i++){
			for (int j=0 ; j<=y-1 ; j++){
				if(esMina(i,j)){
					tablaCasillas[i][j].mostrar();
				}
			}
		}
	}
		
	
	public void insertarCasilla(int pLongitud, int pAltura, Casilla unaCasilla){		
		tablaCasillas[pLongitud][pAltura] = unaCasilla;
	}
	
	
	
	public int numMinas(int pNum){	
		return (x*pNum);
	}
	
	
	public boolean esMina(){
		
		return false;
	}
	
	
	public void destapar(){
		

	}
	
	public void marcar(){
		

	}

	**/
	


}
