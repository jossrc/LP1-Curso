package view;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class FrmRegCli extends JDialog {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegCli dialog = new FrmRegCli();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmRegCli() {
		setBounds(100, 100, 506, 350);

	}

}
