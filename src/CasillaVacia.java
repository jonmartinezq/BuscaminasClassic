

public class CasillaVacia extends Casilla {
	
	//Ser�a m�s eficiente incluir este tipo de casilla en la propia CasillaNumero, para evitar redundancias (Consejo de Andoni), retocar en un futuro
	
	
	//Constructor
	public CasillaVacia() {
		
	}
	
	//Metodos
	public void destapar(int pX, int pY){
		if (tapada && !marcada){
			tapada = false;
			System.out.println("Hola, soy una Casilla Vac�a");
			Buscaminas.getBuscaminas().decrementar();
			Buscaminas.getBuscaminas().destaparVecinos(pX, pY);
			this.setChanged();
			
			}
		}
		
	}
