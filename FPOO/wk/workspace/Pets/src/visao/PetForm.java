package visao;

import java.awt.event.ActionListener;
import java.text.ParseException;
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
//	private String imgIco = ;
	private String[] imagens = {
			"C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\wk\\workspace\\Pets\\dadinhos\\img.jpg",
			"C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\wk\\workspace\\Pets\\dadinhos\\img.jpg",
			"C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\wk\\workspace\\Pets\\dadinhos\\doguinho.png",
			"C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\wk\\workspace\\Pets\\dadinhos\\coelho.png",
			"C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\wk\\workspace\\Pets\\dadinhos\\pass�ro.jpg" };
	private int autoId = 1;
	private String texto = "";

	public PetForm() {

		// Propriedades B�sicas
		setTitle("Formul�rio de Pets");
		setBounds(600, 300, 650, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		painel = new JPanel();
		setContentPane(painel);
		painel.setBackground(new Color(204, 204, 255));

		setLayout(null);

		// Conte�dos da tela
		rotulo1 = new JLabel("ID:");

		rotulo1.setBounds(40, 40, 100, 20);

		id = new JTextField(String.format("%d", autoId));
		id.setEnabled(false);
		id.setBounds(140, 40, 200, 30);

		rotulo2 = new JLabel("Esp�cie:");
		rotulo2.setBounds(40, 80, 100, 20);

		especie = new JComboBox<String>(new String[] { " ", "Gato", "Cachorro", "Coelho", "Pass�ro" });
		especie.setBounds(140, 80, 200, 30);
		especie.addActionListener(this);

		rotulo3 = new JLabel("Ra�a:");
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

		rotulo9 = new JLabel(String.format("Id:  Esp�cie:         Ra�a:      Nome do Pet:      Peso:   Idade:        Nome do Dono      Telefone:        "));
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cadastrar) {
			JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!");
			alterar.setEnabled(true);
			excluir.setEnabled(true);
		}
		if (e.getSource() == buscar) {
			JOptionPane.showMessageDialog(this, "O que deseja buscar?");
			String mensagem = "";

			int indice = 0 ;
			if (indice != -1) {
//			= PetProcess.checarNome(nomePet.getText())
//			JOptionPane.showInputDialog(this, mensagem);
//			mensagem = scan.next();
//			if(mensagem.toLowerCase().equals(nomePet.toLowerCase()));
				JOptionPane.showMessageDialog(this, "Pet encontrado");
				this.dispose();// Fecha o Formul�rio

			} else {
				JOptionPane.showMessageDialog(this, "Pet n�o encontrado");
			}
			alterar.setEnabled(true);
			excluir.setEnabled(true);
		}
		if (e.getSource() == alterar) {
			JOptionPane.showMessageDialog(this, "Alterado com sucesso");
		}
		if (e.getSource() == excluir) {
			JOptionPane.showMessageDialog(this, "Exclu�do com sucesso");
			excluir.setEnabled(false);
			alterar.setEnabled(false);
		}
		if (e.getSource() == especie) {
			mostrarImagem(especie.getSelectedIndex());
		}
	}

	private void mostrarImagem(int indice) {
		icon = new ImageIcon(new ImageIcon(imagens[indice]).getImage().getScaledInstance(200, 150, 200));
		imagem.setIcon(icon);
	}

	private void cadastrar() {
		if(nomePet.getText().length() != 0 && raca.getText().length() != 0 && peso.getText().length() != 0 && nascimento.getText().length() != 0 && nomeDono.getText().length() != 0 && telefone.getText().length() != 0) {
			
		}else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}
	}
	private void preencherArea() {
		for (Pet p : PetProcess.pets) {
			texto+=p.toString();
		}
		area.setText(texto);
	}
	
	public static void main(String[] args) throws ParseException {
		PetProcess.carregarTestes();
		new PetForm().setVisible(true);
	}
}
