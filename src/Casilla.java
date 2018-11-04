

import java.util.Observable;

public abstract class Casilla extends Observable{

	//Atributos
	protected boolean tapada;
	protected boolean marcada;


	//Constructor
	public Casilla(){
		tapada=true;
		marcada=false;
	}


	//M�todos
	public void destapar(int pX, int pY){}

	public void mostrar(){}

	public void marcar(int px, int py)
	{
		if(tapada)
		{
			this.marcada = !this.marcada;
			if(marcada)
			{
				this.setChanged();
				
			}
			else
			{
				this.setChanged();
				
			}
		}	
	}


}
