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
		// TODO Auto-generated method stub
		return 0;
	}

}
