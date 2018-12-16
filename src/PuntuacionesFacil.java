

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PuntuacionesFacil extends Puntuaciones {

	private static PuntuacionesFacil miPuntuacionesFacil;

	private PuntuacionesFacil(String p){
		this.lista = new Puntuacion[5];
		cargarPuntuaciones(p);
	}

	public static PuntuacionesFacil getPuntuacionesFacil(){

		if(miPuntuacionesFacil==null)
		{
			miPuntuacionesFacil = new PuntuacionesFacil("pFacil.txt");
		}

		return miPuntuacionesFacil;
	}
	public void escribirPuntuaciones()throws IOException {


		int i = 0;
		String ruta = "C:\\Users\\FAMILIA FELIZ\\git\\ProyectoProgram\\Buscaminas\\src";
		File archivo = new File(ruta);
		BufferedWriter bw;
		bw = new BufferedWriter(new FileWriter(archivo));
		while(i<=4 && lista[i]!=null)
		{
			bw.write(lista[i].getUsuario()+"/"+String.valueOf(lista[i].getPuntuacion())+"/");
			i++;
		}


		bw.close();

	}
}
