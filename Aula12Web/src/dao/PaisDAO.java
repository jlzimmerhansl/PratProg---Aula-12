package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Pais;

public class PaisDAO {

		public int criar(Pais pais) {
			
			String sqlInsert = "INSERT INTO pais(nome, populacao, area, continente) VALUES (?, ?, ?, ?)";
			
			try(Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlInsert);){
				
				stm.setString(1, pais.getNome());
				stm.setLong(2, pais.getPopulacao());
				stm.setDouble(3, pais.getArea());
				stm.setString(4, pais.getContinente());

				stm.execute();
				String sqlQuery = "SELECT LAST_INSERT_ID() ";
				
				try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
						ResultSet rs = stm2.executeQuery();){
					
					if(rs.next()) {
						pais.setId(rs.getInt(1));
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return pais.getId();
		}
		
		public Pais atualizar(Pais pais) {
			
			String sqlUpdate = "UPDATE pais SET nome = ?, populacao = ?, area = ?, continente = ? WHERE id = ?";

			try(Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
				
				stm.setString(1, pais.getNome());
				stm.setLong(2, pais.getPopulacao());
				stm.setDouble(3, pais.getArea());
				stm.setString(4, pais.getContinente());
				stm.setInt(5, pais.getId());
				stm.executeUpdate();
				
			}catch (Exception e) {
				
				e.printStackTrace();
			}
			return pais;
		}
		
		public void excluir(int id) {
			
			String sqlDelete = "DELETE FROM pais WHERE id = ?";
			
			try(Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlDelete);){
				
				stm.setInt(1, id);
				stm.executeUpdate();
				
			}catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	
		public Pais carregar(int id) {
			Pais pais = new Pais();
			pais.setId(id);
			String sqlSelect = "SELECT nome, populacao, area, continente FROM pais WHERE pais.id = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, pais.getId());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						pais.setNome(rs.getString("nome"));
						pais.setPopulacao(rs.getLong("populacao"));
						pais.setArea(rs.getDouble("area"));
						pais.setContinente(rs.getString("continente"));
					} else {
						pais.setId(-1);
						pais.setNome(null);
						pais.setPopulacao(-1);
						pais.setArea(-1);
						pais.setContinente(null);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return pais;
		}
		
		public Pais maiorPopulacao() {
			
			String sqlSelect = " SELECT * FROM pais WHERE populacao IN (SELECT MAX(populacao) FROM pais)";
			
			try (Connection conn = ConnectionFactory.obtemConexao()){
				
				PreparedStatement stm = conn.prepareStatement(sqlSelect);
				
				ResultSet rs = stm.executeQuery();
				
				Pais pais = new Pais();
				
				if(rs.next()) {
					
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					pais.setContinente(rs.getString("continente"));

				}
				
				return pais;
				
			} catch(SQLException e) {
				
				e.printStackTrace();
				
			}
			return null;
			
		}
		
		public Pais menorPopulacao() {
			
			String sqlSelect = "SELECT * FROM pais WHERE area IN (SELECT MIN(area) FROM pais)";
			
			try (Connection conn = ConnectionFactory.obtemConexao()){
				
				PreparedStatement stm = conn.prepareStatement(sqlSelect);
				
				ResultSet rs = stm.executeQuery();
				
				Pais pais = new Pais();
				
				if(rs.next()) {				
					
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					pais.setContinente(rs.getString("continente"));

				}
				
				return pais;
				
			}catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return null;
		}
		
		//vetor
		public ArrayList<Pais>  vetor (){
			String sqlSelect = "SELECT * FROM pais LIMIT 3";
			
			try (Connection conn = ConnectionFactory.obtemConexao()){
				
				PreparedStatement stm = conn.prepareStatement(sqlSelect);
				
				ResultSet rs = stm.executeQuery();
				
				Pais pais = new Pais();

				
				ArrayList <Pais> vetor = new ArrayList<Pais>();
				
				while(rs.next()) {
					
					
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					pais.setContinente(rs.getString("continente"));

					
					vetor.add(pais);
				}
				
				return vetor;
			}catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return null;
			
		}
		
		
		
		
		public List<Pais> listar() {
			String sqllistar = "SELECT * FROM pais";

			
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqllistar);
					ResultSet rs = stm.executeQuery()){
				
				
				
				List <Pais> vetor = new LinkedList <> ();

				while (rs.next()) {
					Pais pais = new Pais();
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					pais.setContinente(rs.getString("continente"));

					
					vetor.add(pais);
			
				}
				
				return vetor;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			
		}
		
		public ArrayList<Pais> listarContinente(String continente){
			
			String sqlCont = "SELECT id, nome, populacao, area, continente FROM pais WHERE pais.continente = ?";
			try(Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlCont);){
				
				stm.setString(1, continente);
				
				try(ResultSet rs = stm.executeQuery();) {
					
					ArrayList<Pais> vetor = new ArrayList<Pais>();
					
					while (rs.next()) {
						Pais pais = new Pais();

						pais.setId(rs.getInt("id"));
						pais.setNome(rs.getString("nome"));
						pais.setPopulacao(rs.getLong("populacao"));
						pais.setArea(rs.getDouble("area"));
						pais.setContinente(rs.getString("continente"));

						vetor.add(pais);
					}
				
					
					return vetor;
				}
				
			}catch (Exception e) {
					e.printStackTrace();
				}
			
			
				return null;
		
		}
		
		

		
		
	public Pais buscar(String nome) {
			Pais pais = new Pais();
			pais.setNome(nome);
			String sqlBusca = "SELECT * FROM pais WHERE pais.nome = ?";
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlBusca);) {
				stm.setString(1, nome);
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						pais.setId(rs.getInt("id"));
						pais.setNome(rs.getString("nome"));
						pais.setPopulacao(rs.getLong("populacao"));
						pais.setArea(rs.getDouble("area"));
						pais.setContinente(rs.getString("continente"));
					} else {
						pais.setId(-1);
						pais.setNome(null);
						pais.setPopulacao(-1);
						pais.setArea(-1);
						pais.setContinente(null);

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return pais;
		}


}







