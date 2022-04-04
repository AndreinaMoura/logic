package modelo;

import java.util.Date;

public class Pessoa {

	private String nome;
	private String telefone;
	private Date nascimento;

	public Pessoa(String nome, String telefone, Date nascimento) {
		this.nome = nome;
		this.telefone = telefone;
		this.nascimento = nascimento;
	}

	public String toString() {
		return "nome=" + nome + ", telefone=" + telefone + ", nascimento=" + nascimento;
	}
}
