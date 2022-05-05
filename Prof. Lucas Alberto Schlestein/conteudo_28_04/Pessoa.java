package atos;

public class Pessoa {

	private String nome;
	private int idade;
	
	Pessoa(String nome, int idade){
		this.nome = nome;
		this.idade = idade;
	}
	
	Pessoa (int idade){
		this.idade = idade;
	}
	
	public void mostrarDadosCompleto() {
		System.out.println("Nome: " + nome + "\nIdade: " + idade);
	}
	
	public void mostrarDadosIncompletos() {
		System.out.println("Idade: " + idade);
	}

}
