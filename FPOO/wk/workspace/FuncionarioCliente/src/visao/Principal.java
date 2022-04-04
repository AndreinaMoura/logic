package visao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Funcionario;
import modelo.Cliente;
import modelo.Venda;

public class Principal {
	private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
	private static ArrayList<Cliente> clientes = new ArrayList<>();
	private static ArrayList<Venda> vendas = new ArrayList<>();
	private static Scanner scan = new Scanner(System.in);
	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) throws IOException, ParseException {

		int menu = 0;
		while (menu != 7) {
			System.out.print(
					"*Cadastrar Cliente    *Cadastrar Funcionário    *Cadastrar Vendas    *Listar Clientes    *Listar Funcionários    *Listar Clientes     *Sair\n-Escolha: ");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				cadastrarCliente();
				break;
			case 2:
				cadastrarFuncionario();
				break;
			case 3:
				cadastrarVendas();
				break;
			case 4:
				listarClientes();
				break;
			case 5:
				listarFuncionarios();
				break;
			case 6:
				listarVendas();
				break;
			case 7:
				System.out.println("Adeus");
				break;
			default:
				System.out.println("Opção Inválida");
				break;
			}
		}
	}

	private static void cadastrarCliente() throws ParseException {
		System.out.println("\n------------------Cadastrar Cliente--------------------\n");
		System.out.println("Nome    Telefone    Nascimento     id    Credito Limite");
		Cliente cl = new Cliente(scan.next(), scan.next(), df.parse(scan.next()), scan.nextInt(), scan.nextDouble());
		clientes.add(cl);
	}

	private static void cadastrarFuncionario() throws ParseException {
		System.out.println("\n----------------Cadastrar Funcionário------------------\n");
		System.out.println("Nome    Telefone    Nascimento    Matricula    Comissão");
		Funcionario fn = new Funcionario(scan.next(), scan.next(), df.parse(scan.next()), scan.nextInt(),
				scan.nextDouble());
		funcionarios.add(fn);
	}

	private static void cadastrarVendas() {

	}

	private static void listarClientes() {
		System.out.println("\nNome    Telefone    Nascimento     id    Credito Limite");
		for (Cliente cl : clientes) {
			System.out.println(cl.toString());
		}
	}

	private static void listarFuncionarios() {
		System.out.println("\nNome    Telefone    Nascimento    Matricula    Comissão");
		for (Funcionario fn : funcionarios) {
			System.out.println(fn.toString());
		}
	}

	private static void listarVendas() {

	}
}