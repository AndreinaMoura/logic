package modelo;

public class Prato {

	public String placa;
	public String marca;
	public String modelo;
	public int anoModelo;
	public int anoFabricacao;
	public String cor;

	public Prato() {
		
	}
	public Prato(String placa, String marca, String modelo, int anoModelo, int anoFabricacao, String cor) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoModelo = anoModelo;
		this.anoFabricacao = anoFabricacao;
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "Veiculo [placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", anoModelo=" + anoModelo
				+ ", anoFabricacao=" + anoFabricacao + ", cor=" + cor + "]";
	}
	public String paraString() {

		return placa + "\t" + marca + "\t" + modelo + "\t" + anoModelo + "\t" + anoFabricacao + "\t" + cor + "\n";
	}

}