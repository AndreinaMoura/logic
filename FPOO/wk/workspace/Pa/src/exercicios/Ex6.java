package exercicios;

import java.util.Random;

public class Ex6 {
	static Random r = new Random();

	public static void main(String[] args) {
		// 6 Faça um programa para gerar automaticamente numeros entre 0 e 99 de uma
		// cartela de bingo. Sabendo que cada cartela devera conter 5 linhas de 5
		// números, gere estes dados de modo a nao ter números repetidos dentro das
		// cartelas. O programa deve exibir na tela a cartela gerada

		int matriz[][] = new int[5][5];
		int vetor[] = new int[25];

		System.out.println("Cartela de bingo 5x5");
		
		for (int i = 0; i < 25; i++) {
			vetor[i] = r.nextInt(25);
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int x = numerosAleatorios(vetor);
				matriz[i][j] = x;
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static int numerosAleatorios(int[] vetor) {
		boolean contem = true;
		int numeroAleatório = 0; 
		while (contem) {
			contem=false;
			for (int i = 0; i < 25; i++) {
					if (vetor[i] == vetor[i]) {
						contem=true;
						break;
					
					if(contem) {
						numeroAleatório = r.nextInt(25);
						return numeroAleatório;
					}
					}
				}
			}
		return numeroAleatório;
	}
}
