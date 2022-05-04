package modelo;

import java.util.Date;
import java.util.Objects;
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
			String telefone) {
		this.id = id;
		this.especie = especie;
		this.raca = raca;
		this.nomePet = nomePet;
		this.peso = peso;
		try {
			this.nascimento = sdf.parse(nascimento);
		} catch (ParseException e) {
			System.out.println(e);
		}
		this.nomeDono = nomeDono;
		this.telefone = telefone;
	}

	public Pet(String linha) {
		this.id = Integer.parseInt(linha.split(";")[0]);
		this.especie = linha.split(";")[1];
		this.raca = linha.split(";")[2];
		this.nomePet = linha.split(";")[3];
		this.peso = Float.parseFloat(linha.split(";")[4]);;
		try {
			this.nascimento = sdf.parse(linha.split(";")[5]);
		} catch (ParseException e) {
			System.out.println(e);
		}
		this.nomeDono = linha.split(";")[6];
		this.telefone = linha.split(";")[7];
	}

	public int getId() {
		return id;
	}

	public String getId(String s) {
		return String.format("%d", id);
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getNomePet() {
		return nomePet;
	}

	public void setNomePet(String nomePet) {
		this.nomePet = nomePet;
	}

	public float getPeso() {
		return peso;
	}

	public String getPeso(String s) {
		return String.format("%.2f", peso);
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public String getNascimento(String s) {
		return sdf.format(nascimento);
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getNomeDono() {
		return nomeDono;
	}

	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Pet(int id) {
		this.id = id;
	}

	@SuppressWarnings("deprecation")
	public int obterIdade() {
		return new Date().getYear() - nascimento.getYear();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return id == other.id;
	}

	public String toString() {
		return String.format("%d  %s\t%s\t%s          %.2f              %d             %s                %s \n", id,
				especie, raca, nomePet, peso, obterIdade(), nomeDono, telefone);
	}
	public String toCSV() {
		return String.format("%d;%s;%s;%s;%.2f;sdf.format(%d);%s;%s\r\n", id,especie, raca, nomePet, peso, obterIdade(), nomeDono, telefone);
	}
}
