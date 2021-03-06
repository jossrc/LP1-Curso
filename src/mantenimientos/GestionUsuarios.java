package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "update tb_usuarios set nombre   = ?, apellido = ?, fnacim = ? where codigo = ?";
			pst = con.prepareStatement(sql);
			// Como la cadena tiene 4 ?, se setea
			pst.setString(1, u.getNombre());
			pst.setString(2, u.getApellido());
			pst.setString(3, u.getFnacim());
			pst.setInt(4, u.getCodigo());

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

		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_usuarios";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
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
			System.out.println("Error en listado : " + e.getMessage());
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
	public Usuario buscar(int cod) {

		Usuario u = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_usuarios where codigo = ?";
			pst = con.prepareStatement(sql);

			pst.setInt(1, cod);

			rs = pst.executeQuery();

			if (rs.next()) {
				int codigo = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellido = rs.getString(3);
				String usuario = rs.getString(4);
				String clave = rs.getString(5);
				String fnacim = rs.getString(6);
				int id_tipo = rs.getInt(7);
				int estado = rs.getInt(8);

				u = new Usuario(codigo, nombre, apellido, usuario, clave, fnacim, id_tipo, estado);

			}
		} catch (Exception e) {
			System.out.println("Error en buscar Usuario : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return u;
	}

	@Override
	public Usuario validarAcceso(String usuario, String clave) {

		Usuario u = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_usuarios where usuario = ? and clave = ?";

			pst = con.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, clave);

			rs = pst.executeQuery();

			if (rs.next()) {
				u = new Usuario();

				u.setCodigo(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setUsuario(rs.getString(4));
				u.setClave(rs.getString(5));
				u.setFnacim(rs.getString(6));
				u.setId_tipo(rs.getInt(7));
				u.setEstado(rs.getInt(8));
			}
		} catch (Exception e) {
			System.out.println("Error en validar Acceso " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar ");
			}
		}

		return u;
	}

}
