package jdbc;

public class DAOTeste {

	public static void main(String[] args) {
		DAO dao = new DAO();
		
		String sql = "INSERT INTO tb_pessoas (nome, id_pessoa) VALUES (?, ?)";
		System.out.println(dao.incluir(sql, "João da Silva", 10));
		System.out.println(dao.incluir(sql, "Ana Julia", 11));
		System.out.println(dao.incluir(sql, "Djalma Pereira", 12));

	}

}
