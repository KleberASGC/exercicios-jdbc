package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsultarPessoas2 {

	public static void main(String[] args) throws SQLException {
		Connection conexao = FabricaConexao.getConexao();
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("Escreva o nome a ser buscado no banco: ");
		String nome = entrada.nextLine();
		nome = "%" + nome + "%";
		
		String sql = "SELECT * FROM tb_pessoas WHERE nome LIKE ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		
		ResultSet resultado = stmt.executeQuery();
		
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		while(resultado.next()) {
			int id = resultado.getInt("id_pessoa");
			nome = resultado.getString("nome");
			pessoas.add(new Pessoa(id, nome));
		}
		
		for(Pessoa p : pessoas) {
			System.out.println(p.getId() + " ==> " + p.getNome());
		}

		entrada.close();
		stmt.close();
		conexao.close();
	}

}
