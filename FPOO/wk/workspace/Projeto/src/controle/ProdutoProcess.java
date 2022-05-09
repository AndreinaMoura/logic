package controle;

import java.util.ArrayList;

import modelo.Produto;

public class ProdutoProcess {

	public static ArrayList<Produto> produtos = new ArrayList<>();
	private static ProdutoDAO pd = new ProdutoDAO();
	
	public static void abrir() {
		produtos = pd.ler();
	}
	
	public static void salvar() {
		pd.escrever(produtos);
	}

	public static void carregarTestes() {
		ProdutoProcess.produtos.add(new Produto(1,"Arroz",24,88,"L & M",5,"01/01/2022","01/05/2022",6.30,6.00));
		ProdutoProcess.produtos.add(new Produto(2,"Azeite",21,95,"ATTACAD�O",5,"02/01/2022","02/05/2022",73.50,70.00));
		ProdutoProcess.produtos.add(new Produto(3,"Caf�",11,87,"TENDA",5,"03/01/2022","03/05/2022",11.55,11.00));
		ProdutoProcess.produtos.add(new Produto(4,"Ch�",55,95,"ANTONELLI",5,"04/01/2022","04/05/2022",103.95,99.00));		
	}
}