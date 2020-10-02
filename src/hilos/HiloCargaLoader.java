package hilos;

import view.FrmPreLoader;

public class HiloCargaLoader extends Thread {
	public void run() {
		for (int i = 0; i <= 100; i++) {
			FrmPreLoader.prbCarga.setValue(i);

			switch (i) {
			case 30:
				FrmPreLoader.lblMensaje.setText("Creando BD");
				break;
			case 60:
				FrmPreLoader.lblMensaje.setText("Diseñando GUI...");
				break;
			case 90:
				FrmPreLoader.lblMensaje.setText("Finalizando la carga de la aplicación");
				break;
			default:
				break;
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Error en la pausa de la barra : " + e.getMessage());
			}
		}
	}
}
