package view;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import mantenimientos.GestionUsuarios;
import model.Usuario;

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

public class FrmLstUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextArea txtS;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLstUsuarios frame = new FrmLstUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmLstUsuarios() {
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
				listado();
			}
		});
		
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imprimePDF();
			}
		});
	}
	String fecha = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	
	private void imprimePDF() {
		// Default en el proyecto
		String nombreArchivo = "reportes/"+ fecha + ".pdf";
		
		try {
			// Crea el archivo físico
			FileOutputStream fos = new FileOutputStream(nombreArchivo);
			
			// Crear un obj (itext) donde se agrega lo que vamos a imprimir (PDF)
			Document doc = new Document();
			
			// Relaciona el doc y el archivo
			PdfWriter pdfw = PdfWriter.getInstance(doc, fos);
			
			// Abrir el documento
			doc.open();

			// Agregamos los elementos

			Image img = Image.getInstance("src/img/medic-img.png");
			img.scaleToFit(100, 100);
			doc.add(img);

			Paragraph p = new Paragraph("Listado de Usuarios", 
					FontFactory.getFont("times", 36,Font.BOLDITALIC ,BaseColor.ORANGE));
			p.setAlignment(Chunk.ALIGN_CENTER);
			doc.add( p);

			// * ejemplo de salto de linea

			doc.add(new Paragraph(" "));

			// * Ejemplo de parrafo centrado
			p = new Paragraph(fecha);
			p.setAlignment(Chunk.ALIGN_RIGHT);
			doc.add(p);

			doc.add(new Paragraph(" "));

			// * Ejemplo de tabla de 3 columnas
			ArrayList<Usuario> listado = new GestionUsuarios().listado();
			
			if (listado == null || listado.size() == 0) {
				p = new Paragraph("Listado vacío");
				p.setAlignment(Chunk.ALIGN_CENTER);
				doc.add(p);
			} else {
				PdfPTable tabla = new PdfPTable(3);
				for (Usuario u : listado) {
					Image perfil = Image.getInstance("src/img/f"+ u.getCodigo()+ ".png");
					perfil.scaleToFit(50, 50);
					
					PdfPCell imgRedi = new PdfPCell(perfil);
					
					tabla.addCell(imgRedi);
					tabla.addCell(u.getCodigo() + "");
					tabla.addCell(u.getNombre()+ " " + u.getApellido());
				}
				doc.add(tabla);
			}

			// Cerrar el documento y archivo
			
			doc.close();
			
			// Abrir el archivo creado (opcional)
			Desktop.getDesktop().open(new File(nombreArchivo));
			
		} catch (Exception e) {
			System.out.println("Error al crear archivo PDF : " + e.getMessage());
		}
		
	}

	private void listado(){
		ArrayList<Usuario> listado = new GestionUsuarios().listado();
		
		if (listado == null || listado.size() == 0) {
			JOptionPane.showMessageDialog(this, "Listado vacío");
		} else {
			txtS.setText("Listado de usuarios \n\n");
			for (Usuario u : listado) {
				txtS.append(u.getCodigo() + "\t" + u.getNombre() + " " + u.getApellido() + "\n");
			}
		}
	}

}



