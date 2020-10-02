package hilos;

import java.text.SimpleDateFormat;
import java.util.Date;

import view.FrmPrincipal;

public class HiloReloj extends Thread {
	public void run() {
		while(true) {			
			Date fecha = new Date();
			
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			FrmPrincipal.lblReloj.setText(sdf.format(fecha));
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {				
				System.out.println("Error en la pausa del reloj");
			}
		}
	}
}
