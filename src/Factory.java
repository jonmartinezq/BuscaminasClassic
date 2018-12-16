

public class Factory {
		//atributos
	private static Factory miFactory = new Factory();
	
		//constructora
	private Factory(){
	}
	
		//metodos
	public static Factory getFactory(){
		if (miFactory==null){
			miFactory= new Factory();
		}
		return miFactory;
	}
	
	
	public Casilla crearCasilla (String tipo){
		Casilla unaCasilla= null;
		
		if (tipo == "vacia"){
			unaCasilla = new CasillaVacia();
		}
		
		if (tipo == "numero"){
			unaCasilla = new CasillaNumero();
		}
		
		if (tipo== "mina"){
			unaCasilla = new CasillaMina();
		}
		
		
		return unaCasilla;
	}
}
