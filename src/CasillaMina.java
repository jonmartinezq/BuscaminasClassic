

public class CasillaMina extends Casilla{
	
	//Atributos
	
	//Constructor
	public CasillaMina() {
	}
	
	//M�todos
	public void destapar(int pX, int pY){
		if(tapada && !marcada){
			System.out.println("Hola, soy una Casilla Mina");
			Buscaminas.getBuscaminas().destaparMinas();
			Buscaminas.getBuscaminas().terminarPartida(0);
		}
	}
	
	
	public void mostrar()
	{
		tapada = false;
		marcada = false;
		this.setChanged();
	
	}

}
