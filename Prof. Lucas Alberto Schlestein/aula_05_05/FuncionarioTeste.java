package atos;

import java.util.Scanner;

public class FuncionarioTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner (System.in);
		
		String nome, telefone, cargo, setor, funcao;
		int idade;
		
		System.out.println("*************** CADASTRO ***************");
		System.out.println("Nome: ");
		nome = scan.nextLine();
		System.out.println("Idade: ");
		idade = scan.nextInt();
		System.out.println("Telefone: ");
		telefone= scan.nextLine();
		scan.nextLine();
		System.out.println("Cargo: ");
		cargo = scan.nextLine();
		System.out.println("Setor: ");
		setor = scan.nextLine();
		System.out.println("Função: ");
		funcao = scan.nextLine();
		
		Funcionario funcionario = new Funcionario(nome,idade,telefone,cargo,setor,funcao);
		funcionario.exibirDados(nome, idade, telefone, setor, cargo, funcao);
	}

}
