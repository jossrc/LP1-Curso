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
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmBoleta extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtCodigoCliente;
	private JTextField txtNombreCompleto;
	private JTextField txtCodigoProducto;
	private JTextField txtCantidadAComprar;
	private JTextField txtPrecioUnit;
	private JTextField txtDescProducto;
	private JTextField txtStock;
	private JTable tblVenta;
	private DefaultTableModel model;
	private JTextField txtTotal;
	private JTextField txtNumBoleta;
	private JTextField txtFecha;

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
		setModal(true);
		setTitle("Venta y Boleta");
		setBounds(100, 100, 690, 536);
		getContentPane().setLayout(null);
		
		JPanel pBoleta = new JPanel();
		pBoleta.setBounds(0, 0, 674, 497);
		getContentPane().add(pBoleta);
		pBoleta.setLayout(null);
		
		JPanel pCliente = new JPanel();
		pCliente.setBorder(crearBordeTitulo("Datos del Cliente"));
		pCliente.setBounds(10, 11, 336, 94);
		pBoleta.add(pCliente);
		pCliente.setLayout(null);
		
		JLabel lblCodigoCliente = new JLabel("C\u00D3DIGO");
		lblCodigoCliente.setBounds(10, 31, 41, 14);
		pCliente.add(lblCodigoCliente);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(10, 59, 42, 14);
		pCliente.add(lblNombre);
		
		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setEditable(false);
		txtCodigoCliente.setBounds(64, 28, 121, 20);
		pCliente.add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);
		
		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setEditable(false);
		txtNombreCompleto.setBounds(64, 56, 209, 20);
		pCliente.add(txtNombreCompleto);
		txtNombreCompleto.setColumns(10);
		
		JButton btnBuscarCliente = new JButton("");		
		btnBuscarCliente.setBorder(null);
		btnBuscarCliente.setBorderPainted(false);
		btnBuscarCliente.setContentAreaFilled(false);
		btnBuscarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarCliente.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/search-icon.png")));
		btnBuscarCliente.setBounds(289, 46, 37, 34);
		pCliente.add(btnBuscarCliente);
		
		JPanel pProducto = new JPanel();
		pProducto.setLayout(null);
		pProducto.setBorder(crearBordeTitulo("Datos del Producto"));
		pProducto.setBounds(10, 126, 654, 132);
		pBoleta.add(pProducto);
		
		JLabel lblCodigoProducto = new JLabel("C\u00D3DIGO");
		lblCodigoProducto.setBounds(22, 19, 41, 14);
		pProducto.add(lblCodigoProducto);
		
		txtCodigoProducto = new JTextField();
		txtCodigoProducto.setEditable(false);
		txtCodigoProducto.setColumns(10);
		txtCodigoProducto.setBounds(21, 44, 144, 20);
		pProducto.add(txtCodigoProducto);
		
		JLabel lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setBounds(259, 19, 52, 14);
		pProducto.add(lblCantidad);
		
		txtCantidadAComprar = new JTextField();
		txtCantidadAComprar.setColumns(10);
		txtCantidadAComprar.setBounds(259, 44, 115, 20);
		pProducto.add(txtCantidadAComprar);
		
		JLabel lblPrecio = new JLabel("PRECIO");
		lblPrecio.setBounds(403, 19, 38, 14);
		pProducto.add(lblPrecio);
		
		txtPrecioUnit = new JTextField();
		txtPrecioUnit.setEditable(false);
		txtPrecioUnit.setColumns(10);
		txtPrecioUnit.setBounds(397, 44, 115, 20);
		pProducto.add(txtPrecioUnit);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCI\u00D3N");
		lblDescripcion.setBounds(22, 75, 69, 14);
		pProducto.add(lblDescripcion);
		
		txtDescProducto = new JTextField();
		txtDescProducto.setEditable(false);
		txtDescProducto.setColumns(10);
		txtDescProducto.setBounds(22, 100, 218, 20);
		pProducto.add(txtDescProducto);
		
		JLabel lblStock = new JLabel("STOCK");
		lblStock.setBounds(259, 75, 33, 14);
		pProducto.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setEditable(false);
		txtStock.setColumns(10);
		txtStock.setBounds(259, 100, 115, 20);
		pProducto.add(txtStock);
		
		JButton btnBuscarProducto = new JButton("");		
		btnBuscarProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarProducto.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/search-icon.png")));
		btnBuscarProducto.setContentAreaFilled(false);
		btnBuscarProducto.setBorderPainted(false);
		btnBuscarProducto.setBorder(null);
		btnBuscarProducto.setBounds(185, 34, 37, 34);
		pProducto.add(btnBuscarProducto);
		
		JButton btnAgregarCarrito = new JButton("");		
		btnAgregarCarrito.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarCarrito.setRolloverIcon(new ImageIcon(FrmBoleta.class.getResource("/img/cartph.png")));
		btnAgregarCarrito.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/cartp.png")));
		btnAgregarCarrito.setContentAreaFilled(false);
		btnAgregarCarrito.setBorderPainted(false);
		btnAgregarCarrito.setBorder(null);
		btnAgregarCarrito.setBounds(397, 86, 37, 34);
		pProducto.add(btnAgregarCarrito);
		
		String mensajeCarrito = "<html>Agregar al<br/>Carrito</html>";
		JLabel lblAgregarAlCarrito = new JLabel(mensajeCarrito);
		lblAgregarAlCarrito.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 11));
		lblAgregarAlCarrito.setBounds(444, 86, 68, 34);
		pProducto.add(lblAgregarAlCarrito);
		
		JLabel lblImgVenta = new JLabel("");
		lblImgVenta.setIcon(new ImageIcon(FrmBoleta.class.getResource("/img/medic-img.png")));
		lblImgVenta.setBounds(549, 11, 80, 110);
		pProducto.add(lblImgVenta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 279, 654, 167);
		pBoleta.add(scrollPane);
		
		tblVenta = new JTable();
		model = new DefaultTableModel();
		tblVenta.setModel(model);
		model.addColumn("Codigo");
		model.addColumn("Producto");
		model.addColumn("Cantidad");
		model.addColumn("Precio");
		model.addColumn("Importe");
		scrollPane.setViewportView(tblVenta);
		
		JButton btnNuevaVenta = new JButton("NUEVO");
		btnNuevaVenta.setBounds(10, 463, 89, 23);
		pBoleta.add(btnNuevaVenta);
		
		JButton btnFinalizarCompra = new JButton("FINALIZAR COMPRA");
		btnFinalizarCompra.setBounds(126, 463, 131, 23);
		pBoleta.add(btnFinalizarCompra);
		
		txtTotal = new JTextField();
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotal.setBounds(554, 464, 110, 20);
		pBoleta.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblTotalS = new JLabel("Total S/.");
		lblTotalS.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTotalS.setBounds(499, 465, 45, 16);
		pBoleta.add(lblTotalS);
		
		JPanel pCabecera = new JPanel();
		pCabecera.setLayout(null);
		pCabecera.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pCabecera.setBounds(391, 11, 273, 94);
		pBoleta.add(pCabecera);
		
		JLabel lblNumBoleta = new JLabel("N\u00B0 BOLETA");
		lblNumBoleta.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNumBoleta.setBounds(11, 16, 64, 14);
		pCabecera.add(lblNumBoleta);
		
		JLabel lblFecha = new JLabel("FECHA");
		lblFecha.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblFecha.setBounds(10, 41, 42, 14);
		pCabecera.add(lblFecha);
		
		txtNumBoleta = new JTextField();
		txtNumBoleta.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtNumBoleta.setText("B0000");
		txtNumBoleta.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumBoleta.setEditable(false);
		txtNumBoleta.setColumns(10);
		txtNumBoleta.setBounds(85, 11, 166, 20);
		pCabecera.add(txtNumBoleta);
		
		txtFecha = new JTextField();
		txtFecha.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(85, 39, 166, 20);
		pCabecera.add(txtFecha);
		
		JButton button = new JButton("");
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBounds(289, 46, 37, 34);
		pCabecera.add(button);
		
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnBuscarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnAgregarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

	}
	
	private TitledBorder crearBordeTitulo(String titulo) {
		TitledBorder titled = new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null);
		titled.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		return titled;
	}
	
}
