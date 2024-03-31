package Main;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		try {
		  Connection con = ConectBd.criarConexao();
		  ResultSet res = con.createStatement().executeQuery("select * from public.categorias");
		  Integer r = con.createStatement().executeUpdate("insert into categorias(nome) values ('Cereais');");
		  System.out.println(r);
			while(res.next()) {
			    int id = res.getInt("id");
			    String nome = res.getString("nome");
			    System.out.println("ID: " + id + ", Nome: " + nome);
			}
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
