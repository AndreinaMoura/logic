package exercicios;

import java.util.Random;

public class Ex6 {
	static Random r = new Random();

	public static void main(String[] args) {
		// 6 Faça um programa para gerar automaticamente numeros entre 0 e 99 de uma
		// cartela de bingo.
		// Sabendo que cada cartela devera conter 5 linhas de 5 números, gere estes
		// dados de modo a nao ter
		// números repetidos dentro das cartelas. O programa deve exibir na tela a
		// cartela gerada

		int matriz[][] = new int[5][5];

		System.out.println("Cartela de bingo 5x5");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				matriz[i][j] = r.nextInt(100);
			}
		}
		boolean repetido = false;
		while (repetido != true) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						for (int l = 0; l < 5; l++) {
							if (matriz[i][j] == matriz[k][l]) {
								matriz[i][j] = r.nextInt(100);
							}else{
								repetido=true;
							}
						}
					}
				}
			}
		} 
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}
	}
}