package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.JPanel;

public class FrmRepUsuariosXTipo extends JDialog {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Throwable e) {
					e.printStackTrace();
				}
				
				try {
					FrmRepUsuariosXTipo dialog = new FrmRepUsuariosXTipo();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmRepUsuariosXTipo() {
		setTitle("Reporte Usuarios Por Tipo");
		setBounds(100, 100, 493, 558);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 477, 519);
		getContentPane().add(panel);

	}

}
