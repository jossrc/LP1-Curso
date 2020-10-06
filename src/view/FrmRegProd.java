package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmRegProd extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable tblSalida;
	private JTextField txtCodigo;
	private JTextField txtProducto;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JComboBox<String> cboTipo;
	private DefaultTableModel model;

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
		setTitle("Productos");
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

		cboTipo = new JComboBox<String>();
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
		model = new DefaultTableModel();
		tblSalida.setModel(model);
		model.addColumn("C\u00F3digo");
		model.addColumn("Nombre");
		model.addColumn("Categoría");
		model.addColumn("Stock");
		model.addColumn("Precio");
		scrollPane.setViewportView(tblSalida);

		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});		

		txtPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char tecla = arg0.getKeyChar();
				boolean validacion = (tecla >= '0' && tecla <= '9') || tecla == '.';
				
				if (!validacion)
					arg0.consume();				
			}
		});		

		txtCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char tecla = e.getKeyChar();
				boolean validacion = tecla < '0' || tecla > '9';
				
				if (validacion)
					e.consume();
			}
		});		
		
		tblSalida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int fila = tblSalida.getSelectedRow();
				getValueRowAndSet(txtCodigo, fila, 0);
				getValueRowAndSet(txtProducto, fila, 1);
				getValueRowAndSet(txtCantidad, fila, 3);
				getValueRowAndSet(txtPrecio, fila, 4);	
			}
		});
		
	}

	private void ingresar() {
		String codigo, producto;
		int cantidad, tipo;
		double precio;
		
		codigo = leerCodigo();
		producto = leerProducto();
		cantidad = leerCantidad();
		tipo = leerTipo();
		precio = leerPrecio();
		
		if (cantidad == -1 || precio == -1 || producto == null || tipo == -1)
			JOptionPane.showMessageDialog(null, "Error en los datos");
		else
			insertarNuevaFila(codigo, producto, tipo, cantidad, precio);
	}

	private String leerCodigo() {
		if (txtCodigo.getText().trim().isEmpty())
			return null;

		return txtCodigo.getText().trim();
	}

	private int leerTipo() {
		if (cboTipo.getSelectedIndex() == 0)
			return -1;

		return cboTipo.getSelectedIndex();
	}

	private int leerCantidad() {
		if (txtCantidad.getText().trim().isEmpty())
			return -1;

		return Integer.parseInt(txtCantidad.getText().trim());
	}

	private double leerPrecio() {
		if (txtPrecio.getText().trim().isEmpty())
			return -1;
		else {
			try {
				return Double.parseDouble(txtPrecio.getText().trim());
			} catch (NumberFormatException e) {
				System.out.println("Entro a la captura de Exception");
				JOptionPane.showMessageDialog(null,
						"Ooops error : " + e.getClass().getSimpleName() + "\nGenerado por : " + e.getMessage());
				return -1;
			}
		}
	}

	private String leerProducto() {
		if (txtProducto.getText().trim().isEmpty())
			return null;

		return txtProducto.getText().trim();
	}
	
	private void insertarNuevaFila(String codigo, String producto, int tipo, int cantidad, double precio) {
		Object datos[] = {codigo, producto, tipo, cantidad, precio};
		model.addRow(datos);
	}
	
	private void getValueRowAndSet(JTextField txt,int fila ,int pos) {
		txt.setText(tblSalida.getValueAt(fila, pos).toString());
	}
	
}
