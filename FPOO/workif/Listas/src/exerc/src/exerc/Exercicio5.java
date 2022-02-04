package exerc;
import java.util.Scanner;
import java.io.IOException;
public class Exercicio5 {
	/* 5 � Um caminh�o consegue transportar 18 toneladas de laranjas em uma 
	 * viagem que faz entre a fazenda e a f�brica de suco de laranja. Um alqueire 
	 * de terra produz em m�dia 250 toneladas de laranjas. Fa�a um programa que leia 
	 * quantos caminh�es e quantos alqueires uma fazenda pro-dutora de laranjas possui, 
	 * calcule e apresente na tela quantas viagens de caminh�o ser�o neces-s�rias para 
	 * transportar toda a colheita de laranjas.*/
	public static void main(String[] args) throws IOException {
		Scanner entrada=new Scanner(System.in);
		
		double caminhao,alqueire,viagens;
		System.out.println("Quantidade de caminh�es: ");
		caminhao=entrada.nextInt();
		caminhao=caminhao*18;
		System.out.println("Quantidade de alqueire: ");
		alqueire=entrada.nextInt();
		alqueire=alqueire*250;
		
		viagens=(int)Math.ceil(alqueire/caminhao);
		System.out.println("Devem ser feitas "+ viagens +" viagens");


	}

}
