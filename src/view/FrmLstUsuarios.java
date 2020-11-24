package view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FrmLstUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLstUsuarios frame = new FrmLstUsuarios();
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
	public FrmLstUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Listado de Productos");
		lblTitulo.setBounds(22, 11, 183, 24);
		contentPane.add(lblTitulo);
		
		txtS = new JTextArea();
		txtS.setBounds(10, 51, 414, 155);
		contentPane.add(txtS);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// llamar al método
				listado();
			}
		});
		btnListado.setBounds(22, 227, 89, 23);
		contentPane.add(btnListado);
		
		JButton btnPdf = new JButton("PDF");
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imprimePDF();
			}
		});
		btnPdf.setBounds(121, 227, 89, 23);
		contentPane.add(btnPdf);
	}
	String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	
	void imprimePDF() {
		
	}
	
	
	
	void listado(){
		
	}
}



