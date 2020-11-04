package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ProductoInterface;
import model.Producto;
import util.MySQLConexion8;

public class GestionProductos implements ProductoInterface {

	@Override
	public ArrayList<Producto> listadoProductos() {
		ArrayList<Producto> lista = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_productos";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			lista = new ArrayList<Producto>();
			while (rs.next()) {

				String codigo = rs.getString(1);
				String producto = rs.getString(2);
				int cantidad = rs.getInt(3);
				double precio = rs.getDouble(4);
				int tipo = rs.getInt(5);
				int estado = rs.getInt(6);

				Producto prod = new Producto(codigo, producto, cantidad, precio, tipo, estado);

				lista.add(prod);
			}
		} catch (Exception e) {
			System.out.println("Error en listado (Productos) " + e.getMessage());
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

		return lista;
	}

}
