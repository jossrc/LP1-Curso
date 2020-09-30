package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class FrmRegProd extends JDialog {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegProd dialog = new FrmRegProd();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmRegProd() {
		setBounds(100, 100, 506, 388);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 490, 349);
		getContentPane().add(panel);
		panel.setLayout(null);

	}
}
