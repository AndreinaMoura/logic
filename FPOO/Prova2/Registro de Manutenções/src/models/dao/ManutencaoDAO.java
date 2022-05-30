package models.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.Manutencao;

public class ManutencaoDAO {
	
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = "D:\\fpoo\\work3\\modelo\\src\\modelo\\Registro de Manutenções\\dados\\manutecao.csv";
	Manutencao manutencao;
	ArrayList<Manutencao> manutencoes;
	
	public ArrayList<Manutencao> ler() {
		ArrayList<Manutencao> linhas = new ArrayList<>();
		Manutencao man;
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha = br.readLine();
			while(linha != null) {
				man = new Manutencao(linha);
				linhas.add(man);
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
	public void escrever(ArrayList<Manutencao> linhas) {
		try {
			bw = new BufferedWriter(new FileWriter(arquivo));
			for (Manutencao m : linhas) {
				bw.write(m.toCSV());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(e);
		}		
	}
}
