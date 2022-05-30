package models;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Manutencao {
	private int id;
	private Date data;
	private String equipamento;
	private double custoHora;
	private double tempoGasto;

	private final Locale BRASIL = new Locale("pt", "BR");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private DecimalFormat df = new DecimalFormat("#.00");

	public Manutencao(int id, String data, String equipamento, double custoHora, double tempoGasto) {
		this.id = id;
		try {
			this.data = sdf.parse(data);
		} catch (ParseException e) {
			System.out.println(e);
		}
		this.equipamento = equipamento;
		this.custoHora = custoHora;
		this.tempoGasto = tempoGasto;
	}

	public Manutencao(String linha) {
		df.setCurrency(Currency.getInstance(BRASIL));

		this.id = Integer.parseInt(linha.split(";")[0]);
		try {
			this.data = sdf.parse(linha.split(";")[1]);
		} catch (ParseException e) {
			System.out.println(e);
		}
		this.equipamento = linha.split(";")[2];
		try {
			this.custoHora = Double.parseDouble(df.parse(linha.split(";")[3]).toString());
			this.tempoGasto = Double.parseDouble(df.parse(linha.split(";")[4]).toString());
		} catch (ParseException e) {
			System.out.println(e);
		}
	}

	public Manutencao(int id) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public double getCustoHora() {
		return custoHora;
	}

	public void setCustoHora(double custoHora) {
		this.custoHora = custoHora;
	}

	public double getTempoGasto() {
		return tempoGasto;
	}

	public void setTempoGasto(double tempoGasto) {
		this.tempoGasto = tempoGasto;
	}

	public String getId(String string) {
		return String.format("%d", id);
	}

	public String getData(String string) {
		return sdf.format(data);
	}

	public String getCusto(String string) {
		// TODO Auto-generated method stub
		return df.format(custoHora);
	}

	public String getTempo(String string) {
		// TODO Auto-generated method stub
		return df.format(tempoGasto);
	}

	public String getTotal(String string) {
		// TODO Auto-generated method stub
		return String.format("%.2f", getTotal());
	}

	public double getTotal() {

		return tempoGasto * custoHora;
	}

	// Define o "id" como campo Chave
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	// Define o "id" como campo Chave
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manutencao other = (Manutencao) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "     " + id + "    " + getData("s") + "    " + equipamento + "\t" + getCusto("s") + "\t" + getTempo("s")
				+ "\t" + getTotal("s") + "\n";
	}

	public String toCSV() {
		return id + ";" + getData("s") + ";" + equipamento + ";" + getCusto("s") + ";" + getTempo("s") + ";"
				+ getTotal("s") + "\n";
	}

}
