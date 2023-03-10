package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoas1 {

	public static void main(String[] args) throws SQLException {
		Connection conexao = FabricaConexao.getConexao();
		String sql = "SELECT * FROM tb_pessoas";
		
		Statement stmt = conexao.createStatement();
		ResultSet resultado = stmt.executeQuery(sql);
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		while(resultado.next()) {
			int id = resultado.getInt("id_pessoa");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(id, nome));
		}
		
		for(Pessoa p: pessoas) {
			System.out.println(p.getId() + " ==> " + p.getNome());
		}
		
		stmt.close();
		conexao.close();
	}

}
