package visao;

import controle.ProcessaPlanilha;

public class Tela {

	public static void main(String[] args) {
		ProcessaPlanilha.carregar();
		System.out.println("M�dias calculadas com sucesso");
		ProcessaPlanilha.saida();
	}
}