package mantenimientos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.ArrayList;

import interfaces.VentaInferface;
import model.CabeceraBoleta;
import model.DetalleBoleta;
import util.MySQLConexion8;

public class GestionVenta implements VentaInferface {

	@Override
	public String generaNumBoleta() {
		String codigo = "B0001"; // Default
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				DecimalFormat df = new DecimalFormat("0000");
				codigo = "B" + df.format(Integer.parseInt(rs.getString(1)) + 1);
			}
			
		} catch (Exception e) {
			System.out.println("Error en generar nm boleta : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}

		return codigo;
	}

	@Override
	public int realizarVenta(CabeceraBoleta cabeBol, ArrayList<DetalleBoleta> detBol) {
		int ok = -1;
		
		Connection con = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		PreparedStatement pst3 = null;
		
		try {
			con = MySQLConexion8.getConexion();
			
			// Anula el autocommit
			con.setAutoCommit(false);
			
			// Registrar los datos de la cabecera de boleta
			String sql1 = "";
			pst1 = con.prepareStatement(sql1);
			// Parametros
			pst1.setString(1, cabeBol.getNum_bol());
			pst1.setString(2, cabeBol.getFch_bol());
			pst1.setInt(3, cabeBol.getCod_cliente());
			pst1.setInt(4, cabeBol.getCod_vendedor());
			pst1.setDouble(5, cabeBol.getTotal_bol());
			// Ejecuta la sentencia
			ok = pst1.executeUpdate();
			
			// Registrar los datos de los detalle de boleta
			String sql2 = "";
			for (DetalleBoleta det : detBol) {
				pst2 = con.prepareStatement(sql2);
				// Parametros
				pst2.setString(1, cabeBol.getNum_bol());
				pst2.setString(2, det.getIdprod());
				pst2.setInt(3, det.getCantidad());
				pst2.setDouble(4, det.getPrecioVta());
				pst2.setDouble(5, det.getImporte());
				// Ejecuta la sentencia
				ok = pst2.executeUpdate();
			}
			
			// Actualizar los productos registrados en el detalle
			String sql3 = "";
			for (DetalleBoleta det : detBol) {
				pst3 = con.prepareStatement(sql3);
				// Parametros
				pst3.setInt(1, det.getCantidad());
				pst3.setString(2, det.getIdprod());
				// Ejecuta la sentencia
				ok = pst3.executeUpdate();
			}
			
			// Confirmar las transacciones si no hay problemas
			con.commit();			
			
		} catch (Exception e) {
			System.out.println("Error al realizar la venta : " + e.getMessage());
			ok = -1;
			
			try {
				con.rollback();
			} catch (SQLException e2) {
				System.out.println("Error al restaurar: " + e2.getMessage());
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e3) {
				System.out.println("Error al cerrar: " + e3.getMessage());
			}
		}
		
		return ok;
	}

}
