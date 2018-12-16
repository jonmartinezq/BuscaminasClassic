

public class CasillaNumero extends Casilla {
	
	//Atributos
	private int numero;
	
	//Constructor
	public CasillaNumero() {
		
	}
	
	//Metodos
	public void destapar(int pX, int pY){
		if (tapada && !marcada){
			tapada= false;
			System.out.println("Hola, soy una Casilla numero");
			this.setChanged();
			this.notifyObservers(numero);
			Buscaminas.getBuscaminas().decrementar();
		}
	}	
	
	public void setNumero (int pNumero){
		numero= pNumero;
	}
	
	
}