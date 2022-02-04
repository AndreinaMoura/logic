package Exercicios;

import java.util.Scanner;

public class Ex {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int opcao = 0;
		while(opcao != 11) {
			System.out.print("1-Prorgama\t5-Prorgama\t9-Prorgama\n");
			System.out.print("2-Prorgama\t6-Prorgama\t10-Prorgama\n");
			System.out.print("3-Prorgama\t7-Prorgama\t11-Sair\n");
			System.out.print("4-Prorgama\t8-Prorgama\n\nEscolha: ");
			opcao=scan.nextInt();
			
			switch(opcao) {
			case 1:
				for(int i= 10; i <= 200; i++) {
					System.out.println(i);
				}
				break;
			case 2:
				for(int i= 200; i > 0; i--) {
					System.out.println(i);
				}
				break;
			case 3:
				System.out.print("Digite um valor inteiro: ");
				int valor = scan.nextInt();
				for(int i= 0; i < valor; i++) {
					System.out.println(i);
				}
				break;
			case 4:
				System.out.print("Digite um valor inteiro: ");
				int valor1 = scan.nextInt();
				System.out.print("Digite outro valor inteiro: ");
				int valor2 = scan.nextInt();
				
				for(int i= valor1; i < valor2; i++) {
					System.out.println(i);
				}
				break;
			case 5:
				System.out.print("Digite um valor inteiro par: ");
				int valor3 = scan.nextInt();
				System.out.print("Digite outro valor inteiro par: ");
				int valor4 = scan.nextInt();
				for(int i= valor3; i <= valor4; i+=2) {
					System.out.println(i);
				}
				break;
			case 6:
				System.out.print("Digite outro valor inteiro par: ");
				int valor5 = scan.nextInt();
				for(int i= valor5; i <= 100; i++) {
					
					System.out.println(i);
				}
				break;
			case 7:
				for(int i= 6; i == 15; i--) {
					
					System.out.println(i);
				}
				break;
			case 8:
				for(int i= 10; i <= 200; i++) {
					System.out.println(i);
				}
				break;
			case 9:
				for(int i= 10; i <= 200; i++) {
					System.out.println(i);
				}
				break;
			case 10:
				for(int i= 11; i <= 200; i++) {
					System.out.println(i);
				}
				break; 
			case 11:
				System.out.println("Até logo.");
				break;
			default:
				System.out.println("Opção Inválida.");
				break;
			}
		}
		
	}

}