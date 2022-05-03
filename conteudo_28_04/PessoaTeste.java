package atos;

import java.util.Scanner;

public class PessoaTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int opcao;
		String nome;
		int idade;
		
		System.out.println("Digite a opção desejada: ");
		System.out.println("[1]-Fornecer nome e idade\t\t");
		System.out.println("[2]-Fornecer apenas idade");
		opcao = scan.nextInt();
		System.out.println("");
		
		if(opcao == 1) {
			System.out.println("Nome: ");
			nome = scan.next();
			System.out.println("Idade: ");
			idade = scan.nextInt();
			System.out.println("");
			
			Pessoa pessoa1 = new Pessoa(nome, idade);
			pessoa1.mostrarDadosCompleto();
		} else if (opcao == 2) {
			System.out.println("Idade: ");
			idade = scan.nextInt();
			System.out.println("");
			
			Pessoa pessoa2 = new Pessoa(idade);
			pessoa2.mostrarDadosIncompletos();
		} else {
			System.out.println("OPÇÃO INVÁLIDA");
		}

	}

}
