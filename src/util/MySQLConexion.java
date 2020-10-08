package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	public static Connection getConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Solo para Mysql 5.7
			String url = "jdbc:mysql://localhost/NOMBREBD"; // 5.7
			String usr = "root";
			String psw = "CLAVE MySQL";
			con = DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException ex) {
			System.out.println("Error >> Driver no Instalado!!");
		} catch (SQLException ex) {
			System.out.println("Error >> de conexión con la BD");
		}
		return con;
	}
}
