

import java.util.Random;

public class Builder {
		
		//Atributos
	private static Builder miBuilder = new Builder();
	
	
		//Constructor
	private Builder(){
	}

	
		//Métodos
	public static Builder getBuilder(){
		return miBuilder;
	}
	
	
	public Tablero crearTablero(int pDificultad){
		int x;
		int y;
		
		if (pDificultad==1){
			x = 7;
			y = 10;
		}
		else{
			if (pDificultad==2){
				x = 10;
				y = 15;
			}
			else{
				x = 12;
				y = 25;
			}
		}
		
		
		Tablero tablero = new Tablero(x,y,pDificultad);
		tablero = insertarVacias(tablero, x, y);	
		tablero = insertarMinas(tablero, pDificultad, x, y);
		tablero = insertarNumeros(tablero,x ,y);
		return tablero;
	}
	
	
	private Tablero insertarVacias(Tablero pTablero, int x, int y){
		
		Casilla unaCasilla= null;
		
		for (int i=0 ; i<=x-1 ; i++){
			for (int j=0 ; j<=y-1 ; j++){
				unaCasilla= Factory.getFactory().crearCasilla("vacia");
				pTablero.insertarCasilla(i,j, unaCasilla);
			}
		}
		return pTablero;
	}
	
	
	private Tablero insertarMinas(Tablero pTablero, int pNum, int alt, int lon){
		Random x = new Random();
		Random y = new Random();
		int posX;
		int posY;

		int numMinas = pTablero.numMinas(pNum);
		Casilla unaCasilla= null;
		
		while (numMinas>=0){
			posX = x.nextInt(alt);
			posY = y.nextInt(lon);
			if(!pTablero.esMina(posX, posY)){
				unaCasilla= Factory.getFactory().crearCasilla("mina");
				pTablero.insertarCasilla(posX, posY, unaCasilla);
				numMinas--;
			}
		}
		return pTablero;
	}
	
	
	private Tablero insertarNumeros(Tablero pTablero, int x, int y){
		int cont = 0;
		Casilla unaCasilla= null;
		
		for (int i=0 ; i<=x-1 ; i++){
			for (int j=0 ; j<=y-1 ; j++){
				cont = 0;
				if(!pTablero.esMina(i, j)){
					if(pTablero.esMina(i-1, j)){
						cont++;
					}
					if(pTablero.esMina(i-1, j+1)){
						cont++;
					}
					if(pTablero.esMina(i, j+1)){
						cont++;
					}
					if(pTablero.esMina(i+1, j+1)){
						cont++;
					}
					if(pTablero.esMina(i+1, j)){
						cont++;
					}
					if(pTablero.esMina(i+1, j-1)){
						cont++;
					}
					if(pTablero.esMina(i, j-1)){
						cont++;
					}
					if(pTablero.esMina(i-1, j-1)){
						cont++;
					}
					
					if(cont>0){
						unaCasilla= Factory.getFactory().crearCasilla("numero");
						((CasillaNumero)unaCasilla).setNumero(cont);
						pTablero.insertarCasilla(i, j, unaCasilla);
					}
				}
			}
		}
		return pTablero;
	}
	
}

