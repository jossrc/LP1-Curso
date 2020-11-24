package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRptVentas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRptVentas frame = new FrmRptVentas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmRptVentas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnReportes = new JButton("Consultar");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReportes.setBounds(295, 39, 89, 23);
		contentPane.add(btnReportes);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(80, 39, 164, 20);
		contentPane.add(dateChooser);
		
		JLabel lblFecha = new JLabel("Fecha :");
		lblFecha.setBounds(10, 40, 60, 21);
		contentPane.add(lblFecha);
		
		JTextArea txtSalida = new JTextArea();
		txtSalida.setText("num boleta, fecha de operacion, total de la boleta, \r\nnombre del cliente");
		txtSalida.setBounds(10, 73, 414, 177);
		contentPane.add(txtSalida);
		
		JLabel lblReporteDeVentas = new JLabel("Reporte de Ventas por Fecha :");
		lblReporteDeVentas.setBounds(10, 0, 251, 29);
		contentPane.add(lblReporteDeVentas);
	}
}
