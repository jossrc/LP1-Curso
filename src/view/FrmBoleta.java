package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class FrmBoleta extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

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
		pCliente.setBounds(10, 11, 336, 111);
		pBoleta.add(pCliente);
		pCliente.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 31, 33, 14);
		pCliente.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 59, 37, 14);
		pCliente.add(lblNombre);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(59, 28, 86, 20);
		pCliente.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(57, 56, 214, 20);
		pCliente.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBuscarCliente = new JButton("");
		btnBuscarCliente.setBounds(179, 14, 68, 34);
		pCliente.add(btnBuscarCliente);

	}
	
	private TitledBorder crearBordeTitulo(String titulo) {
		TitledBorder titled = new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null);
		titled.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		return titled;
	}
	
}
