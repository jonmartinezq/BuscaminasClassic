


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
		
			Tablero tablero = new Tablero(x,y /**dificultad**/);
			tablero = insertarVacias(tablero, x, y);	
			tablero = insertarMinas(tablero, pDificultad, x, y);
			tablero = insertarNumeros(tablero,x ,y);
			return tablero;
	}
	
		
		
			

		private Tablero insertarNumeros(Tablero tablero, int x, int y) {
			// TODO Auto-generated method stub
			return null;
			}
	
		private Tablero insertarMinas(Tablero tablero, int pDificultad, int x, int y) {
			// TODO Auto-generated method stub
			return null;
			}
	
		private Tablero insertarVacias(Tablero tablero, int x, int y) {
			// TODO Auto-generated method stub
			return null;
			}
	
	}
