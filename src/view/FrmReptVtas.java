package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class FrmReptVtas extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private JDateChooser txtFecha;
	private JTextArea txtS;
	private JButton btnReporte;

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
		setModal(true);
		setTitle("Reporte de Ventas");
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
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnReporte = new JButton("Generar Reporte");
		btnReporte.setBounds(268, 38, 137, 39);
		panel.add(btnReporte);
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(10, 44, 159, 22);
		panel.add(txtFecha);		

		btnReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generarReporte();
			}
		});
	}
	
	private void generarReporte() {		
		
		String fecha = leerFecha();
		
		if (fecha != null) {
			txtS.setText("Reporte del : " + fecha);
		}
	}
	
	private String leerFecha() {
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return sdf.format(txtFecha.getDate());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Seleccione una fecha válida", "Aviso", 2);
			return null;
		}
	}

}
