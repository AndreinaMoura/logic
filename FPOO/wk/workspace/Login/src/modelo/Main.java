package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	// Espa�o de mem�ria din�mico para leitura(Abrir)
	static BufferedReader br;
	// Espa�o de mem�ria din�mico para escrita(Salvar)
	static BufferedWriter bw;
	// Endere�p do aquivo de entrada
	static String usuarios = "C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\wk\\workspace\\Login\\dados\\usuarios.csv";
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao = 0;

		Scanner scan = new Scanner(System.in);
		System.out.println("Insira o usu�rio: ");
		String b1 = scan.next();
		System.out.println("Insira a senha: ");
		String b2 = scan.next();
		
		// Abrir o arquivo tratando os poss�veis erros
		try {
			// Abre o arquivo
			br = new BufferedReader(new FileReader(usuarios));
			String linha = br.readLine();// L� a primeira linha
			while (linha != null) {
				String[0] v1 = usuarios.split(";");
				String[1] v2 = usuarios.split(";");
				
				
				if ((v1[0].toLowerCase().contains(b1.toLowerCase()))
						&& (v2[1].toLowerCase().contains(b2.toLowerCase()))) {
					System.out.println("Acesso permitido");
				}
				linha = br.readLine();// L� a pr�xima linha
			}
			// Fecha o arquivo
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}