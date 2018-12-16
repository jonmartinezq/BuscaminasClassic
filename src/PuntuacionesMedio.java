

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PuntuacionesMedio extends Puntuaciones{
	private static PuntuacionesMedio miPuntuacionesMedio;

	private PuntuacionesMedio(String p){
		this.lista = new Puntuacion[5];
		cargarPuntuaciones(p);
	}
	
	public static PuntuacionesMedio getPuntuacionesMedio(){
	
		if(miPuntuacionesMedio==null)
		{
			miPuntuacionesMedio = new PuntuacionesMedio("pNormal.txt");
		}
		
		return miPuntuacionesMedio;
	}
	public void escribirPuntuaciones()throws IOException {

		int i = 0;
		String ruta = "C:\\Users\\FAMILIA FELIZ\\git\\ProyectoProgram\\Buscaminas\\src";
		File archivo = new File(ruta);
		BufferedWriter bw;
		bw = new BufferedWriter(new FileWriter(archivo));
		while(lista[i]!=null && i<5)
		{
			bw.write(lista[i].getUsuario()+"/"+String.valueOf(lista[i].getPuntuacion())+"/");
			i++;
		}


		bw.close();

	}
}
