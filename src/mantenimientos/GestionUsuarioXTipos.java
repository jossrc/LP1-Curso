package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.UsuarioXTipoInterface;
import model.RepUsuarioTipo;
import model.Usuario;
import util.MySQLConexion8;

public class GestionUsuarioXTipos implements UsuarioXTipoInterface {

	@Override
	public ArrayList<Usuario> listadoUsuariosxTipo(int tipo) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_usuarios where id_tipo = ?";

			pst = con.prepareStatement(sql);
			pst.setInt(1, tipo);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				int codigo = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellido = rs.getString(3);
				String usuario = rs.getString(4);
				String clave = rs.getString(5);
				String fnacim = rs.getString(6);
				int id_tipo = rs.getInt(7);
				int estado = rs.getInt(8);				
				
				Usuario u = new Usuario(codigo, nombre, apellido, usuario, clave, fnacim, id_tipo, estado);
				lista.add(u);
			}

		} catch (Exception e) {
			System.out.println("Error en listado " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}
		
		return lista;
	}

	@Override
	public ArrayList<RepUsuarioTipo> listadoUsuariosYTipo(int tipo) {
		// TODO Auto-generated method stub
		return null;
	}

}
