package exerc;
import java.util.Scanner;
	/* 10 � Pedra mineira � um tipo de piso muito utilizado para revestir 
	 * o ch�o em volta de piscinas, dez quilos de pedra mineira custam 
	 * R$ 130,00 e revestem uma �rea de 3,7 m2. Desenvolva um programa 
	 * que leia a �rea total (m2) a ser revestida, calcule e apresente na 
	 * tela o total de quilos de pedra mineira que ser�o necess�rios para o 
	 * revestimento e o seu custo total (R$). O programa dever� apresentar os 
	 * valores monet�rios formatados com duas casas decimais.*/
public class Exercicios10 {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);

		int area,kg=130,areat;
		double valor;
		double revest=3.7;
		System.out.print("Digite o valor total da �rea(m2): ");
		areat=entrada.nextInt();
		area = (int) (areat/revest);
		valor = (double)Math.ceil(area*kg);
		System.out.println("A quantidade de revestimento � "+area);
		System.out.printf("Custo total ser� de %.2f",valor);
		
	}

}
