package lista1;

import java.util.Scanner;

public class Exercicio7 {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		/* 7 � Um laborat�rio de F�sica est� estudando barras de calc�rio para 
		 * Constru��o Civil, e precisa saber a densidade de cada barra. Fa�a um 
		 * programa para ajud�-los. (Dado: densidade = massa / volume)*/
		float densidade,massa,volume;
		System.out.print("Digite a massa: ");
		massa = entrada.nextFloat();
		System.out.print("Digite o volume: ");
		volume = entrada.nextFloat();
		densidade=massa/volume;
		System.out.println("A densidade � de "+densidade);

	}

}
