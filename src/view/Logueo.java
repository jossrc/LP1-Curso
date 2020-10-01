package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.FrmPrincipal;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Logueo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logueo frame = new Logueo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Logueo() {
		setTitle("CiberFarma - Acceso al Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 347, 194);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(136, 25, 58, 19);
		panel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(227, 25, 103, 22);
		panel.add(txtUsuario);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(136, 72, 79, 19);
		panel.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(227, 69, 103, 20);
		panel.add(txtPassword);
		
		JButton btnAceptar = new JButton("Aceptar");		
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(170, 102, 123, 36);
		panel.add(btnAceptar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(170, 149, 123, 34);
		panel.add(btnSalir);
		
		setLocationRelativeTo(null);
		
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				btnAceptar.setEnabled(txtUsuario.getText().length() >= 2 && txtPassword.getPassword().length >= 8);
			}
		});

		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				btnAceptar.setEnabled(txtUsuario.getText().length() >= 2 && txtPassword.getPassword().length >= 8);
			}
			
			@Override
			public void keyTyped(KeyEvent e) {
				char letra = e.getKeyChar();
				if (letra == 32) {
					e.consume();
				}
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirVentanaPrincipal();
			}
		});
		
	}
	
	private void abrirVentanaPrincipal() {
		FrmPrincipal principal = new FrmPrincipal();
		principal.setLocationRelativeTo(null);
		principal.setExtendedState(MAXIMIZED_BOTH);
		principal.setVisible(true);
		dispose();
	}
	
}
