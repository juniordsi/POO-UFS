package application.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.db.ConnectionFactory;
import application.db.DbException;
import application.model.Usuario;

public class UsuarioDAO {
	
	private Connection connect;
	
	public UsuarioDAO() {
		connect = new ConnectionFactory().getConnection();
	}
	
	public Boolean logar (Usuario usuario) {
		Boolean situation = false;
		
		try {
			Statement st = connect.createStatement();
			ResultSet rs = st.executeQuery("SELECT user, email, password FROM usuario");
			
			while(rs.next()) {
				if (rs.getString("user").equals(usuario.getLogin()) || rs.getString("email").equals(usuario.getLogin())) {
					if (rs.getString("password").equals(usuario.getPassword())) {
						situation = true;
					}
				}
			}
			ConnectionFactory.closeConnection(connect, st, rs);
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		return situation;
	}
	
	public void cadastrar (Usuario usuario) {
		String sql = "INSERT INTO usuario (user, email, password, name, gender) VALUES (?, ?, ?, ?, ?);";
		try {
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setString(1, usuario.getUser());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getPassword());
			pst.setString(4, usuario.getName());
			pst.setString(5, usuario.getGender());
			pst.executeUpdate();
			
			ConnectionFactory.closeConnection(connect, pst);
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public Usuario feed(String login) {
		Usuario usuario = new Usuario();
		try {
			Statement st = connect.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE user = '"+login+"'");
			
			while(rs.next()) {
				usuario.setUser(rs.getString("user"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));
				usuario.setName(rs.getString("name"));
				usuario.setGender(rs.getString("gender"));
				usuario.setFollowers(rs.getInt("followers"));
				usuario.setFollowing(rs.getInt("following"));
			}
			
			
			ConnectionFactory.closeConnection(connect, st, rs);
		} catch (SQLException e) {
			System.out.println("Erro na conexão!!!");
		}
		return usuario;
	}
	
	public Usuario busca(String login) {
		Usuario usuario = new Usuario();
		try {
			Statement st = connect.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM usuario where user = '"+login+"'");
			
			if (rs != null) {
				while(rs.next()) {
					usuario.setUser(rs.getString("user"));
					usuario.setEmail(rs.getString("email"));
					usuario.setPassword(rs.getString("password"));
					usuario.setName(rs.getString("name"));
					usuario.setGender(rs.getString("gender"));
					usuario.setFollowers(rs.getInt("followers"));
					usuario.setFollowing(rs.getInt("following"));
				}
			} else {
				usuario = null;
			}
			
			ConnectionFactory.closeConnection(connect, st, rs);
			
		} catch (SQLException e) {
			System.out.println("Erro na conexão!!!");
		}
		return usuario;
	}
	
	public Usuario somaSeguidor(String usuario) {
		String sql = "UPDATE usuario SET followers = followers + ? WHERE (user = ?)";
		try {
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setInt(1, 1);
			pst.setString(2, usuario);
			pst.executeUpdate();
			
			ConnectionFactory.closeConnection(connect, pst);
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		return busca(usuario);
	}
	
	public Usuario subtraiSeguidor(String usuario) {
		String sql = "UPDATE usuario SET followers = followers - ? WHERE (user = ?)";
		try {
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setInt(1, 1);
			pst.setString(2, usuario);
			pst.executeUpdate();
			
			ConnectionFactory.closeConnection(connect, pst);
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		return busca(usuario);
	}

}
		

//		
