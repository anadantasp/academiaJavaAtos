package atos;

public class Moto {

	private String marca;
	private String modelo;
	private double cilindradas;
	
	public void setValor(String marca, String modelo, double cilindradas) {
		this.marca = marca;
		this.modelo = modelo;
		this.cilindradas = cilindradas;
	}
	
	public void getValor() {
		System.out.println("Marca: " + marca + "\nModelo: " + modelo + "\nCilindradas: " + cilindradas);
	}
}
