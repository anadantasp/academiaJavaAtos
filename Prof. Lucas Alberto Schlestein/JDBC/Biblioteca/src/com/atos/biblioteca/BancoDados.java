package com.atos.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDados {
	Connection conexao;

	public String conectar (String url, String driver) {
		try {
			Class.forName(driver);
			conexao = (Connection) DriverManager.getConnection(url);
			return "Conectado";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return("Não foi possível conectar");
			
		}
	}

	public int InserirAlterarExcluir(String query) {
		int linhas = 0;
		try {
			Statement st = conexao.createStatement();
			linhas = st.executeUpdate(query);
			System.out.println("Operação efetuada com sucesso");
			return linhas;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Operação não efetuada");
		}
		return linhas;
	}
	
	public ResultSet consultar (String query) {
		Statement st;
		ResultSet resultado = null;
		try {
			st = conexao.createStatement();
			resultado = st.executeQuery(query);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	
}
