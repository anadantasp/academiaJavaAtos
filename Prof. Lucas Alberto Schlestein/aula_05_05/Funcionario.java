package atos;

public class Funcionario extends Pessoa2 {
	
	private String setor;
	private String cargo;
	private String funcao;
	
	public Funcionario (String nome, int idade, String telefone, String setor, String cargo, 
			String funcao) {
		super(nome,idade,telefone);
		this.setor = setor;
		this.cargo = cargo;
		this.funcao = funcao;
		
	}
	
	
	public void exibirDados(String nome, int idade, String telefone, String setor, String cargo, String
			funcao) {
		System.out.println("Nome: " + nome
				+ "\nIdade: "+idade
				+ "\nTelefone: " + telefone
				+ "\nSetor: " + setor
				+ "\nCargo: "+ cargo
				+ "\nFunção " + funcao);	
	}
	
	

}
