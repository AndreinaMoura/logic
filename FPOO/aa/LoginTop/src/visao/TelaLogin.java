package visao;

import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controle.UsuarioProcessa;

import java.awt.event.ActionEvent;
public class TelaLogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static Scanner scan = new Scanner(System.in);

	// atributos da tela
	private JPanel painel;
	private JLabel rotulo1, rotulo2;
	private JTextField email, senha;
	private JButton login;

	public TelaLogin() {

		// Propriedades Básicas
		setTitle("Tela de Login");
		setBounds(600, 300, 360, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		painel = new JPanel();
		setContentPane(painel);
		setLayout(null);

		// Conteúdos da tela
		rotulo1 = new JLabel("Email:");
		rotulo1.setBounds(20, 20, 100, 20);
		
		email = new JTextField();
		email.setBounds(120, 20, 200, 30);
		
		rotulo2 = new JLabel("Senha:");
		rotulo2.setBounds(20, 60, 100, 20);
		
		senha = new JTextField();
		senha.setBounds(120, 60, 200, 30);
		
		login = new JButton("Login");
		login.setBounds(120, 100, 200, 30);
		login.addActionListener(this);
		
		
		painel.add(rotulo1);
		painel.add(email);
		painel.add(rotulo2);
		painel.add(senha);
		painel.add(login);
	}

	public static void main(String[] args) {
		UsuarioProcessa.carregar();
		TelaLogin tela = new TelaLogin();
		tela.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login) {
			JOptionPane.showMessageDialog(this, "Oi, você clicou em Login");
			System.out.println("Digite o email: ");
			int indice = UsuarioProcessa.checarEmail(scan.next());
			if (indice != -1) {
				System.out.println("Digite a senha: ");
				String senha = scan.next();
				if (UsuarioProcessa.checarSenha(indice, senha)) {
					System.out.println("Acesso permitido");
				} else {
					System.out.println("Acesso negado");
				}
			} else {
				System.out.println("Usuário não encontrado");
			}
		}
	}
}
