package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class FrmRepUsuarios extends JDialog {

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
					FrmRepUsuarios dialog = new FrmRepUsuarios();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmRepUsuarios() {
		setTitle("Reporte de Usuarios");
		setBounds(100, 100, 573, 395);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 557, 363);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("LISTADO DE USUARIOS");
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.WHITE);		
		lblTitulo.setBackground(new Color(86, 203, 244 ));
		lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 537, 39);
		panel.add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 537, 228);
		panel.add(scrollPane);
		
		JTextArea txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		JButton btnReporte = new JButton("REPORTE");
		btnReporte.setForeground(Color.WHITE);
		btnReporte.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnReporte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReporte.setContentAreaFilled(false);
		btnReporte.setOpaque(true);
		btnReporte.setBorder(null);
		btnReporte.setBackground(new Color(162, 164, 165));
		btnReporte.setBounds(219, 308, 118, 37);
		panel.add(btnReporte);

	}
}
