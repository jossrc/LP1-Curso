package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionUsuarioXTipos;
import model.RepUsuarioTipo;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DlgClientes extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable tblClientes;
	DefaultTableModel model;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
						
			public void run() {
				
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Throwable e) {
					e.printStackTrace();
				}
				
				try {
					DlgClientes dialog = new DlgClientes();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DlgClientes() {
		setModal(true);
		setTitle("Buscar Clientes");
		setBounds(100, 100, 496, 414);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 458, 302);
		getContentPane().add(scrollPane);
		
		tblClientes = new JTable();
		model = new DefaultTableModel();
		tblClientes.setModel(model);
		model.addColumn("Codigo");
		model.addColumn("Nombre Completo");
		scrollPane.setViewportView(tblClientes);
		
		JButton btnSeleccionar = new JButton("SELECCIONAR");		
		btnSeleccionar.setBounds(127, 340, 103, 23);
		getContentPane().add(btnSeleccionar);
		
		JButton btnCerrar = new JButton("CERRAR");		
		btnCerrar.setBounds(250, 340, 97, 23);
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
		int fila = tblClientes.getSelectedRow();
		
		String codigo = tblClientes.getValueAt(fila, 0).toString();
		String nombreCompleto = tblClientes.getValueAt(fila, 1).toString();
		
		FrmBoleta.txtCodigoCliente.setText(codigo);
		FrmBoleta.txtNombreCompleto.setText(nombreCompleto);		
		
		dispose();
	}
	
	void listado() {
		ArrayList<RepUsuarioTipo> listaUsuarios = new GestionUsuarioXTipos().listadoUsuariosYTipo(2);
		for (RepUsuarioTipo repUsuario : listaUsuarios) {
			insertarNuevaFila(repUsuario);
		}
	}
	
	private void insertarNuevaFila(RepUsuarioTipo u) {
		Object datos[] = {u.getCodigo(), u.getNombre() + " "+ u.getApellido()};		
		model.addRow(datos);
	}
	
}
