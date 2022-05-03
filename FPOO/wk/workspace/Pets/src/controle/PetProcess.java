package controle;

import java.text.ParseException;
import java.util.ArrayList;

import modelo.Pet;

public class PetProcess {
	
	public static ArrayList<Pet> pets = new ArrayList<>();

	public static void carregarTestes() throws ParseException {
		pets = new ArrayList<>();
		pets.add(new Pet(1, "Cachorro", "Vira Latas", "Toto", 26, "10/10/2015","Joaquim", "(19) 98765-4321"));
		pets.add(new Pet(2, "Gato", "marrom", "Gatito", 3, "10/10/2021","man", "(19) 94002-8922"));
		pets.add(new Pet(3, "Passáro", "Cacatua", "Pato", 0.2f, "10/10/2020","João", "(19) 08007-7700"));
	}
}
