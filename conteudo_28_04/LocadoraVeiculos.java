package atos;

import java.util.Scanner;

public class LocadoraVeiculos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner (System.in);
		
		String marcaMoto, modeloMoto;
		double cilindradasMoto;
		
		System.out.println("Insira os dados do carro: ");
		System.out.println("Fabricante: ");
		String fabricanteCarro = scan.next();
		System.out.println("Modelo: ");
		String modeloCarro = scan.next();
		
		Carro carro = new Carro(fabricanteCarro, modeloCarro);
		
		System.out.println("");
		System.out.println("***********************************");
		System.out.println("");
		carro.exibirDados();
		
		
		System.out.println("");
		System.out.println("***********************************");
		System.out.println("");
		System.out.println("Informe os dados da moto: ");
		System.out.println("Marca: ");
		marcaMoto = scan.nextLine();
		scan.nextLine();
		System.out.println("Modelo: ");
		modeloMoto = scan.nextLine();
		System.out.println("Cilindradas: ");
		cilindradasMoto = scan.nextDouble();
		
		Moto moto1 = new Moto();
		moto1.setValor(marcaMoto, modeloMoto, cilindradasMoto);
		System.out.println("");
		moto1.getValor();
		
		System.out.println("");
		System.out.println("***********************************");
		System.out.println("");
		System.out.println("Informe os dados da moto: ");
		System.out.println("Marca: ");
		String marcaMoto2 = scan.nextLine();
		scan.nextLine();
		System.out.println("Modelo: ");
		String modeloMoto2 = scan.nextLine();
		System.out.println("Cilindradas: ");
		float cilindradasMoto2 = scan.nextFloat();
		
		Moto moto2 = new Moto();
		moto2.setValor(marcaMoto2, modeloMoto2, cilindradasMoto2);
		System.out.println("");
		moto2.getValor();

	}

}
