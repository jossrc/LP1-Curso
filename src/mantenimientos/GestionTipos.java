package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.TiposInterface;
import model.Tipos;
import util.MySQLConexion8;

public class GestionTipos implements TiposInterface {

	@Override
	public ArrayList<Tipos> listado() {
		
		ArrayList<Tipos> lista = new ArrayList<Tipos>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_tipo";

			pst = con.prepareStatement(sql);		

			rs = pst.executeQuery();			
			
			while(rs.next()) {	
				
				int id = rs.getInt(1);
				String descripcion = rs.getString(2);
				
				Tipos t = new Tipos(id, descripcion);
				
				lista.add(t);
			}

		} catch (Exception e) {
			System.out.println("Error en listado (Tipos) " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}
		
		return lista;
	}

}
