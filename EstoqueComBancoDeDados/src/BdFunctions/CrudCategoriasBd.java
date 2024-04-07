package BdFunctions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import Models.Categoria;

public class CrudCategoriasBd{
	public static boolean insertCategoriaBd(Categoria categoria){
		try {
			Connection bd = BdConnect.criarConexao();
			//Este metodo não é recomendado por ser menos seguro a ataques
			//bd.createStatement().executeUpdate("insert into categorias(nome) values()");
			
			//Uma IA me mostrou que este metodo é seguro contra ataques de Sql Injection
			String comBd = "INSERT INTO categorias(Nome) values(?)";
			try (PreparedStatement statement = bd.prepareStatement(comBd)) {
				statement.setString(1, categoria.getNome());
				int VerificacaoDeAtualizacao = statement.executeUpdate();
				if(VerificacaoDeAtualizacao != 0) {
					return true;
				}
			}
			catch (Exception ex) {
				System.out.println("Erro em inserir valores no banco de dados -> " +ex);
			}
		}
		catch (Exception ex) {
			System.out.println("Erro na função de banco de dados -> " +ex);
		}
		return false;
	}
	public static LinkedList<Categoria> selectAll(){
		LinkedList<Categoria> listaCategorias = new LinkedList<Categoria>();
		try {
			Connection bd = BdConnect.criarConexao();
			try(ResultSet rs = bd.createStatement().executeQuery("SELECT * FROM categorias")){
			while(rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setNome(rs.getString("Nome"));
				categoria.setId(rs.getInt("Id"));
				listaCategorias.add(categoria);
			}
			}
			catch (Exception ex) {
				System.out.println("Erro em executar select de banco de dados -> " +ex);
			}
			
		}
		catch (Exception ex) {
			System.out.println("Erro na função de banco de dados -> " +ex);
		}
        Collections.sort(listaCategorias, (a, b) -> a.getNome().compareTo(b.getNome()));
		return listaCategorias;
	}
	public static Categoria selectId(int id) {
		Categoria categoria =new Categoria();
		try {
			Connection bd = BdConnect.criarConexao();
			try(ResultSet res = bd.createStatement().executeQuery("SELECT * FROM categorias Where Id = "+id)){
			while(res.next()) {
				categoria.setId(res.getInt("Id"));
				categoria.setNome(res.getString("Nome"));
			}
			}
			catch (Exception ex) {
				System.out.println("Erro em executar select de banco de dados -> " +ex);
			}
		}
		catch (Exception ex) {
			System.out.println("Erro na função de banco de dados -> " +ex);
		}
		
		return categoria;
	}
	public static boolean updateCategoria(Categoria categoria) {
		try {
			Connection bd = BdConnect.criarConexao();
			String comandoSql = "update categorias set Nome = ? where id =" + categoria.getId();
			try(PreparedStatement statement = bd.prepareStatement(comandoSql)){
				statement.setString(1, categoria.getNome());
				int verificacaoUpdate = statement.executeUpdate();
				if(verificacaoUpdate != 0) {
					return true;
				}
			}
			catch (Exception ex) {
				System.out.println("Erro em executar update de banco de dados -> " +ex);
			}
			
		}
		catch (Exception ex) {
			System.out.println("Erro na função de banco de dados -> " +ex);
		}
		return false;
	}
	public static boolean deleteCategoria(int id) {
		try(Connection bd = BdConnect.criarConexao()){
			try {
				String comBd = "delete from categorias where id = "+id;
				if(bd.createStatement().executeUpdate(comBd) > 0) {
					return true;
				}
			}
			catch (Exception ex) {
				System.out.println("Erro em executar delete no banco de dados -> " +ex);
			}
		}
		catch (Exception ex) {
			System.out.println("Erro na função de banco de dados -> " +ex);
		}
		
		return false;
	}
}
