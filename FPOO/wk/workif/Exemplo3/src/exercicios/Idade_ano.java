package exercicios;

import java.time.Year;
import java.util.Scanner;

public class Idade_ano {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int id,ano;
		int anoAtual=Year.now().getValue();
		System.out.println("Digite seu ano de nascimento: ");
		ano = entrada.nextInt();
		id = anoAtual-ano;
		System.out.println("Sua idade � de "+id);
		if(id >= 18) {
			System.out.println("Voc� � maior de idade");
		}else {
			System.out.println("Voc� � menor de idade");
		}


	}

}
