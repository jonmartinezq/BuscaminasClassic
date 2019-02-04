
public class Puntuacion {
	private String usuario;
	private int punt;
	private int segundos;

	public Puntuacion(String u, int p, int segundos) {
		this.usuario = u;
		this.punt = p;
		this.segundos = segundos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public int getPuntuacion() {
		return this.punt;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setPuntuacion(int p) {
		this.punt = p;
	}

	public void setUsuario(String u) {
		this.usuario = u;
	}

	public void mostrarPuntuacion() {
		System.out.println(this.usuario + " " + String.valueOf(this.punt));
	}

	@Override
	public String toString() {
		return "Puntuacion [usuario=" + usuario + ", punt=" + punt + ", segundos=" + segundos + "]";
	}
	
	
}
