package visao;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;

import controle.PetProcess;
import modelo.Pet;

public class PetForm extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Scanner scan = new Scanner(System.in);

	// atributos da tela
	private JPanel painel;
	private JLabel rotulo1, rotulo2, rotulo3, rotulo4, rotulo5, rotulo6, rotulo7, rotulo8, rotulo9, imagem;
	private JComboBox<String> especie;
	private JTextField id, raca, nomePet, peso, nascimento, nomeDono, telefone;
	private JButton cadastrar, buscar, alterar, excluir;
	private JTextArea area;
	private ImageIcon icon;
	private String[] imagens = {
			"C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\wk\\workspace\\Pets\\dadinhos\\img.jpg",
			"C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\wk\\workspace\\Pets\\dadinhos\\img.jpg",
			"C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\wk\\workspace\\Pets\\dadinhos\\doguinho.png",
			"C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\wk\\workspace\\Pets\\dadinhos\\coelho.png",
			"C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\wk\\workspace\\Pets\\dadinhos\\passáro.jpg" };
	private int autoId = PetProcess.pets.size() + 1;
	private String texto = "";
	private final Locale BRASIL = new Locale("pt", "BR");
	private DecimalFormat df = new DecimalFormat("#.00");

	public PetForm() {

		// Propriedades Básicas
		setTitle("Formulário de Pets");
		setBounds(600, 300, 650, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		painel = new JPanel();
		setContentPane(painel);
		painel.setBackground(new Color(204, 204, 255));

		setLayout(null);

		// Conteúdos da tela
		rotulo1 = new JLabel("ID:");

		rotulo1.setBounds(40, 40, 100, 20);

		id = new JTextField(String.format("%d", autoId));
		id.setEnabled(false);
		id.setBounds(140, 40, 200, 30);

		rotulo2 = new JLabel("Espécie:");
		rotulo2.setBounds(40, 80, 100, 20);

		especie = new JComboBox<String>(new String[] { " ", "Gato", "Cachorro", "Coelho", "Pássaro" });
		especie.setBounds(140, 80, 200, 30);
		especie.addActionListener(this);

		rotulo3 = new JLabel("Raça:");
		rotulo3.setBounds(40, 120, 100, 20);

		raca = new JTextField();
		raca.setBounds(140, 120, 200, 30);

		rotulo4 = new JLabel("Nome do Pet:");
		rotulo4.setBounds(40, 160, 100, 20);

		nomePet = new JTextField();
		nomePet.setBounds(140, 160, 200, 30);

		rotulo5 = new JLabel("Peso:");
		rotulo5.setBounds(40, 200, 100, 20);

		peso = new JTextField();
		peso.setBounds(140, 200, 200, 30);

		rotulo6 = new JLabel("Nascimento:");
		rotulo6.setBounds(40, 240, 100, 20);

		nascimento = new JTextField();
		nascimento.setBounds(140, 240, 200, 30);

		rotulo7 = new JLabel("Nome do Dono:");
		rotulo7.setBounds(40, 280, 100, 20);

		nomeDono = new JTextField();
		nomeDono.setBounds(140, 280, 200, 30);

		rotulo8 = new JLabel("Telefone:");
		rotulo8.setBounds(40, 320, 100, 20);

		telefone = new JTextField();
		telefone.setBounds(140, 320, 200, 30);

		area = new JTextArea();
		area.setBounds(40, 400, 560, 150);
		area.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		area.setEnabled(false);
		preencherArea();

		imagem = new JLabel();
		imagem.setBounds(400, 200, 200, 150);
		imagem.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		mostrarImagem(0);

		rotulo9 = new JLabel(String.format(
				"Id   Espécie       Raça                     Pet              Peso            Idade              Dono             Telefone"));
		rotulo9.setBounds(40, 300, 500, 150);

		cadastrar = new JButton("Cadastrar");
		cadastrar.setBounds(400, 40, 200, 30);
		cadastrar.addActionListener(this);

		buscar = new JButton("Buscar");
		buscar.setBounds(400, 80, 200, 30);
		buscar.addActionListener(this);

		alterar = new JButton("Alterar");
		alterar.setBounds(400, 120, 200, 30);
		alterar.addActionListener(this);
		alterar.setEnabled(false);

		excluir = new JButton("Excluir");
		excluir.setBounds(400, 160, 200, 30);
		excluir.addActionListener(this);
		excluir.setEnabled(false);

		painel.add(id);
		painel.add(especie);
		painel.add(raca);
		painel.add(nomePet);
		painel.add(peso);
		painel.add(nascimento);
		painel.add(nomeDono);
		painel.add(telefone);

		painel.add(rotulo1);
		painel.add(rotulo2);
		painel.add(rotulo3);
		painel.add(rotulo4);
		painel.add(rotulo5);
		painel.add(rotulo6);
		painel.add(rotulo7);
		painel.add(rotulo8);
		painel.add(rotulo9);

		painel.add(imagem);
		painel.add(area);
		painel.add(cadastrar);
		painel.add(buscar);
		painel.add(alterar);
		painel.add(excluir);
	}

	private void mostrarImagem(int indice) {
		icon = new ImageIcon(new ImageIcon(imagens[indice]).getImage().getScaledInstance(200, 150, 200));
		imagem.setIcon(icon);
	}

	private void cadastrar() {
		if (nomePet.getText().length() != 0 && raca.getText().length() != 0 && peso.getText().length() != 0
				&& nascimento.getText().length() != 0 && nomeDono.getText().length() != 0
				&& telefone.getText().length() != 0) {

			df.setCurrency(Currency.getInstance(BRASIL));
			float p;
			try {
				p = Float.parseFloat(df.parse(peso.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				p = 0;
			}
			PetProcess.pets.add(new Pet(autoId, especie.getSelectedItem().toString(), nomePet.getText(), raca.getText(),
					p, nascimento.getText(), nomeDono.getText(), telefone.getText()));
			autoId++;
			preencherArea();
			limparCampos();
			JOptionPane.showMessageDialog(this, "Cadastrado com sucesso");
			alterar.setEnabled(true);
			excluir.setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}

	}

	private void limparCampos() {
		nomePet.setText(null);
		raca.setText(null);
		peso.setText(null);
		nascimento.setText(null);
		nomeDono.setText(null);
		telefone.setText(null);
	}

	int ObterIndiceEspecie(String especie) {
		switch (especie) {
		case "":
			return 0;
		case "gato":
			return 1;
		case "cachorro":
			return 2;
		case "coelho":
			return 3;
		case "pássaro":
			return 4;
		default:
			return -1;
		}
	}

	private void preencherArea() {
		texto = "";
		for (Pet p : PetProcess.pets) {
			texto += p.toString();
		}
		area.setText(texto);
	}

	public void buscar() {
		String entrada = JOptionPane.showInputDialog(this, "Digite o Id do animal:");

		boolean isNumeric = true;
		if (entrada != null) {
			for (int i = 0; i < entrada.length(); i++) {
				if (!Character.isDigit(entrada.charAt(i))) {
					isNumeric = false;
				}
			}
		} else {
			isNumeric = false;
		}
		if (isNumeric) {
			int ID = Integer.parseInt(entrada);
			Pet pet = new Pet(ID);
			if (PetProcess.pets.contains(pet)) {
				int indice = PetProcess.pets.indexOf(pet);
				id.setText(PetProcess.pets.get(indice).getId("s"));
				nomePet.setText(PetProcess.pets.get(indice).getNomePet());
				especie.setSelectedIndex(ObterIndiceEspecie(PetProcess.pets.get(indice).getEspecie()));
				raca.setText(PetProcess.pets.get(indice).getRaca());
				peso.setText(PetProcess.pets.get(indice).getPeso("s"));
				nascimento.setText(PetProcess.pets.get(indice).getNascimento("s"));
				nomeDono.setText(PetProcess.pets.get(indice).getNomeDono());
				telefone.setText(PetProcess.pets.get(indice).getTelefone());
				cadastrar.setEnabled(false);
				alterar.setEnabled(true);
				excluir.setEnabled(true);
				PetProcess.salvar();
			} else {
				JOptionPane.showMessageDialog(this, "Pet não encontrado");
			}
		}
	}

	private void alterar() {
		int ID = Integer.parseInt(id.getText());
		Pet pet = new Pet(ID);
		int indice = PetProcess.pets.indexOf(pet);
		if (nomePet.getText().length() != 0 && raca.getText().length() != 0 && peso.getText().length() != 0
				&& nascimento.getText().length() != 0 && nomeDono.getText().length() != 0
				&& telefone.getText().length() != 0) {

			// Converter o peso no formato Brasileiro usando virgula como decimal
			df.setCurrency(Currency.getInstance(BRASIL));
			float p;
			try {
				p = Float.parseFloat(df.parse(peso.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				p = 0;
			}
			PetProcess.pets.set(indice, new Pet(autoId, especie.getSelectedItem().toString(), nomePet.getText(),
					raca.getText(), p, nascimento.getText(), nomeDono.getText(), telefone.getText()));
			preencherArea();
			limparCampos();
		} else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}
		cadastrar.setEnabled(true);
		alterar.setEnabled(false);
		excluir.setEnabled(false);
		id.setText(String.format("%d", autoId));
		PetProcess.salvar();
	}

	private void excluir() {
		int ID = Integer.parseInt(id.getText());
		Pet pet = new Pet(ID);
		int indice = PetProcess.pets.indexOf(pet);
		PetProcess.pets.remove(indice);
		preencherArea();
		limparCampos();
		JOptionPane.showMessageDialog(this, "Excluído com sucesso");
		cadastrar.setEnabled(true);
		alterar.setEnabled(false);
		excluir.setEnabled(false);
		id.setText(String.format("%d", autoId));
		PetProcess.salvar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cadastrar) {
			cadastrar();

		}
		if (e.getSource() == buscar) {
			buscar();
		}
		if (e.getSource() == alterar) {
			alterar();

		}
		if (e.getSource() == excluir) {
			excluir();

		}
		if (e.getSource() == especie) {
			mostrarImagem(especie.getSelectedIndex());
		}
	}

	public static void main(String[] args) {
//		PetProcess.carregarTestes();
		PetProcess.abrir();
		new PetForm().setVisible(true);
	}
}