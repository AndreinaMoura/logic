package controllers;

import java.util.ArrayList;

import models.Manutencao;
import models.dao.ManutencaoDAO;

public class ProcessaManutencoes {
	public static ArrayList<Manutencao> manutencoes = new ArrayList<>();
	private static ManutencaoDAO md = new ManutencaoDAO();

	public static void salvar() {
		manutencoes=md.ler();
	}

	public static void abrir() {
		md.escrever(manutencoes);
	}
	public static void carregarTestes() {
		manutencoes = new ArrayList<>();
		manutencoes.add(new Manutencao(1, "12/12/2012", "motor", 100, 2));
		manutencoes.add(new Manutencao(2, "12/12/2012", "motor", 100, 2));
		manutencoes.add(new Manutencao(3, "12/12/2012", "motor", 100, 2));
		manutencoes.add(new Manutencao(4, "12/12/2012", "motor", 100, 2));
	}
}
