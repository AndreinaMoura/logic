package exerc;

import java.util.Scanner;

public class Exercicios10 {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		/* 10 – Pedra mineira é um tipo de piso muito utilizado para revestir 
		 * o chão em volta de piscinas, dez quilos de pedra mineira custam 
		 * R$ 130,00 e revestem uma área de 3,7 m2. Desenvolva um programa 
		 * que leia a área total (m2) a ser revestida, calcule e apresente na 
		 * tela o total de quilos de pedra mineira que serão necessários para o 
		 * revestimento e o seu custo total (R$). O programa deverá apresentar os 
		 * valores monetários formatados com duas casas decimais.*/
		
		int area,areatotal,valor;
		double kg=13.00,revest=0.37;
		System.out.print("Digite o valor total da área(m2): ");
		areatotal=entrada.nextInt();
		area = areatotal/revest;
		valor = area*kg;
		System.out.print("A quantidade de revestimento por kg é  "+area);
		System.out.print("Custo total será de "+valor);
		
	}

}
