package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class FrmBoleta extends JDialog {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBoleta dialog = new FrmBoleta();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmBoleta() {
		setTitle("Venta y Boleta");
		setBounds(100, 100, 690, 487);
		getContentPane().setLayout(null);
		
		JPanel pBoleta = new JPanel();
		pBoleta.setBounds(0, 0, 674, 448);
		getContentPane().add(pBoleta);

	}
}
