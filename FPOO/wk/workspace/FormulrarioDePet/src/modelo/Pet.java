package modelo;

public class Pet {
	public String id;
	public String especie;
	public String raca;
	public String nome;
	public String peso;
	public String nascimento;
	public String dono;
	public String telefone;
	
	public Pet(String id, String especie, String raca, String nome, String peso, String nascimento, String dono, String telefone) {
		this.id = id;
		this.especie = especie;
		this.raca = raca;
		this.nome = nome;
		this.peso = peso;
		this.nascimento = nascimento;
		this.dono = dono;
		this.telefone = telefone;
	}
	
	public Pet(String linha) {
		this.id = linha.split(";")[0];
		this.especie = linha.split(";")[1];
		this.raca = linha.split(";")[2];
		this.nome = linha.split(";")[3];
		this.peso = linha.split(";")[4];
		this.nascimento = linha.split(";")[5];
		this.dono = linha.split(";")[6];
		this.telefone = linha.split(";")[7];
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "id=" + id + ", especie=" + especie + ", raca=" + raca + ", nome=" + nome + ", peso=" + peso
				+ ", nascimento=" + nascimento + ", dono=" + dono + ", telefone=" + telefone;
	}
}
