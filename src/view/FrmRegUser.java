package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class FrmRegUser extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JPasswordField txtClave;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Throwable e) {
					e.printStackTrace();
				}
				
				try {
					FrmRegUser dialog = new FrmRegUser();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmRegUser() {
		setModal(true);
		setTitle("Registro de Usuarios");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(21, 14, 37, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(21, 42, 37, 14);
		panel.add(lblApellido);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(21, 70, 36, 14);
		panel.add(lblNewLabel);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(21, 99, 27, 14);
		panel.add(lblClave);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(21, 124, 29, 14);
		panel.add(lblFecha);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(77, 11, 136, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(77, 39, 136, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(77, 67, 136, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(77, 95, 136, 20);
		panel.add(txtClave);
		
		JDateChooser txtFecha = new JDateChooser();
		txtFecha.setBounds(76, 124, 137, 20);
		panel.add(txtFecha);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(312, 10, 97, 33);
		panel.add(btnRegistrar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(312, 66, 97, 33);
		panel.add(btnLimpiar);

	}
}
