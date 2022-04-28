package visao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	// atributos da tela
	private JPanel painel;
	private JLabel rotulo1, rotulo2;
	private JTextField email, senha;
	private JButton login;

	public TelaLogin() {

		// Propriedades Básicas
		setTitle("Tela de Login");
		setBounds(600, 300, 400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		painel = new JPanel();
		setContentPane(painel);
		setLayout(null);

		// Conteúdos da tela
		rotulo1 = new JLabel("Nome:");
		rotulo1.setBounds(20, 20, 100, 20);
		
		email = new JTextField();
		email.setBounds(150, 20, 200, 30);
		
		rotulo2 = new JLabel("Ano de Nascimeto:");
		rotulo2.setBounds(20, 60, 200, 20);
		
		senha = new JTextField();
		senha.setBounds(150, 60, 200, 30);
		
		login = new JButton("Ok");
		login.setBounds(150, 100, 200, 30);
		login.addActionListener(this);

		painel.add(rotulo1);
		painel.add(email);
		painel.add(rotulo2);
		painel.add(senha);
		painel.add(login);
	}

	public static void main(String[] args) {
		TelaLogin tela = new TelaLogin();
		tela.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login) {
			JOptionPane.showMessageDialog(this, "Oi, você clicou em Login");
		}
	}
}
