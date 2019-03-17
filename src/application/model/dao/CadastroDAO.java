package application.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.db.MySQLConnection;

public class CadastroDAO {
	
	public static void cadastrar(String nome, String sobrenome, String usuario, String email, String senha) {
		
		Connection connect = null;
		PreparedStatement st = null;
		
		try {
			connect = MySQLConnection.getConnection();
			st = connect.prepareStatement(
					"INSERT INTO perfil "
					+"(nome, sobrenome) "
					+"VALUES "
					+"(?, ?)");
			st.setString(1, nome);
			st.setString(2, sobrenome);
			st.executeUpdate();
			
			st = connect.prepareStatement(
					"INSERT INTO usuario "
					+"(usuario, email, senha) "
					+"VALUES "
					+"(?, ?, ?)");
			st.setString(1, usuario);
			st.setString(2, email);
			st.setString(3, senha);
			st.executeUpdate();
			
			
			MySQLConnection.closeConnection();
			MySQLConnection.CloseStatement(st);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			//new DbException("Erro ao cadastrar dados no banco de dados!");
		}
		
	}
	
	
}
