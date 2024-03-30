package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectBd {
							  //   url comun     local do banco nome do database
	static final String URL = "jdbc:postgresql://localhost:5432/PrimeiroBd";
	static final String USER = "postgres";
	static final String PASS = "cabrazoera29";

	public static Connection criarConexao() throws ClassNotFoundException, SQLException{
	Class.forName("org.postgresql.Driver");
	Connection conecta = DriverManager.getConnection(URL, USER, PASS);
	if (conecta != null){
	return conecta;
	}
	return null;
	}
	
}
