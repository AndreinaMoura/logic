package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	// Espaço de memória dinâmico para leitura(Abrir)
	static BufferedReader br;
	// Espaço de memória dinâmico para escrita(Salvar)
	static BufferedWriter bw;
	// Endereçp do aquivo de entrada
	static String usuarios = "C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\wk\\workspace\\Login\\dados\\usuarios.csv";
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao = 0;

		Scanner scan = new Scanner(System.in);
		System.out.println("Insira o usuário: ");
		String b1 = scan.next();
		System.out.println("Insira a senha: ");
		String b2 = scan.next();
		
		// Abrir o arquivo tratando os possíveis erros
		try {
			// Abre o arquivo
			br = new BufferedReader(new FileReader(usuarios));
			String linha = br.readLine();// Lê a primeira linha
			while (linha != null) {
				String[0] v1 = usuarios.split(";");
				String[1] v2 = usuarios.split(";");
				
				
				if ((v1[0].toLowerCase().contains(b1.toLowerCase()))
						&& (v2[1].toLowerCase().contains(b2.toLowerCase()))) {
					System.out.println("Acesso permitido");
				}
				linha = br.readLine();// Lê a próxima linha
			}
			// Fecha o arquivo
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}