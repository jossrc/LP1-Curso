package hilos;

import view.Logueo;

public class HiloLogueo extends Thread {
	public void run() {
		for (int i = 10; i >= 0; i--) {
			Logueo.lblTiempo.setText(i + "s");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Hubo un problema en la pausa : " + e.getMessage());
			}

		}
	}
}
