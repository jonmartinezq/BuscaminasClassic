

public class CasillaVacia extends Casilla {
	
	//Atributos
	
	
	//Constructor
	public CasillaVacia() {
		
	}
	
	//Metodos
	public void destapar(int pX, int pY){
		if (tapada && !marcada){
			tapada = false;
			System.out.println("Hola, soy una Casilla Vacía");
			Buscaminas.getBuscaminas().decrementar();
			Buscaminas.getBuscaminas().destaparVecinos(pX, pY);
			this.setChanged();
			
			}
		}
		
	}
