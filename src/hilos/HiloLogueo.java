package hilos;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

import view.Logueo;

public class HiloLogueo extends Thread {
	
	private JFrame login;
	
	public HiloLogueo(JFrame login) {
		this.login = login;
	}
	
	public void run() {
		for (int i = 10; i >= 0; i--) {
			
			if(i <= 4) {
				Logueo.lblTiempo.setFont(new Font("Tahoma", Font.BOLD, 12));
				Logueo.lblTiempo.setForeground(Color.RED);
			}			
			
			Logueo.lblTiempo.setText(i + "s");			

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Hubo un problema en la pausa : " + e.getMessage());
			}

		}
		login.dispose();
	}
}
