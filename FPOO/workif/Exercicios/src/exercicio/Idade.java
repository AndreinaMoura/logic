package exercicio;

import java.util.Scanner;

public class Idade {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int id;
		System.out.println("Digite sua idade: ");
		id = entrada.nextInt();
		if(id>=18) {
			System.out.println("Voc� � maior de idade");
		}else {
			System.out.println("Voc� � menor de idade");
		}
	}

}
