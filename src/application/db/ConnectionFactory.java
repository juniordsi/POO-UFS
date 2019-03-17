package application.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private final String DRIVER = "con.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/poogram?serverTimezone=UTC";
	private final String USER = "root";
	private final String PASS = "";
	
	public Connection getConnection() {
		
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Erro na conexão: ", e);
		} 
	}
	
	public static void closeConnection(Connection connect) {
		try {
			if (connect != null) {
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(Connection connect, PreparedStatement st) {
		closeConnection(connect);
		
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(Connection connect, PreparedStatement st, ResultSet rs) {
		closeConnection(connect, st);
		
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
