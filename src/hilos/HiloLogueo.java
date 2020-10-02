package hilos;

import java.awt.Color;
import java.awt.Font;

import view.Logueo;

public class HiloLogueo extends Thread {
	public void run() {
		for (int i = 10; i >= 0; i--) {
			
			if(i <= 4) {
				Logueo.lblTiempo.setFont(new Font("Tahoma", Font.BOLD, 12));
				Logueo.lblTiempo.setForeground(Color.RED);
			}			
			
			Logueo.lblTiempo.setText(i + "s");
			
			if (i == 0) {
				System.exit(0);
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Hubo un problema en la pausa : " + e.getMessage());
			}

		}
	}
}
