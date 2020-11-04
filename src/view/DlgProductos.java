package view;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class DlgProductos extends JDialog {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgProductos dialog = new DlgProductos();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DlgProductos() {
		setTitle("Buscar Productos");
		setBounds(100, 100, 480, 432);
		getContentPane().setLayout(null);

	}

}
