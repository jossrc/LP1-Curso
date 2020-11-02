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
		
		
		return lista;
	}

}
