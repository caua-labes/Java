package BdFunctions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

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
}
