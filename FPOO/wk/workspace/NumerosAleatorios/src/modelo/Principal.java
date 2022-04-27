package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Principal {

	static BufferedReader br;
	static BufferedWriter bw;
	static String entrada = "C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\wk\\workspace\\NumerosAleatorios\\dados\\entrada.txt";
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		String linha = "";
		char[] ordem;

		String[] vetor = linha.split(";");
		int v1 = Integer.parseInt(vetor[0]);
		int v2 = Integer.parseInt(vetor[1]);

		crescente();

		try {
			linha = br.readLine();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void crescente() {
		String a = "";

		Arrays.sort(null, Integer.parseInt(entrada.split(";")[1]), 0, null);
		while (entrada != null) {
			a += (entrada + "  ");
		}
		System.out.println(a);
	}
}
