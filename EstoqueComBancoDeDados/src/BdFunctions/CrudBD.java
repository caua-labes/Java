package BdFunctions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import Models.Categoria;

public class CrudBD {
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
		return listaCategorias;
	}
}
