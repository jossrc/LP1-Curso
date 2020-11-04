package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionProductos;
import model.Producto;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DlgProductos extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable tblProductos;
	private DefaultTableModel model;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Throwable e) {
					e.printStackTrace();
				}
				
				try {
					DlgProductos dialog = new DlgProductos();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DlgProductos() {
		setModal(true);
		setTitle("Buscar Productos");
		setBounds(100, 100, 490, 432);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 456, 329);
		getContentPane().add(scrollPane);
		
		tblProductos = new JTable();
		model = new DefaultTableModel();
		tblProductos.setModel(model);
		model.addColumn("Codigo");
		model.addColumn("Producto");
		model.addColumn("Stock");
		model.addColumn("Precio Uni.");
		scrollPane.setViewportView(tblProductos);
		
		JButton btnSeleccionar = new JButton("SELECCIONAR");		
		btnSeleccionar.setBounds(110, 358, 114, 23);
		getContentPane().add(btnSeleccionar);
		
		JButton btnCerrar = new JButton("CERRAR");		
		btnCerrar.setBounds(253, 358, 98, 23);
		getContentPane().add(btnCerrar);
		
		listado();
		
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviarDatos();
			}
		});
		
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}
	
	private void enviarDatos() {
		int fila = tblProductos.getSelectedRow();
		
		String codigo = tblProductos.getValueAt(fila, 0).toString();
		String producto = tblProductos.getValueAt(fila, 1).toString();
		String cantidad = tblProductos.getValueAt(fila, 2).toString();
		String precio = tblProductos.getValueAt(fila, 3).toString();
		
		FrmBoleta.txtCodigoProducto.setText(codigo);
		FrmBoleta.txtDescProducto.setText(producto);
		FrmBoleta.txtStock.setText(cantidad);
		FrmBoleta.txtPrecioUnit.setText(precio);		

		dispose();
	}
	
	void listado() {
		ArrayList<Producto> listaProductos = new GestionProductos().listadoProductos();
		for (Producto prod : listaProductos) {
			insertarNuevaFila(prod);
		}
	}
	
	private void insertarNuevaFila(Producto prod) {
		Object datos[] = {prod.getCodigo(), prod.getProducto(), prod.getCantidad(), prod.getPrecio()};		
		model.addRow(datos);
	}

}
