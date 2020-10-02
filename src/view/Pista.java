package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Pista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pista frame = new Pista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Pista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 619, 316);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPlayer1 = new JLabel("");
		lblPlayer1.setIcon(new ImageIcon(Pista.class.getResource("/img/horsea.png")));
		lblPlayer1.setBounds(10, 11, 87, 93);
		panel.add(lblPlayer1);
		
		JLabel lblPlayer2 = new JLabel("");
		lblPlayer2.setIcon(new ImageIcon(Pista.class.getResource("/img/horsea.png")));
		lblPlayer2.setBounds(10, 150, 87, 93);
		panel.add(lblPlayer2);
		
		JLabel lblMeta = new JLabel("");
		lblMeta.setIcon(new ImageIcon(Pista.class.getResource("/img/meta.png")));
		lblMeta.setBounds(560, 11, 49, 258);
		panel.add(lblMeta);
		
		JButton btnComenzar = new JButton("Comenzar");
		btnComenzar.setBounds(186, 282, 89, 23);
		panel.add(btnComenzar);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBounds(336, 282, 89, 23);
		panel.add(btnReiniciar);
	}
}
