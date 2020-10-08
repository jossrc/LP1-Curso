package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRegCli extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	private JTextField txtDNI;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtCorreo;

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegCli dialog = new FrmRegCli();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmRegCli() {		
		
		setModal(true);
		setTitle("Clientes");
		setBounds(100, 100, 506, 327);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 490, 288);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblRegistroDeClientes = new JLabel("Mantenimiento de Clientes");
		lblRegistroDeClientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRegistroDeClientes.setBounds(10, 11, 171, 16);
		panel.add(lblRegistroDeClientes);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(20, 41, 37, 14);
		panel.add(lblCodigo);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(20, 76, 22, 14);
		panel.add(lblDNI);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 104, 41, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(20, 132, 41, 14);
		panel.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setBounds(20, 163, 46, 14);
		panel.add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(20, 190, 37, 14);
		panel.add(lblCorreo);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(101, 38, 157, 20);
		panel.add(txtCodigo);
		
		txtDNI = new JTextField();
		txtDNI.setText("");
		txtDNI.setColumns(10);
		txtDNI.setBounds(101, 70, 157, 20);
		panel.add(txtDNI);
		
		txtNombre = new JTextField();
		txtNombre.setText("");
		txtNombre.setColumns(10);
		txtNombre.setBounds(101, 101, 157, 20);
		panel.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setText("");
		txtApellido.setColumns(10);
		txtApellido.setBounds(101, 129, 157, 20);
		panel.add(txtApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.setText("");
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(101, 159, 157, 20);
		panel.add(txtTelefono);
		
		txtCorreo = new JTextField();
		txtCorreo.setText("");
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(101, 187, 157, 20);
		panel.add(txtCorreo);		
		
		JButton btnNuevo = new JButton("Nuevo");		
		btnNuevo.setBounds(331, 38, 116, 34);
		panel.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");		
		btnGuardar.setBounds(331, 88, 116, 34);
		panel.add(btnGuardar);
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresar();
			}
		});
		
	}
	
	private void ingresar() {
		String codigo = leerCodigo();
		String dni;
		String nombre;
		String apellido;
		String telefono;
		String correo;
		
		if (codigo != null) {
			dni = leerDNI();
			if (dni != null) {
				nombre = leerNombreApellido(txtNombre, "Nombre");
				if (nombre != null) {
					apellido = leerNombreApellido(txtApellido, "Apellido");
					if (apellido != null) {
						telefono = leerTelefono();
						if (telefono != null) {
							correo = leerCorreo();
							if (correo != null) {
								JOptionPane.showMessageDialog(this, "Datos ingresados correctamente");
							}
						}
					}
				}
			}
		}
		else {
			return;
		}		
		
	}
	
	private String leerCodigo() {
		
		if (!txtCodigo.getText().trim().matches("CLI[0-9]{3}")) {
			JOptionPane.showMessageDialog(this, "Código inválido");
			return null;
		}
		
		return txtCodigo.getText().trim();
	}
	
	private String leerDNI() {
		
		if (!txtDNI.getText().trim().matches("\\d{8}")) {
			JOptionPane.showMessageDialog(this, "DNI inválido");
			return null;
		}

		return txtDNI.getText().trim();		
	}
	
	private String leerNombreApellido(JTextField txt, String nomap) {
		if (!txt.getText().trim().matches("[A-Za-z\\s]{3,30}")) {
			JOptionPane.showMessageDialog(this, nomap + " inválido");
			return null;
		}
	
		return txt.getText().trim();
	}
	
	private String leerTelefono() {
		if (!txtTelefono.getText().trim().matches("[0-9]{3}[-]{0,1}[0-9]{4}")) {
			JOptionPane.showMessageDialog(this, "Teléfono inválido");
			return null;
		}

		return txtTelefono.getText().trim();
	}
	
	private String leerCorreo() {
		if (!txtCorreo.getText().trim()
				.matches("[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})")) {
			JOptionPane.showMessageDialog(null, "Correo no válido");
			return null;
		}

		return txtCorreo.getText().trim();
	}
	
	private void limpiar() {
		txtCodigo.setText("");
		txtDNI.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		
		txtCodigo.requestFocus();
	}
	
}
