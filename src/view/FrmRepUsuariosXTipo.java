package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionTipos;
import mantenimientos.GestionUsuarioXTipos;
import mantenimientos.GestionUsuarios;
import model.RepUsuarioTipo;
import model.Tipos;
import model.Usuario;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FrmRepUsuariosXTipo extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable tblUsuariosXTipo;
	private DefaultTableModel model;
	private JComboBox<String> cboTipo;
	private JTextArea txtS;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Throwable e) {
					e.printStackTrace();
				}
				
				try {
					FrmRepUsuariosXTipo dialog = new FrmRepUsuariosXTipo();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmRepUsuariosXTipo() {
		setTitle("Reporte Usuarios Por Tipo");
		setBounds(100, 100, 493, 577);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 477, 538);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("LISTADO DE USUARIOS");
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTitulo.setBackground(new Color(167, 69, 249));
		lblTitulo.setBounds(10, 11, 457, 39);
		panel.add(lblTitulo);
		
		cboTipo = new JComboBox<String>();
		cboTipo.setBounds(76, 61, 157, 20);
		panel.add(cboTipo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(20, 64, 46, 14);
		panel.add(lblTipo);
		
		JScrollPane scrollArea = new JScrollPane();
		scrollArea.setBounds(10, 98, 457, 173);
		panel.add(scrollArea);
		
		txtS = new JTextArea();
		scrollArea.setViewportView(txtS);
		
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setBounds(10, 298, 457, 173);
		panel.add(scrollTable);
		
		tblUsuariosXTipo = new JTable();
		model = new DefaultTableModel();
		tblUsuariosXTipo.setModel(model);
		scrollTable.setViewportView(tblUsuariosXTipo);
		model.addColumn("C\u00F3digo");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("F.Nac");
		model.addColumn("Tipo");
		
		JButton btnListado = new JButton("LISTADO");		
		btnListado.setForeground(Color.WHITE);
		btnListado.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnListado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListado.setContentAreaFilled(false);
		btnListado.setOpaque(true);
		btnListado.setBorder(null);
		btnListado.setBackground(new Color(162, 164, 165));
		btnListado.setBounds(178, 482, 121, 37);
		panel.add(btnListado);
		
		llenaCombo();		
		
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listadoArea();
			}
		});

	}
	
	private void llenaCombo() {
		cboTipo.addItem("Seleccione...");
		ArrayList<Tipos> listaTipos = new GestionTipos().listado();
		
		if (listaTipos == null) {
			System.out.println("Hubo un problema al cargar la lista de tipos");
		} else {
			for (Tipos tipo : listaTipos) {
				cboTipo.addItem(tipo.getId() + ".- " + tipo.getDescripcion());
			}
		}	
	}
	
	private void listadoArea() {
		
		int tipo = leerTipo();
		
		if (tipo != -1 || tipo != 0) {
			ArrayList<Usuario> listaUsuarios = new GestionUsuarioXTipos().listadoUsuariosxTipo(tipo);
			
			if (listaUsuarios == null) {
				txtS.setText("Listado vacío");
			} else {
				txtS.setText(">>>>>>>> Listado de Usuarios <<<<<<<<\n\n");
				for (Usuario u : listaUsuarios) {
					txtS.append("Código   : "  + u.getCodigo() + "\n" + 
				                "Nombre   : "  + u.getNombre() + "\n" + 
							    "Apellido : "  + u.getApellido() + "\n" +
				                "F.Nac    : "  + u.getFnacim() + "\n" +
							    "Tipo     : "  + u.getId_tipo() +
							    "\n-----------------\n");
				}
			}
		}

	}
	
	private void insertarNuevaFila(RepUsuarioTipo u) {
		Object datos[] = {u.getCodigo(), u.getNombre(), u.getApellido(), u.getFech_nac(), u.getDesc_tipo()};		
		model.addRow(datos);
	}
	
	private int leerTipo() {
		return cboTipo.getSelectedIndex();
	}
}
