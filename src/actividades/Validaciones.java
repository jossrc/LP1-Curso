package actividades;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Validaciones extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblDni;
	private JLabel lblApellido;
	private JLabel lblPrecio;
	private JLabel lblCodigo;
	private JLabel lblTelefono;
	private JLabel lblCorreo;
	private JTextField txtDNI;
	private JTextField txtApellido;
	private JTextField txtPrecio;
	private JTextField txtCodigo;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JButton btnVerificar;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Validaciones frame = new Validaciones();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Validaciones() {
		setTitle("Validaciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDni.setBounds(22, 23, 20, 16);
		contentPane.add(lblDni);

		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellido.setBounds(22, 65, 45, 16);
		contentPane.add(lblApellido);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecio.setBounds(22, 106, 35, 16);
		contentPane.add(lblPrecio);

		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(22, 150, 39, 16);
		contentPane.add(lblCodigo);

		lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefono.setBounds(22, 196, 50, 16);
		contentPane.add(lblTelefono);

		lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCorreo.setBounds(22, 248, 39, 16);
		contentPane.add(lblCorreo);

		txtDNI = new JTextField();
		txtDNI.setBounds(85, 23, 174, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(85, 65, 174, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(85, 106, 174, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(85, 150, 174, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(85, 196, 174, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(85, 248, 174, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);

		btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(this);
		btnVerificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerificar.setBounds(327, 23, 126, 37);
		contentPane.add(btnVerificar);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnVerificar) {
			actionPerformedBtnVerificar(arg0);
		}
	}

	protected void actionPerformedBtnVerificar(ActionEvent arg0) {

		String dni = leerDNI();
		String apellido;
		String codigo;
		double precio;
		String telefono;
		String correo;

		if (dni != null) {
			apellido = leerApellido();
			if (apellido != null) {
				precio = leerPrecio();
				if (precio != -1) {
					codigo = leerCodigo();
					if (codigo != null) {
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

	String leerDNI() {

		if (!txtDNI.getText().trim().matches("\\d{8}")) {
			JOptionPane.showMessageDialog(this, "DNI inválido");
			return null;
		}

		return txtDNI.getText().trim();
	}

	String leerApellido() {

		if (!txtApellido.getText().trim().matches("[A-Z]{3,30}")) {
			JOptionPane.showMessageDialog(this, "Apellido inválido");
			return null;
		}

		return txtApellido.getText().trim();
	}

	double leerPrecio() {

		if (!txtPrecio.getText().trim().matches("[0-9]+([.][0-9]{1,2})?")) {
			JOptionPane.showMessageDialog(this, "Precio inválido");
			return -1;
		}

		return Double.parseDouble(txtPrecio.getText().trim());
	}

	String leerCodigo() {

		if (!txtCodigo.getText().trim().matches("i[1-8]{8}")) {
			JOptionPane.showMessageDialog(this, "Código inválido");
			return null;
		}

		return txtCodigo.getText().trim();
	}

	String leerTelefono() {
		if (!txtTelefono.getText().trim().matches("[0-9]{3}[-][0-9]{4}")) {
			JOptionPane.showMessageDialog(this, "Teléfono inválido");
			return null;
		}

		return txtTelefono.getText().trim();
	}

	String leerCorreo() {

		if (!txtCorreo.getText().trim()
				.matches("[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})")) {
			JOptionPane.showMessageDialog(null, "Correo no válido");
			return null;
		}

		return txtCorreo.getText().trim();
	}
}
