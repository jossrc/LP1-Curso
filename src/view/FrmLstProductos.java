package view;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionRepProductCat;
import model.RepProductoCategoria;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FrmLstProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea txtS;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLstProductos frame = new FrmLstProductos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmLstProductos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Listado de Productos");
		lblTitulo.setBounds(22, 11, 183, 24);
		contentPane.add(lblTitulo);
		
		txtS = new JTextArea();
		txtS.setText("codigo del producto, nombre del producto, stock, \r\nprecio y nombre de categoria");
		txtS.setBounds(10, 51, 414, 155);
		contentPane.add(txtS);
		
		JButton btnListado = new JButton("Listado");		
		btnListado.setBounds(22, 227, 89, 23);
		contentPane.add(btnListado);
		
		JButton btnPdf = new JButton("PDF");		
		btnPdf.setBounds(121, 227, 89, 23);
		contentPane.add(btnPdf);
		
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// llamar al m�todo
				listado();
			}
		});
		
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imprimePDF();
			}
		});
	}
	
	String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	
	private void imprimePDF() {
		
	}

	private void listado(){
		ArrayList<RepProductoCategoria> productos = new GestionRepProductCat().listado();
		txtS.setText(">>>>>>>>> LISTADO PRODUCTOS <<<<<<<<<<< \n\n");
		if (productos == null) {
			JOptionPane.showMessageDialog(this, "No existen productos");
		} else {
			for (RepProductoCategoria p : productos) {
				txtS.append(p.getCodigo() + "\n");
				txtS.append(p.getNombre() + "\n");
				txtS.append(p.getStock() + "\n");
				txtS.append(p.getPrecio() + "\n");
				txtS.append(p.getCategoria() + "\n");
			}
		}
	}
}



