package controle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import modelo.Produto;

public class ProdutoDAO {

	private BufferedReader br;
	private BufferedWriter bw;
	private String entrada = "C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\wk\\Projeto\\dados\\entrada.csv";
	private String saida = "C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\wk\\Projeto\\dados\\projeto.csv";
	
	public ArrayList<Produto> ler() {
		ArrayList<Produto> linhas = new ArrayList<>();
		Produto prod;
		try {
			br = new BufferedReader(new FileReader(entrada));
			String linha = br.readLine();
			while(linha != null) {
				prod = new Produto(linha);
				linhas.add(prod);
				linha = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return linhas;
	}
	
	public void escrever(ArrayList<Produto> linhas) {
		try {
			bw = new BufferedWriter(new FileWriter(saida));
			for (Produto p : linhas) {
				bw.write(p.toCSV());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}