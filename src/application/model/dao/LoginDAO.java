package application.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.db.DbException;
import application.db.MySQLConnection;

public class LoginDAO {
	
	public static Boolean login (String login, String password) {
		
		Connection connect = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			connect = MySQLConnection.getConnection();
			st = connect.createStatement();
			rs = st.executeQuery("select usuario, email, senha from usuario");
			
			while(rs.next()) {
				if (rs.getString("usuario").equals(login) || rs.getString("email").equals(login)) {
					if (rs.getString("senha").equals(password)) {
						MySQLConnection.CloseStatement(st);
						MySQLConnection.closeConnection();
						return true;
					}
				}
			}
			
		} catch (SQLException e) {
			new DbException("Conexão Fechada, não pode acessar os dados");
		} finally {
			MySQLConnection.CloseStatement(st);
			MySQLConnection.closeConnection();
		}
		return false;
	}
	
}
