package atos;

public class Carro {


		public String fabricante; //= "Fiat";
		public String modelo; // = "Chronos";
		
		public Carro(String fabricante, String modelo) {
			this.fabricante = fabricante;
			this.modelo = modelo;
		}

		public void ligar() {
			System.out.println("Ligado");
		}

		public void desligar() {
			System.out.println("Desligado");
		}

		public void exibirDados() {
			System.out.println("Fabricante: " + fabricante + " | Modelo: " + modelo);
		}

}



