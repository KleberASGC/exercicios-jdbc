package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {

	public static void main(String[] args) throws SQLException {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe o id da pessoa a ser excluída: ");
		int idExcluido = entrada.nextInt();
		
		Connection conexao = FabricaConexao.getConexao();
		String sql = "DELETE FROM tb_pessoas WHERE id_pessoa > ?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, idExcluido);
		
		int contador = stmt.executeUpdate();
		if (contador > 0) {
			System.out.println("Pessoa excluida com sucesso!");
		} else {
			System.out.println("Nada feito!");
		}
		
		System.out.println("Linhas afetadas: " + contador);
		
		stmt.close();
		entrada.close();
		conexao.close();
	}

}
