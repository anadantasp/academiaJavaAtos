package com.atos.biblioteca;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrincipalBD {

	public static void main(String[] args) throws SQLException {

		// INSTANCIANDO A CLASSE BancoDados
		BancoDados bd = new BancoDados();

		// STRING DE CONEXÃO JDBC
		String url = "jdbc:mysql://localhost:3306/db_biblioteca?user=root&password=";

		// DRIVER MYSQL
		String driver = "com.mysql.cj.jdbc.Driver";

		// ResulSet "Tabela" com os valores retornados da busca
		ResultSet resultado = null;

		// REALIZANDO CONEXEÃO COM O BANCO DE DADOS
		System.out.println(bd.conectar(url, driver));

		// INSERINDO DADOS NA TABELA tb_categoria

		//System.out.println(bd.InserirAlterarExcluir("insert into tb_categoria (descricao) values ('Terror')"));

		resultado = bd.consultar("select * from tb_categoria");
		if (resultado != null)
			while (resultado.next()) {
				System.out.println(
						"id: " + resultado.getString("ID") + "\t descricao: " + resultado.getString("descricao"));
			}
		System.out.println("\n");
		
		// INSERINDO DADOS NA TABELA tb_editora

		//System.out.println(bd.InserirAlterarExcluir("insert into tb_editora (nome) values ('Suma')"));
		
		resultado = bd.consultar("select * from tb_editora");
		if (resultado != null)
			while (resultado.next()) {
				System.out.println("id: " + resultado.getString("id") + "\t nome: " + resultado.getString("nome"));
			}
		System.out.println("\n");

		// INSERINDO DADOS NA TABELA tb_autor

		//System.out.println(bd.InserirAlterarExcluir("insert into tb_autor (nome, nacionalidade) values ('Stephen King', 'EUA')"));

		resultado = bd.consultar("select * from tb_autor");
		if (resultado != null) {
			while (resultado.next()) {
				System.out.println("id: " + resultado.getString("id") + "\t nome: "+ resultado.getString("nome") + "\t nacionalidade: "
						+ resultado.getString("nacionalidade"));
			}
		}
		System.out.println("\n");

		// INSERINDO DADOS NA TABELA tb_livro

		//System.out.println(bd.InserirAlterarExcluir("insert into tb_livro (isbn, titulo, ano, fk_categoria, fk_editora) values (9788581050485, 'O Iluminado', 2012, 4, 6)"));
		
		resultado = bd.consultar("select * from tb_livro");
		if (resultado != null) {
			while (resultado.next()) {
				System.out.println("isbn: " + resultado.getString("isbn") + "\t titulo: "
						+ resultado.getString("titulo") + "\t ano: " + resultado.getString("ano") + "\t fk_categoria: "
						+ resultado.getString("fk_categoria") + "\t fk_editora: " + resultado.getString("fk_editora"));
			}
		}
		System.out.println("\n");

		// INSERINDO DADOS NA TABELA tb_livro_autor

		//System.out.println(bd.InserirAlterarExcluir("insert into tb_livro_autor (fk_livro, fk_autor) values (9788581050485, 7)"));
		
		resultado = bd.consultar("select * from tb_livro_autor");
		if (resultado != null) {
			while (resultado.next()) {
				System.out.println("fk_livro: " + resultado.getString("fk_livro") + "\t fk_autor: "
						+ resultado.getString("fk_autor"));
			}
		}
		System.out.println("\n");
		
		
		//Crie uma consulta para relacionar todos os dados disponíveis de todos os livros existentes na biblioteca em ordem alfabética de título
		resultado = bd.consultar("select * from tb_livro order by titulo asc");
		if (resultado != null) {
			while (resultado.next()) {
				System.out.println("isbn: " + resultado.getString("isbn") + "\t título: "
						+ resultado.getString("titulo") + "\t ano: " + resultado.getString("ano") + "\t fk_categoria: "
						+ resultado.getString("fk_categoria") + "\t fk_editora: " + resultado.getString("fk_editora"));
			}
		}
		System.out.println("\n");

		//Crie uma consulta para relacionar todos os dados disponíveis de todos os livros existentes na biblioteca por ordem Alfabética de autor
		resultado = bd.consultar(
				"select tb_autor.nome, tb_livro.isbn, tb_livro.titulo, tb_livro.ano, tb_livro.fk_categoria, tb_livro.fk_editora \r\n"
						+ "from tb_livro_autor \r\n"
						+ "inner join tb_livro on tb_livro.isbn = tb_livro_autor.fk_livro\r\n"
						+ "inner join tb_autor on tb_autor.id = tb_livro_autor.fk_autor\r\n"
						+ "where tb_livro.isbn order by tb_autor.nome asc");
		if (resultado != null) {
			while (resultado.next()) {
				System.out.println("isbn: " + resultado.getString("isbn") + "\t título: "
						+ resultado.getString("titulo") + "\t ano: " + resultado.getString("ano") + "\t fk_categoria: "
						+ resultado.getString("fk_categoria") + "\t fk_editora: " + resultado.getString("fk_editora")
						+ "\t nome: " + resultado.getString("tb_autor.nome"));
			}
		}
		System.out.println("\n");

		
		//Crie uma consulta para relacionar todos os dados disponíveis dos livros da categoria de literatura Juvenil em ordem de ano
		resultado = bd.consultar(
				"select tb_categoria.descricao, tb_livro.ano, tb_livro.isbn, tb_livro.titulo, tb_livro.fk_categoria, tb_livro.fk_editora\r\n"
						+ "from tb_livro\r\n" + "inner join tb_categoria on tb_livro.fk_categoria = tb_categoria.id\r\n"
						+ "where tb_categoria.descricao = \"Literatura Juvenil\" order by tb_livro.ano asc;");
		if (resultado != null) {
			while (resultado.next()) {
				System.out.println("categoria: " + resultado.getString("tb_categoria.descricao") + "\t isbn: "
						+ resultado.getString("tb_livro.isbn") + "\t titulo: " + resultado.getString("tb_livro.titulo")
						+ "\t ano: " + resultado.getString("tb_livro.ano") + "\t fk_categoria: "
						+ resultado.getString("tb_livro.fk_categoria") + "\t fk_editora: "
						+ resultado.getString("tb_livro.fk_editora"));
			}
		}
		System.out.println("\n");

		
		//Crie uma consulta para relacionar todos os dados disponíveis dos livros de humor e ficção científica com ano entre 2000 e 2010
		resultado = bd.consultar(
				"select tb_categoria.descricao, tb_livro.ano, tb_livro.isbn, tb_livro.titulo, tb_livro.fk_categoria, tb_livro.fk_editora\r\n"
						+ "from tb_livro\r\n" + "inner join tb_categoria on tb_livro.fk_categoria = tb_categoria.id\r\n"
						+ "where tb_categoria.descricao in (\"Ficção Científica\", \"Humor\") and tb_livro.ano between 2000 and 2010 order by tb_livro.ano");
		if (resultado != null) {
			while (resultado.next()) {
				System.out.println("categoria: " + resultado.getString("tb_categoria.descricao") + "\t isbn: "
						+ resultado.getString("tb_livro.isbn") + "\t titulo: " + resultado.getString("tb_livro.titulo")
						+ "\t ano: " + resultado.getString("tb_livro.ano") + "fk_categoria: "
						+ resultado.getString("tb_livro.fk_categoria") + "\t fk_editora: "
						+ resultado.getString("tb_livro.fk_editora"));
			}
		} 
	}

}
