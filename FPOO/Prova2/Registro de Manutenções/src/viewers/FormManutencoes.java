package viewers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.ProcessaManutencoes;
import models.Manutencao;

public class FormManutencoes extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField id, data, equipamento, custo, tempo, total;
	private JLabel JLid, JLdata, JLequipamento, JLcusto, JLtempo, JLrotulos, JLtotal;
	private JButton cadastrar, alterar, excluir, buscar;
	private JTextArea listar;
	private String texto;
	private JScrollPane rolagem;

	private int autoId = ProcessaManutencoes.manutencoes.size() + 1;

	private final Locale BRASIL = new Locale("pt", "BR");
	private DecimalFormat df = new DecimalFormat("#.00");

	FormManutencoes() {
		setTitle("Registro de Manutenções");
		setBounds(100, 100, 800, 600);
		panel = new JPanel();
		panel.setBackground(new Color(255, 233, 213));
		setContentPane(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		JLid = new JLabel("Id:");
		JLid.setBounds(20, 20, 120, 30);
		panel.add(JLid);
		id = new JTextField(String.format("%d", autoId));
		id.setEditable(false);
		id.setBounds(140, 25, 140, 30);
		panel.add(id);

		JLdata = new JLabel("Data:");
		JLdata.setBounds(20, 55, 120, 30);
		panel.add(JLdata);
		data = new JTextField();
		data.setBounds(140, 60, 255, 30);
		panel.add(data);

		JLequipamento = new JLabel("Equipamento:");
		JLequipamento.setBounds(20, 90, 120, 30);
		panel.add(JLequipamento);
		equipamento = new JTextField();
		equipamento.setBounds(140, 95, 255, 30);
		panel.add(equipamento);

		JLcusto = new JLabel("Custo:");
		JLcusto.setBounds(20, 125, 120, 30);
		panel.add(JLcusto);
		custo = new JTextField();
		custo.setBounds(140, 130, 255, 30);
		panel.add(custo);

		JLtempo = new JLabel("Tempo:");
		JLtempo.setBounds(20, 165, 120, 30);
		panel.add(JLtempo);
		tempo = new JTextField();
		tempo.setBounds(140, 170, 255, 30);
		panel.add(tempo);
		
		JLtotal = new JLabel("Total:");
		JLtotal.setBounds(20, 205, 120, 30);
		panel.add(JLtotal);
		total = new JTextField();
		total.setBounds(140, 210, 255, 30);
		panel.add(total);
		total.setEditable(false);

		JLrotulos = new JLabel("    Id   |       Data      |     Equipamento    |     Custo    |    Tempo    |     Total:");
		JLrotulos.setBounds(20, 310, 500, 30);
		panel.add(JLrotulos);

		listar = new JTextArea();
		listar.setEditable(false);
		listar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		preencherAreaDeTexto();

		rolagem = new JScrollPane(listar);
		rolagem.setBounds(20, 340, 740, 200);
		panel.add(rolagem);

		cadastrar = new JButton("Cadastrar");
		cadastrar.setBounds(500, 20, 110, 30);
		panel.add(cadastrar);

		buscar = new JButton("Buscar");
		buscar.setBounds(500, 55, 110, 30);
		panel.add(buscar);

		alterar = new JButton("Atualizar");
		alterar.setBounds(500, 90, 110, 30);
		alterar.setEnabled(false);
		panel.add(alterar);

		excluir = new JButton("Excluir");
		excluir.setBounds(500, 125, 110, 30);
		excluir.setEnabled(false);
		panel.add(excluir);

		// Ouvir os eventos dos Botões, ComboBox e outros
		cadastrar.addActionListener(this);
		buscar.addActionListener(this);
		alterar.addActionListener(this);
		excluir.addActionListener(this);

	}

	// CREATE - CRUD
	private void cadastrar() {
		if (id.getText().length() != 0 && data.getText().length() != 0 && equipamento.getText().length() != 0
				&& custo.getText().length() != 0 && tempo.getText().length() != 0) {

			// Converter o peso no formato Brasileiro usando virgula como decimal
			df.setCurrency(Currency.getInstance(BRASIL));
			double c, t;
			try {
				c = Double.parseDouble(df.parse(custo.getText()).toString());
				t = Double.parseDouble(df.parse(tempo.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				c = 0;
				t = 0;
			}

			ProcessaManutencoes.manutencoes
					.add(new Manutencao(autoId, data.getText(), equipamento.getText(), c, t));
			autoId++;
			preencherAreaDeTexto();
			limparCampos();
		} else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}
	}

	private void limparCampos() {
		id.setText(null);
		data.setText(null);
		equipamento.setText(null);
		custo.setText(null);
		tempo.setText(null);
		total.setText(null);
	}

	private void preencherAreaDeTexto() {
		texto = ""; // Limpar a área de texto antes de preenher
		for (Manutencao m : ProcessaManutencoes.manutencoes) {
			texto += m.toString();
		}
		listar.setText(texto);
	}

	// READ - CRUD
	private void buscar() {
		String entrada = JOptionPane.showInputDialog(this, "Digite o Id do equipamento:");

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

			int Id = Integer.parseInt(entrada);
			Manutencao man = new Manutencao(Id);

			if (ProcessaManutencoes.manutencoes.contains(man)) {
				int indice = ProcessaManutencoes.manutencoes.indexOf(man);
				id.setText(ProcessaManutencoes.manutencoes.get(indice).getId("s"));
				data.setText(ProcessaManutencoes.manutencoes.get(indice).getData("s"));
				equipamento.setText(ProcessaManutencoes.manutencoes.get(indice).getEquipamento());
				custo.setText(ProcessaManutencoes.manutencoes.get(indice).getCusto("s"));
				tempo.setText(ProcessaManutencoes.manutencoes.get(indice).getTempo("s"));
				total.setText(ProcessaManutencoes.manutencoes.get(indice).getTotal("s"));
				cadastrar.setEnabled(false);
				alterar.setEnabled(true);
				excluir.setEnabled(true);
				ProcessaManutencoes.salvar();
			} else {
				JOptionPane.showMessageDialog(this, "Pet não encontrado");
			}
		}

	}

	// UPDATE - CRUD
	private void alterar() {
		int Id = Integer.parseInt(id.getText());
		Manutencao man = new Manutencao(Id);
		int indice = ProcessaManutencoes.manutencoes.indexOf(man);
		if (id.getText().length() != 0 && data.getText().length() != 0 && equipamento.getText().length() != 0
				&& custo.getText().length() != 0 && tempo.getText().length() != 0) {

			// Converter o peso no formato Brasileiro usando virgula como decimal
			df.setCurrency(Currency.getInstance(BRASIL));
			double c, t;
			try {
				c = Double.parseDouble(df.parse(custo.getText()).toString());
				t = Double.parseDouble(df.parse(tempo.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				c = 0;
				t = 0;
			}
			ProcessaManutencoes.manutencoes.set(indice,
					new Manutencao(autoId, data.getText(), equipamento.getText(), c,
							t));
			preencherAreaDeTexto();
			limparCampos();
		} else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}
		cadastrar.setEnabled(true);
		alterar.setEnabled(false);
		excluir.setEnabled(false);
		id.setText(String.format("%d", autoId));
		ProcessaManutencoes.salvar();
	}

	// DELETE - CRUD
	private void excluir() {
		int Id = Integer.parseInt(id.getText());
		Manutencao man = new Manutencao(Id);
		int indice = ProcessaManutencoes.manutencoes.indexOf(man);
		ProcessaManutencoes.manutencoes.remove(indice);
		preencherAreaDeTexto();
		limparCampos();
		cadastrar.setEnabled(true);
		alterar.setEnabled(false);
		excluir.setEnabled(false);
		id.setText(String.format("%d", autoId));
		ProcessaManutencoes.salvar();
	}

	@Override
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
	}

	public static void main(String[] args) {
		ProcessaManutencoes.carregarTestes();
		ProcessaManutencoes.abrir();
		new FormManutencoes().setVisible(true);
	}
}
