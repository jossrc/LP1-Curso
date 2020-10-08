package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class FrmRegUser extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JDateChooser txtFecha;
	private JButton btnRegistrar;
	private JButton btnLimpiar;

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
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(76, 124, 137, 20);
		panel.add(txtFecha);
		
		btnRegistrar = new JButton("Registrar");		
		btnRegistrar.setBounds(312, 10, 97, 33);
		panel.add(btnRegistrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(312, 66, 97, 33);
		panel.add(btnLimpiar);
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});

	}
	
	private String encriptar(String clave) {
		StringBuilder cifrado = new StringBuilder();
		cifrado.append(clave);
		
		for (int i = 0; i < cifrado.length(); i++) {
			switch (cifrado.charAt(i)) {
			case 'a':
				cifrado.setCharAt(i, 'e');
				break;
			case 'e':
				cifrado.setCharAt(i, 'i');
				break;
			case 'i':
				cifrado.setCharAt(i, 'o');
				break;
			case 'o':
				cifrado.setCharAt(i, 'u');
				break;
			case 'u':
				cifrado.setCharAt(i, 'a');
				break;
			}
		}
		
		return cifrado.reverse().toString();
	}
	
	private String leerNombre() {
		
		if (txtNombre.getText().trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "El campo nombre está vacío", "Aviso",2);
			return null;
		}
		
		if (!txtNombre.getText().trim().matches("[a-zA-záéíóúñÑÁÉÍÓÚ]{2,15}")) {
			JOptionPane.showMessageDialog(null, "Ingrese un nombre válido", "Aviso",2);
			return null;
		}
		
		return txtNombre.getText();
	}
	
	private String leerApellido() {
		if (txtApellido.getText().trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "El campo apellido está vacío", "Aviso",2);
			return null;
		}
		
		if (!txtApellido.getText().trim().matches("[a-zA-záéíóúñÑÁÉÍÓÚ]{2,15}")) {
			JOptionPane.showMessageDialog(null, "Ingrese un apellido válido", "Aviso",2);
			return null;
		}
		
		return txtApellido.getText();
	}

	private String leerUsuario() {
		if (txtUsuario.getText().trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "El campo usuario está vacío", "Aviso",2);
			return null;
		}
		
		if (!txtUsuario.getText().trim().matches("[a-zA-z0-9]{2,4}")) {
			JOptionPane.showMessageDialog(null, "Ingrese un usuario válido", "Aviso",2);
			return null;
		}
		
		return txtUsuario.getText();
	}
	
	private String leerClave() {
		
		if (String.valueOf(txtClave.getPassword()).length() == 0) {
			JOptionPane.showMessageDialog(null, "El campo clave está vacío", "Aviso",2);
			return null;
		}
		
		if (String.valueOf(txtClave.getPassword()).length() > 5) {
			JOptionPane.showMessageDialog(null, "Ingrese una clave válida", "Aviso",2);
			return null;
		}
		
		return encriptar(String.valueOf(txtClave.getPassword()));
	}
	
	private String leerFecha() {
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Para Visualizar
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // Para BD
		return sdf.format(txtFecha.getDate());
	}
}
