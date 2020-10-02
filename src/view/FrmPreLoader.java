package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

public class FrmPreLoader extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPreLoader frame = new FrmPreLoader();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmPreLoader() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 91);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMensaje = new JLabel("El sistema est\u00E1 cargando, espere unos segundos");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(Color.BLUE);
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensaje.setBounds(50, 2, 303, 14);
		contentPane.add(lblMensaje);
		
		JProgressBar prbCarga = new JProgressBar();
		prbCarga.setStringPainted(true);
		prbCarga.setBounds(0, 27, 403, 19);
		contentPane.add(prbCarga);
	}
}
