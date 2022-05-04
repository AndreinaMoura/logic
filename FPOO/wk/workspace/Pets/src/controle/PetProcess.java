package controle;

import java.util.ArrayList;

import modelo.Pet;

public class PetProcess {

	public static ArrayList<Pet> pets = new ArrayList<>();
	private static PetDAO pd = new PetDAO();

	public static void abrir() {
		pets.pd.ler();
	}

	public static void salvar() {
		pets.pd.escrever();
	}

	public static void carregarTestes() {
		pets = new ArrayList<>();
		pets.add(new Pet(1, "Cachorro", "Vira Lata", "Toto", 26, "10/10/2015", "Joaquim", "(19) 98765-4321"));
		pets.add(new Pet(2, "Gato", "sla", "Gatito", 3, "10/10/2021", "man", "(19) 94002-8922"));
		pets.add(new Pet(3, "Pássaro", "Cacatua", "Pato", 0.2f, "10/10/2020", "João", "(19) 08007-7700"));
		pets.add(new Pet(4, "Coelho", "sla", "Batatinha", 0.2f, "10/10/2021", "Renata", "(19) 08007-7700"));
	}
}
