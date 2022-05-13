package controle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

import modelo.Produto;

public class ProdutoDAO {

	private BufferedReader br;
	private BufferedWriter bw;
	private String valor = "./dados/valor.csv";
	private String path = "./dados/path.csv";
	
	public ArrayList<Produto> ler() {
		ArrayList<Produto> linhas = new ArrayList<>();
		Produto prod;
		try {
			br = new BufferedReader(new FileReader(path));
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
		}
		return linhas;
	}
	
	public void escrever(ArrayList<Produto> linhas) {
		try {
			bw = new BufferedWriter(new FileWriter(path));
			for (Produto p : linhas) {
				bw.write(p.toCSV());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	public void nota(ArrayList<Produto> linhas) {
		try {
			bw = new BufferedWriter(new FileWriter(valor));
			for (Produto p : linhas) {
				bw.write(p.toVal());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}