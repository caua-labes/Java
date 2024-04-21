package BdFunctions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import Models.Categoria;
import Models.Produto;

public class CrudProdutosBd {
	public static boolean insertProduto(Produto produto) {
		try(Connection bd = BdConnect.criarConexao()){
	        String comBd = "INSERT INTO produtos(descricao, valorun, quantidade, categoriaid) VALUES (?, ?, ?, ?)";
			try(PreparedStatement statement = bd.prepareStatement(comBd)){
				statement.setString(1, produto.getDescricao());
				statement.setDouble(2, produto.getValorUni());
				statement.setInt(3, produto.getQuantidade());
				statement.setInt(4, produto.getCategoriaId());
				if(statement.executeUpdate() > 0) {
					return true;
				}
			}
			catch(Exception ex) {
				System.out.println("Erro na função de banco de dados -> " + ex);
			}			
		}
		catch(Exception ex) {
			System.out.println("Erro em conexão com banco de dados -> " + ex);
		}
		return false;
	}
	public static LinkedList<Produto> selectProduto(){
		LinkedList<Produto> lista = new LinkedList<Produto>();
		try(Connection bd = BdConnect.criarConexao()){
			ResultSet select = bd.createStatement().executeQuery("select * from produtos");
			while(select.next()) {
				Produto produto = new Produto();
				produto.setId(select.getInt("id"));
				produto.setDescricao(select.getString("descricao"));
				produto.setValorUni(select.getDouble("valorun"));
				produto.setQuantidade(select.getInt("quantidade"));
				produto.setCategoriaId(select.getInt("categoriaid"));
				produto.setCategoria(BdFunctions.CrudCategoriasBd.selectId(select.getInt("categoriaid")));
				lista.add(produto);
			}
		}
		catch(Exception ex) {
			System.out.println("Erro em conexão com banco de dados -> " + ex);
		}
		return lista;
	}
	public static boolean deleteProduto(int id) {
		try (Connection bd = BdConnect.criarConexao()){
			return bd.createStatement().execute("delete from produtos where id = "+ id);
		}
		catch(Exception ex) {
			System.out.println("Erro em conexão com banco de dados -> " + ex);
		}
		return false;
		
	}
	public static Produto selectId (int id) {
		Produto produto = new Produto();
		try(Connection bd = BdFunctions.BdConnect.criarConexao()){
			try(ResultSet rs = bd.createStatement().executeQuery("select * from produtos where id = "+id)){
			while(rs.next()) {
				produto.setId(rs.getInt("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setValorUni(rs.getDouble("valorun"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setCategoriaId(rs.getInt("categoriaid"));
				produto.setCategoria(CrudCategoriasBd.selectId(rs.getInt("categoriaid")));
			}
			}
			catch(Exception ex) {
				System.out.print("Erro ao executar select id -> "+ ex);
			}
			
		}
		catch(Exception ex) {
			System.out.println("Erro em conexão com banco de dados -> " + ex);
		}
		return produto;
	}
	public static boolean updateProduto(Produto produto) {
		try(Connection bd = BdFunctions.BdConnect.criarConexao()){
			String com = "Update produtos set descricao = ?, valorun = ?, quantidade = ?, categoriaid = ? where id = " + produto.getId();
		  //String com = "UPDATE produtos SET descricao = ?, valorun = ?, quantidade = ?, categoriaid = ? WHERE id = " + produto.getId();
			try(PreparedStatement statement = bd.prepareStatement(com)){
				statement.setString(1, produto.getDescricao());
				statement.setDouble(2, produto.getValorUni());
				statement.setInt(3, produto.getQuantidade());
				statement.setInt(4, produto.getCategoriaId());
				if(statement.executeUpdate() > 0) {
					return true;
				}
			}
			catch(Exception ex) {
				System.out.print("Erro ao executar update -> "+ ex);
			}
		}
		catch(Exception ex) {
			System.out.println("Erro em conexão com banco de dados -> " + ex);
		}
		return false;
				
	}
}
