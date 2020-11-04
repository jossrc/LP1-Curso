package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
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
		
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}

}
