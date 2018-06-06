package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {

	public boolean validar(Usuario usuario) {

		String sqlSelect = "SELECT username, password FROM usuario WHERE username = ? AND password = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, usuario.getUsername());
			stm.setString(2, usuario.getPassword());

			try (ResultSet rs = stm.executeQuery();) {

				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		return false;
	}
	
	public void cadastrar(Usuario usuario) {
		
		String sqlInsert = "INSERT INTO usuario(username, password) VALUES (?, ?)";
		
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			
			stm.setString(1, usuario.getUsername());
			stm.setString(2, usuario.getPassword());
			

			stm.execute();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
	
	}
}


