package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {
		final String url = "jdbc:postgresql://localhost:5432/";
		final String usuario = "postgres";
		final String senha = "1q2w3e4r";
		
		Connection conexao = DriverManager
				.getConnection(url, usuario, senha);
		
		System.out.println("Conexão efetuada com sucesso!");
		conexao.close();
	}

}
