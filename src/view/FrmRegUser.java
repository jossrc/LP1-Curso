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

import mantenimientos.GestionUsuarios;
import model.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmRegUser extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JDateChooser txtFecha;
	private JButton btnRegistrar;
	private JButton btnLimpiar;
	private JTextField txtCodigo;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JComboBox<String> cboTipo;

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
		setTitle("Mantenimiento de Usuarios");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(23, 48, 37, 14);
		panel.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(23, 76, 37, 14);
		panel.add(lblApellido);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(23, 104, 36, 14);
		panel.add(lblNewLabel);

		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(23, 133, 27, 14);
		panel.add(lblClave);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(23, 158, 29, 14);
		panel.add(lblFecha);

		txtNombre = new JTextField();
		txtNombre.setBounds(79, 45, 136, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(79, 73, 136, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(79, 101, 136, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtClave = new JPasswordField();
		txtClave.setBounds(79, 129, 136, 20);
		panel.add(txtClave);

		txtFecha = new JDateChooser();
		txtFecha.setBounds(78, 158, 137, 20);
		panel.add(txtFecha);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(312, 10, 97, 33);
		panel.add(btnRegistrar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(312, 188, 97, 33);
		panel.add(btnLimpiar);
		
		btnActualizar = new JButton("Actualizar");		
		btnActualizar.setBounds(312, 66, 97, 33);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");		
		btnEliminar.setBounds(312, 132, 97, 33);
		panel.add(btnEliminar);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(23, 19, 33, 14);
		panel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(79, 16, 136, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(23, 192, 29, 14);
		panel.add(lblTipo);
		
		cboTipo = new JComboBox<String>();
		cboTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione", "Administrador", "Cliente", "Cajero"}));
		cboTipo.setBounds(79, 189, 120, 20);
		panel.add(cboTipo);

		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				leerTodosYRegistrar();
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarUsuario();
			}
		});
		
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarUsuario();
			}
		});

	}
	
	protected void actualizarUsuario() {
		int codigo, tipo;
		String nombre, apellido, usuario,clave, fnacim;
		codigo = leerCodigo();
		nombre = leerNombre();		
		apellido = leerApellido();
		clave = leerClave();
		usuario = leerUsuario();
		fnacim = leerFecha();
		tipo = leerTipo();
		
		Usuario u = new Usuario(codigo, nombre, apellido, usuario, clave, fnacim, tipo, 0);
		
		int rs = new GestionUsuarios().actualizar(u);
		
		if (rs == 0) {
			JOptionPane.showMessageDialog(this, "Error al actualizar");
		} else {
			JOptionPane.showMessageDialog(this, "Usuario actualizado");
		}
		
	}

	private int leerTipo() {
		
		if (cboTipo.getSelectedIndex() == -1 || cboTipo.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Seleccion un tipo", "Aviso", 2);
			return -1;
		}
		
		return cboTipo.getSelectedIndex();
	}

	private void eliminarUsuario() {
		int codigo;
		codigo = leerCodigo();
		int rs = new GestionUsuarios().eliminar(codigo);
		if (rs == 0) {
			JOptionPane.showMessageDialog(this, "No se eliminó, código no existe");
		} else {
			JOptionPane.showMessageDialog(this, "Usuario eliminado");
		}
	}

	private int leerCodigo() {
		
		if (txtCodigo.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "El campo código no debe estar vacío", "Aviso", 2);
			return -1;
		}

		if (!txtCodigo.getText().trim().matches("\\d*")) {
			JOptionPane.showMessageDialog(this, "El código solo acepta números", "Aviso", 2);
			return -1;
		}
		
		
		return Integer.parseInt(txtCodigo.getText().trim());
	}

	private void registrarDatosBD(String nombre, String apellido, String usuario, String clave, String fnacim) {
		// 01. Crear un obj con los datos del usuario
		Usuario u = new Usuario(0, nombre, apellido, usuario, clave, fnacim, 0, 0);
		// 02. Registrar el obj usando la clase de gestion y guardando
		int ok = new GestionUsuarios().registrar(u);

		// salidas
		if (ok == 0) {
			JOptionPane.showMessageDialog(this, "Error al registrar");
		} else {
			JOptionPane.showMessageDialog(this, "Registro OK");
		}
	}

	private void leerTodosYRegistrar() {
		// variables
		String nombre, apellido, usuario, clave, fnacim;
		// entradas
		nombre = leerNombre();

		if (nombre != null) {
			apellido = leerApellido();
			if (apellido != null) {
				usuario = leerUsuario();
				if (usuario != null) {
					clave = leerClave();
					if (clave != null) {
						fnacim = leerFecha();
						if (fnacim != null) {
							registrarDatosBD(nombre, apellido, usuario, clave, fnacim);
						}
					}
				}

			}
		} else {
			return;
		}
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

		if (txtNombre.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "El campo nombre está vacío", "Aviso", 2);
			return null;
		}

		if (!txtNombre.getText().trim().matches("[a-zA-ZáéíóúñÑÁÉÍÓÚ]{2,15}")) {
			JOptionPane.showMessageDialog(this, "Ingrese un nombre válido", "Aviso", 2);
			return null;
		}

		return txtNombre.getText();
	}

	private String leerApellido() {
		if (txtApellido.getText().trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "El campo apellido está vacío", "Aviso", 2);
			return null;
		}

		if (!txtApellido.getText().trim().matches("[a-zA-ZáéíóúñÑÁÉÍÓÚ]{2,15}")) {
			JOptionPane.showMessageDialog(this, "Ingrese un apellido válido", "Aviso", 2);
			return null;
		}

		return txtApellido.getText();
	}

	private String leerUsuario() {
		if (txtUsuario.getText().trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "El campo usuario está vacío", "Aviso", 2);
			return null;
		}

		if (!txtUsuario.getText().trim().matches("[a-zA-Z0-9]{2,4}")) {
			JOptionPane.showMessageDialog(this, "Ingrese un usuario válido", "Aviso", 2);
			return null;
		}

		return txtUsuario.getText();
	}

	private String leerClave() {

		if (String.valueOf(txtClave.getPassword()).length() == 0) {
			JOptionPane.showMessageDialog(this, "El campo clave está vacío", "Aviso", 2);
			return null;
		}

		if (String.valueOf(txtClave.getPassword()).length() > 5) {
			JOptionPane.showMessageDialog(this, "Ingrese una clave válida", "Aviso", 2);
			return null;
		}

		return encriptar(String.valueOf(txtClave.getPassword()));
	}

	private String leerFecha() {
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); Para Visualizar
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // Para BD
		return sdf.format(txtFecha.getDate());
	}
}
