package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ProductoCategInterface;
import model.RepProductoCategoria;
import util.MySQLConexion8;

public class GestionRepProductCat implements ProductoCategInterface {

	@Override
	public ArrayList<RepProductoCategoria> listado() {		
		ArrayList<RepProductoCategoria> lista = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			lista = new ArrayList<RepProductoCategoria>();
			while (rs.next()) {

				String codigo = rs.getString(1);
				String nombre = rs.getString(2);
				int stock = rs.getInt(3);
				double precio = rs.getDouble(4);
				String categoria = rs.getString(5);

				RepProductoCategoria prod = new RepProductoCategoria(codigo, nombre, stock, precio, categoria);

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
