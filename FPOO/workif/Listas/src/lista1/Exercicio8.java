package lista1;

import java.util.Scanner;

public class Exercicio8 {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		/* 8 � Fa�a um programa que leia dois valores, divida o primeiro 
		 * valor digitado pelo segundo valor digitado e informe para o usu�rio 
		 * qual ser� o valor de resto dessa divis�o.*/
		int v1,v2,rest,result;
		System.out.print("Digite o 1 valor: ");
		v1 = entrada.nextFloat();
		System.out.print("Digite o 2 valor: ");
		v2 = entrada.nextFloat();
		rest=v1%v2;
		System.out.println("O resto da divis�o � de "+rest);


	}

}
