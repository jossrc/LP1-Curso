package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class FrmRegProd extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	private JTextField txtProducto;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JTable tblSalida;

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegProd dialog = new FrmRegProd();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmRegProd() {
		setBounds(100, 100, 506, 388);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 490, 349);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblMantenimientoProductos = new JLabel("Mantenimiento de Productos");
		lblMantenimientoProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMantenimientoProductos.setBounds(29, 11, 175, 17);
		panel.add(lblMantenimientoProductos);

		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(38, 46, 37, 14);
		panel.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setText("");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(96, 40, 123, 20);
		panel.add(txtCodigo);

		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(38, 71, 47, 14);
		panel.add(lblProducto);

		txtProducto = new JTextField();
		txtProducto.setText("");
		txtProducto.setColumns(10);
		txtProducto.setBounds(96, 68, 123, 20);
		panel.add(txtProducto);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(38, 96, 24, 14);
		panel.add(lblTipo);

		JComboBox<String> cboTipo = new JComboBox<String>();
		cboTipo.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Seleccione tipo", "Pastillas", "Jarabe", "Otros" }));
		cboTipo.setBounds(96, 92, 123, 20);
		panel.add(cboTipo);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(38, 120, 47, 14);
		panel.add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setText("");
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(96, 117, 53, 20);
		panel.add(txtCantidad);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(179, 120, 33, 14);
		panel.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setText("");
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(228, 117, 60, 20);
		panel.add(txtPrecio);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(333, 11, 116, 34);
		panel.add(btnNuevo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(333, 61, 116, 34);
		panel.add(btnGuardar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(333, 110, 116, 34);
		panel.add(btnEditar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(179, 313, 109, 25);
		panel.add(btnConsultar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 166, 436, 136);
		panel.add(scrollPane);

		tblSalida = new JTable();
		scrollPane.setViewportView(tblSalida);

	}
}
