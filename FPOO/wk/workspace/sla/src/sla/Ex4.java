package sla;
//4 - Ler um vetor com 10 nomes de pessoas, ap�s pedir que o usu�rio digite um nome qualquer de pessoa. Escrever a mensagem �ACHEI�, se o nome estiver armazenado 
//no vetor C ou �N�O ACHEI� caso contr�rio.

import java.util.Scanner;

public class Ex4 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
	String[] nomes = new String[10];
	int c=0;
	System.out.println("Digite um nome qualquer de pessoa: ");
		for(int i=0;i<nomes.length;i++) {
			nomes[i]=scan.next();
		}
		System.out.println("Pesquise por um nome: ");
		String n=scan.next();
		for(int i=0;i<nomes.length;i++) {
			if(nomes[i].equalsIgnoreCase(n)) {
				c++;
			}
		}
		if(c==0) {
			System.out.println("N�O ACHEI");
		}else {
			System.out.println("ACHEI");
			System.out.println("Quantidade de vezes que apareceu o nome: "+c+" vez(es)");
		}
	}
}
