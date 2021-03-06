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
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

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
		setTitle("CiberFarma");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/img/main-icon.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 550);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnSistema = new JMenu("Sistema");
		mnSistema.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/system-icon.png")));
		menuBar.add(mnSistema);

		JMenuItem mntmSalir = new JMenuItem("Salir");		
		mntmSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/out-icon.png")));
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.ALT_MASK));
		mnSistema.add(mntmSalir);

		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/tool-icon.png")));
		menuBar.add(mnMantenimiento);

		JMenuItem mntmClientes = new JMenuItem("Clientes");		
		mntmClientes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/client-icon.png")));
		mnMantenimiento.add(mntmClientes);

		JMenuItem mntmProductos = new JMenuItem("Productos");		
		mntmProductos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/product-icon.png")));
		mnMantenimiento.add(mntmProductos);
		
		JMenuItem mntmUsuarios = new JMenuItem("Usuarios");		
		mntmUsuarios.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/user-icon.png")));
		mnMantenimiento.add(mntmUsuarios);
		
		JMenu mnTransaccional = new JMenu("Transaccional");
		mnTransaccional.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/tran-icon.png")));
		menuBar.add(mnTransaccional);
		
		JMenuItem mntmVentas = new JMenuItem("Ventas");		
		mntmVentas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/shopping-icon.png")));
		mnTransaccional.add(mntmVentas);

		JMenu mnReportes = new JMenu("Reportes");
		mnReportes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/report-icon.png")));
		menuBar.add(mnReportes);

		JMenuItem mntmRepVentas = new JMenuItem("Ventas");		
		mntmRepVentas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/sale-icon.png")));
		mnReportes.add(mntmRepVentas);
		
		JMenuItem mntmRepUsuarios = new JMenuItem("Usuarios");		
		mnReportes.add(mntmRepUsuarios);
		
		JMenuItem mntmRepUsuariosXTipos = new JMenuItem("Usuarios Por Tipo");		
		mnReportes.add(mntmRepUsuariosXTipos);
		
		JMenu mnJuegos = new JMenu("Juegos");
		mnJuegos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/play-icon.png")));
		menuBar.add(mnJuegos);
		
		JMenuItem mntmCaballitos = new JMenuItem("Caballitos");		
		mntmCaballitos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/horse-icon.png")));
		mnJuegos.add(mntmCaballitos);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 744, 489);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblReloj = new JLabel("00:00:00");
		lblReloj.setForeground(new Color(255, 51, 0));
		lblReloj.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 24));
		lblReloj.setBounds(548, 11, 122, 30);
		panel.add(lblReloj);
		
		AudioClip sonido;
		sonido = java.applet.Applet.newAudioClip(getClass().getResource("/audio/Bienvenido.wav"));
		sonido.play();
		
		setLocationRelativeTo(null);
		
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
				regProd.setLocationRelativeTo(null);
				regProd.setVisible(true);				
			}
		});
		
		mntmRepVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmReptVtas reptVtas = new FrmReptVtas();
				reptVtas.setLocationRelativeTo(null);
				reptVtas.setVisible(true);				
			}
		});
		
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmRegCli regCli = new FrmRegCli();
				regCli.setLocationRelativeTo(null);
				regCli.setVisible(true);				
			}
		});
		
		mntmUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmRegUser regUser = new FrmRegUser();
				regUser.setLocationRelativeTo(null);
				regUser.setVisible(true);				
			}
		});
		
		mntmVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmBoleta venta = new FrmBoleta();
				venta.setLocationRelativeTo(null);
				venta.setVisible(true);
			}
		});
		
		mntmRepUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmRepUsuarios repUsuarios = new FrmRepUsuarios();
				repUsuarios.setLocationRelativeTo(null);
				repUsuarios.setVisible(true);
			}
		});
		
		mntmRepUsuariosXTipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmRepUsuariosXTipo repUsuariosXTipo = new FrmRepUsuariosXTipo();
				repUsuariosXTipo.setLocationRelativeTo(null);
				repUsuariosXTipo.setVisible(true);
			}
		});
		
		mntmCaballitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pista juego = new Pista();
				juego.setVisible(true);
				juego.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		switch (Logueo.vendedor.getId_tipo()) {
		case 2:
			mnMantenimiento.setVisible(false);
			mnTransaccional.setVisible(false);
			mnReportes.setVisible(false);
			break;
		case 3:
			mnMantenimiento.setEnabled(false);
			mntmProductos.setEnabled(false);
			break;
		default:
			break;
		}		
	}
	
	private void iniciarReloj() {
		HiloReloj hilo = new HiloReloj();
		hilo.start();
	}
}
