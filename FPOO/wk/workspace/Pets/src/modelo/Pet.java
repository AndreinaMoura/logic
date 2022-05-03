package modelo;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Pet {
	private int id;
	private String especie;
	private String raca;
	private String nomePet;
	private float peso;
	private Date nascimento;
	private String nomeDono;
	private String telefone;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Pet(int id, String especie, String raca, String nomePet, float peso, String nascimento, String nomeDono,
			String telefone) throws ParseException {
		this.id = id;
		this.especie = especie;
		this.raca = raca;
		this.nomePet = nomePet;
		this.peso = peso;
		this.nascimento = sdf.parse(nascimento);
		this.nomeDono = nomeDono;
		this.telefone = telefone;
	}
	
	@SuppressWarnings("deprecation")
	public int obterIdade() {
		return new Date().getYear() - nascimento.getYear();
	}

	public String toString() {
		return id + " " + especie + "\t" + raca + "      " + nomePet + "      " + String.format("%.2f", peso) + "\t"
				+ obterIdade() + "\t" + nomeDono + "\t" + telefone + "\n";
	}
}
