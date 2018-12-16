import java.awt.Color;

import javax.swing.JLabel;

public class Cronometro extends JLabel implements Runnable{
	private boolean terminar;
	private int segundos;
	private Thread hilo;
	private static Cronometro miCronometro = new Cronometro();
	
	private Cronometro(){
		this.terminar = true;
        setHorizontalAlignment( JLabel.CENTER );
        setForeground( Color.RED );
        setOpaque( true );
        setVisible(true);
	}

	public static Cronometro getCronometro(){
		return miCronometro;
	}

	public void iniciarCronometro(){
		terminar = false;
		segundos = 0;
		hilo = new Thread( this );
		hilo.start();
	}	
	
	public int pararCronometro(){
		terminar = true;
		hilo.interrupt();
		return segundos;
	}


	@Override
	public void run() {
		try{
			String tiempo = "";
			
			while (!terminar){
				Thread.sleep(1000);
				segundos++;
				tiempo = "" + segundos;
				this.setText(tiempo);
			}
		}
		catch(Exception e){
			segundos = 0;
		}
		
	}

}
