package modelo;

public class Venda {
	
	private int codCliente;
	private int codFuncinario;
	private double valor;
	
	
	
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int id) {
		this.codCliente = id;
	}
	public int getCodFuncinario() {
		return codFuncinario;
	}
	public void setCodFuncinario(int matricula) {
		this.codFuncinario = matricula;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return super.toString() + "codCliente=" + codCliente + ", codFuncinario=" + codFuncinario + ", valor=" + valor
				+ ", getCodCliente()=" + getCodCliente() + ", getCodFuncinario()=" + getCodFuncinario()
				+ ", getValor()=" + getValor();
	}

	
	
}
