package controle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import modelo.Pet;

public class PetDAO {
	private BufferedReader br;
	private String path = "C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\wk\\workspace\\FormulrarioDePet\\dadinhos\\pets.csv";

	public ArrayList<Pet> abrir() throws ParseException {
		ArrayList<Pet> lista = new ArrayList<>();
		Pet pet;
		try {
			br = new BufferedReader(new FileReader(path));
			String linha = br.readLine();
			while (linha != null) {
				pet = new Pet(0, linha, linha, linha, 0, linha, linha, linha);
				lista.add(pet);
				linha = br.readLine();
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		return lista;
	}
}
