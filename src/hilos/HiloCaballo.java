package hilos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import view.Pista;

public class HiloCaballo extends Thread {
	private JLabel player;
	private String nick;

	public HiloCaballo(JLabel player, String nick) {
		this.player = player;
		this.nick = nick;
	}

	public void run() {

		while (Pista.isActivo()) {
			int avance = (int) (Math.random() * 10);
			player.setLocation(player.getX() + avance, player.getY());			

			if (player.getX() + player.getWidth() > Pista.lblMeta.getX()) {
				Pista.setActivo(false);
				JOptionPane.showMessageDialog(null, "Ganó " + nick);
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Sucedió un error con el Thread : " + e.getMessage());
			}

		}

	}

}
