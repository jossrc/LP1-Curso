package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import hilos.HiloCaballo;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPlayer1;
	private JLabel lblPlayer2;
	public static JLabel lblMeta;
	
	private int posInitX01;
	private int posInitX02;	
	
	public static boolean activo = true;
	public static boolean isActivo() {
		return activo;
	}
	
	public static void setActivo (boolean cambia) {
		activo = cambia;
	}

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
		setTitle("Carrera de Caballitos");
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
		
		lblPlayer1 = new JLabel("");
		lblPlayer1.setIcon(new ImageIcon(Pista.class.getResource("/img/horsea.png")));
		lblPlayer1.setBounds(10, 11, 87, 93);
		panel.add(lblPlayer1);
		
		lblPlayer2 = new JLabel("");
		lblPlayer2.setIcon(new ImageIcon(Pista.class.getResource("/img/horsea.png")));
		lblPlayer2.setBounds(10, 150, 87, 93);
		panel.add(lblPlayer2);
		
		lblMeta = new JLabel("");
		lblMeta.setIcon(new ImageIcon(Pista.class.getResource("/img/meta.png")));
		lblMeta.setBounds(560, 11, 49, 258);
		panel.add(lblMeta);
		
		JButton btnComenzar = new JButton("Comenzar");		
		btnComenzar.setBounds(186, 282, 89, 23);
		panel.add(btnComenzar);
		
		JButton btnReiniciar = new JButton("Reiniciar");		
		btnReiniciar.setBounds(336, 282, 89, 23);
		panel.add(btnReiniciar);
		
		posInitX01 = lblPlayer1.getX();
		posInitX02 = lblPlayer2.getX();
		
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				empezarCarrera();
			}
		});
		
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reiniciarCarrera();
			}
		});
		
	}
	
	private void empezarCarrera() {
		HiloCaballo caballo1 = new HiloCaballo(lblPlayer1, "Caballo 01");
		HiloCaballo caballo2 = new HiloCaballo(lblPlayer2, "Caballo 02");
		caballo1.start();
		caballo2.start();
	}
	
	private void reiniciarCarrera() {
		lblPlayer1.setLocation(posInitX01, lblPlayer1.getY());
		lblPlayer2.setLocation(posInitX02, lblPlayer2.getY());
		
		setActivo(true);
	}
}
