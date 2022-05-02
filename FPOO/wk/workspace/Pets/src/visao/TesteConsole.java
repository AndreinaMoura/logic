package visao;

import java.util.Scanner;

import controle.PetProcessa;

public class TesteConsole {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		PetProcessa.carregar();
		System.out.println("Digite o email: ");
		int indice = PetProcessa.checarEmail(scan.next());
		if (indice != -1) {
			System.out.println("Digite a senha: ");
			String senha = scan.next();
			if (PetProcessa.checarSenha(indice, senha)) {
				System.out.println("Acesso permitido");
			} else {
				System.out.println("Acesso negado");
			}
		} else {
			System.out.println("Usuário não encontrado");
		}
	}
}
