

public class Puntuacion {
	private String	usuario;
	private int	punt;

	public Puntuacion(String u, int p) {
		usuario = u;
		punt = p;

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
	public void mostrarPuntuacion()
	{
		System.out.println(this.usuario +" "+ String.valueOf(this.punt));
	}
}
