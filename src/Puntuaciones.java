

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public abstract class Puntuaciones {

	protected Puntuacion[]	lista;

	//	public Puntuaciones(){
	//Puntuaciones("pFacil.txt");
	//	}

	public Puntuaciones() {

	}

	public void anadirPuntuacion(Puntuacion p){
		
		Puntuacion aux= null;
		int i = 4;
		
		if (lista[0]==null)
		{
			lista[0]=p;
		}
		else
		{

			if (lista[4] == null) 
			{

				while (lista[i] == null)
				{
					if(i > 0)
					{
						i = i - 1;
					}
				}
				
				lista[i+1] = p;
				
				while (i >= 0 && lista[i].getPuntuacion() > p.getPuntuacion())
				{
					aux = lista[i];
					lista[i] = lista[i+1];
					lista[i+1] = aux;	
					i--;
				}
				

			}

			else

			{
				if (p.getPuntuacion() < lista[4].getPuntuacion()) {
					lista[4] = p;
					i--;
					
					while (i >= 0 && lista[i].getPuntuacion() > p.getPuntuacion())
					{
						aux = lista[i];
						lista[i] = lista[i+1];
						lista[i+1] = aux;	
						i--;
					}
					
				}

			}
		}
	}

	

	protected void cargarPuntuaciones(String pFileName) 
	{
		InputStream in = getClass().getResourceAsStream(pFileName);
		BufferedReader fichero = new BufferedReader(new InputStreamReader(in));
		Scanner sc = new Scanner(fichero);
		if  (sc.hasNextLine())
		{
			String linea = sc.nextLine();
			String[] sp = linea.split("/");
			int i=0;
			int j=0;
			while (i < sp.length-1)
			{
				String user = sp[i];
				String puntuacion = sp[i+1];
				this.lista[j]= new Puntuacion(user,Integer.parseInt(puntuacion));
				i=i+2;
				j = j+1;
			}

		}
		sc.close();
	}

	public String mostrarPuntuaciones()
	{
		String ps = "";
		int i = 0;
		while(i<=4 && lista[i] != null)
		{
			ps = ps + lista[i].getUsuario()+"   "+lista[i].getPuntuacion()+"\n";
			i++;
		}
		return ps;
	}
	
	public void escribirPuntuaciones() throws IOException
	{

	}
	
}

