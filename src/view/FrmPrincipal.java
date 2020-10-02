package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloReloj;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JLabel lblReloj;

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 484);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);

		JMenuItem mntmSalir = new JMenuItem("Salir");		
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.ALT_MASK));
		mnSistema.add(mntmSalir);

		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);

		JMenuItem mntmClientes = new JMenuItem("Clientes");		
		mnMantenimiento.add(mntmClientes);

		JMenuItem mntmProductos = new JMenuItem("Productos");		
		mnMantenimiento.add(mntmProductos);

		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);

		JMenuItem mntmVentas = new JMenuItem("Ventas");		
		mnReportes.add(mntmVentas);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 684, 424);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblReloj = new JLabel("00:00:00");
		lblReloj.setForeground(new Color(255, 51, 0));
		lblReloj.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lblReloj.setBounds(548, 11, 122, 30);
		panel.add(lblReloj);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				iniciarReloj();
			}
		});
		
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mntmProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmRegProd regProd = new FrmRegProd();
				regProd.setVisible(true);
			}
		});
		
		mntmVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmReptVtas reptVtas = new FrmReptVtas();
				reptVtas.setVisible(true);
			}
		});
		
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmRegCli regCli = new FrmRegCli();
				regCli.setVisible(true);
			}
		});
		
	}
	
	private void iniciarReloj() {
		HiloReloj hilo = new HiloReloj();
		hilo.start();
	}
	
}
