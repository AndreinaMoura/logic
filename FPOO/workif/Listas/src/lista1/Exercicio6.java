package lista1;

import java.util.Scanner;

public class Exercicio6 {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		/* 6 – Desenvolva um programa que leia o raio (cm) e a altura (cm) de um 
		 * cilindro. Calcule e mostre a área (cm2) e o volume (cm3) do cilindro.*/
		float area,volume,base,r,pi = 3,14,h;
		System.out.print("Digite o raio do cilindo(cm): ");
		r = entrada.nextFloat();
		System.out.print("Digite a altura do cilindo(cm): ");
		h = entrada.nextFloat();
		base=pi*(r*r);
		area=pi*r*(r+h);
		volume=base*h;
		System.out.print("A área em cm do cilindro é "+area);
		System.out.print("O volume em cm do cilindro é "+volume);

	}

}
