package controle;

import java.util.ArrayList;

import modelo.Pet;

public class PetProcessa {
	public static ArrayList<Pet> pets = new ArrayList<>();
	private static PetDAO ud = new PetDAO();

	public static void carregar() {
		pets = ud.abrir();
	}

//	public static int checarEmail(String email) {
//		int retorno = -1;
//		for (int i = 0; i < pets.size(); i++) {
//			if (pets.get(i).getEmail().equals(email)) {
//				retorno = i;
//			}
//		}
//		return retorno;
//	}
//
//	public static boolean checarSenha(int indice, String senha) {
//		return pets.get(indice).getSenha().equals(senha);
//	}
}
