package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class FrmBoleta extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtCodigoCliente;
	private JTextField txtNombreCompleto;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Throwable e) {
					e.printStackTrace();
				}
				
				try {
					FrmBoleta dialog = new FrmBoleta();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmBoleta() {
		setTitle("Venta y Boleta");
		setBounds(100, 100, 690, 487);
		getContentPane().setLayout(null);
		
		JPanel pBoleta = new JPanel();
		pBoleta.setBounds(0, 0, 674, 448);
		getContentPane().add(pBoleta);
		pBoleta.setLayout(null);
		
		JPanel pCliente = new JPanel();
		pCliente.setBorder(crearBordeTitulo("Cliente"));
		pCliente.setBounds(10, 11, 336, 94);
		pBoleta.add(pCliente);
		pCliente.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 31, 33, 14);
		pCliente.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 59, 37, 14);
		pCliente.add(lblNombre);
		
		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setEditable(false);
		txtCodigoCliente.setBounds(57, 28, 128, 20);
		pCliente.add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);
		
		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setEditable(false);
		txtNombreCompleto.setBounds(57, 56, 214, 20);
		pCliente.add(txtNombreCompleto);
		txtNombreCompleto.setColumns(10);
		
		JButton btnBuscarCliente = new JButton("");
		btnBuscarCliente.setBorder(null);
		btnBuscarCliente.setBorderPainted(false);
		btnBuscarCliente.setContentAreaFilled(false);
		btnBuscarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarCliente.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/search-icon.png")));
		btnBuscarCliente.setBounds(278, 44, 37, 34);
		pCliente.add(btnBuscarCliente);

	}
	
	private TitledBorder crearBordeTitulo(String titulo) {
		TitledBorder titled = new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null);
		titled.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		return titled;
	}
	
}
