package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeListener;

import hilos.HiloCargaLoader;
import view.FrmPrincipal;

import javax.swing.event.ChangeEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmPreLoader extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JProgressBar prbCarga;
	public static JLabel lblMensaje;

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
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
		setTitle("Loading...");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 91);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMensaje = new JLabel("El sistema est\u00E1 cargando, espere unos segundos");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(Color.BLUE);
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensaje.setBounds(50, 2, 303, 14);
		contentPane.add(lblMensaje);
		
		prbCarga = new JProgressBar();		
		prbCarga.setStringPainted(true);
		prbCarga.setBounds(0, 27, 403, 19);
		contentPane.add(prbCarga);
		
		setLocationRelativeTo(null);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				iniciarBarra();
			}
		});
		
		prbCarga.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {	
				if (prbCarga.getValue() == 100) {
					FrmPrincipal principal = new FrmPrincipal();
					principal.setLocationRelativeTo(null);
					//principal.setExtendedState(MAXIMIZED_BOTH);
					principal.setVisible(true);
					dispose();
				}
			}
		});
		
	}
	
	private void iniciarBarra() {
		HiloCargaLoader hilo = new HiloCargaLoader();
		hilo.start();
	}
}
