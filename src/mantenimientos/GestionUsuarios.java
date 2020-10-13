package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.UsuarioInterface;
import model.Usuario;
import util.MySQLConexion8;

public class GestionUsuarios implements UsuarioInterface {

	@Override
	public int registrar(Usuario u) {
		int rs = 0; // rs -> Devuelve el resultado de la operacion
		// Plantilla de BD
		Connection con = null; // Sirve para la conex.
		PreparedStatement pst = null; // Para las sentencias

		try {
			// 01. Obtener la conexion
			con = MySQLConexion8.getConexion();
			// 02. Crear la cadena que haga una sentencia a utilizar
			String sql = "insert into tb_usuarios values (null, ?, ?, ?, ?, ?,default,default)";
			// 03. Se prepara la sentencia a ejecutar
			pst = con.prepareStatement(sql);
			// Como la cadena tiene ?, se setea
			pst.setString(1, u.getNombre());
			pst.setString(2, u.getApellido());
			pst.setString(3, u.getUsuario());
			pst.setString(4, u.getClave());
			pst.setString(5, u.getFnacim());
			// 04. Ejecutamos la sentencia y guardamos el resultado
			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en registrar : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return rs;
	}

	@Override
	public int eliminar(int codigo) {
		int rs = 0;
		
		Connection con = null;
		PreparedStatement pst = null;

		try {
			
			con = MySQLConexion8.getConexion();			
			String sql = "delete from tb_usuarios where codigo = ?";			
			pst = con.prepareStatement(sql);
				
			pst.setInt(1, codigo);
			
			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en Eliminar : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}
		
		return rs;
	}

	@Override
	public int actualizar(Usuario u) {
		int rs = 0; // Valor x default en caso de error
		
		Connection con = null; // Sirve para la conex.
		PreparedStatement pst = null; // Para las sentencias

		try {
			// 01. Obtener la conexion
			con = MySQLConexion8.getConexion();
			// 02. Crear la cadena que haga una sentencia a utilizar
			String sql = "update tb_usuarios set nombre   = ?, apellido = ?, fnacim = ? where codigo = ?";
			// 03. Se prepara la sentencia a ejecutar
			pst = con.prepareStatement(sql);
			// Como la cadena tiene 4 ?, se setea
			pst.setString(1, u.getNombre());
			pst.setString(2, u.getApellido());
			pst.setString(3, u.getFnacim());
			pst.setInt(4, u.getCodigo());
			// 04. Ejecutamos la sentencia y guardamos el resultado
			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en actualizar : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}
		
		return rs;
	}

	@Override
	public ArrayList<Usuario> listado() {
		// TODO Auto-generated method stub
		return null;
	}

}
