package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarRegistro {

	public static void main(String[] args) throws SQLException {
		Connection conexao = FabricaConexao.getConexao();
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("Escreva o id do nome que será atualizado: ");
		int idAtualizado = entrada.nextInt();
		
		String select = "SELECT * FROM tb_pessoas WHERE id_pessoa = ?";
		String update = "UPDATE tb_pessoas SET nome = ? WHERE id_pessoa = ?";
		PreparedStatement stmt = conexao.prepareStatement(select);
		stmt.setInt(1, idAtualizado);
		
		ResultSet resultado = stmt.executeQuery();
		
		if(resultado.next()) {
			int id = resultado.getInt("id_pessoa");
			String nome = resultado.getString("nome");
			Pessoa p = new Pessoa(id, nome);
			
			System.out.println("O nome atual é: " + p.getNome());
			entrada.nextLine();
			
			System.out.print("Digite o novo nome: ");
			String novoNome = entrada.nextLine();
			
			stmt.close();
			stmt = conexao.prepareStatement(update);
			stmt.setString(1, novoNome);
			stmt.setInt(2, idAtualizado);
			stmt.execute();
			
			System.out.println("Pessoa alterada com sucesso!");
		}
		entrada.close();
		stmt.close();
		conexao.close();
	}

}
