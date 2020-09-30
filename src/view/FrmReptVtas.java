package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

public class FrmReptVtas extends JDialog {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReptVtas dialog = new FrmReptVtas();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmReptVtas() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblReporteVentas = new JLabel("Reporte de Ventas");
		lblReporteVentas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblReporteVentas.setBounds(10, 11, 145, 22);
		panel.add(lblReporteVentas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 414, 162);
		panel.add(scrollPane);
		
		JTextArea txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		JButton btnReporte = new JButton("Generar Reporte");
		btnReporte.setBounds(268, 38, 137, 39);
		panel.add(btnReporte);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 44, 159, 22);
		panel.add(dateChooser);

	}
}
