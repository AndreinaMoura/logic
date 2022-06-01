package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controle.ProdutoProcess;
import controle.UsuarioProcessa;
import uteis.Criptografia;

public class LoginForm extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	// Itens na tela de login 
	private JPanel painel;
	private JLabel rotulo1, rotulo2;
	private JTextField tfLogin;
	private JPasswordField senha;
	private JButton login;
	private String imgIco = "";
	
	LoginForm() {
		setTitle("Tela de Login");
		//logo
		setIconImage(new ImageIcon(imgIco).getImage());
		setBounds(600, 300, 360, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		painel = new JPanel();
		painel.setBackground(new Color(255, 233, 213));
		setContentPane(painel);
		setLayout(null);
		
		//itens na tela
		rotulo1 = new JLabel("Login");
		rotulo1.setBounds(20, 20, 100, 20);
		tfLogin = new JTextField();
		tfLogin.setBounds(120, 20, 200, 30);
		rotulo2 = new JLabel ("Senha");
		rotulo2.setBounds(20, 60, 100, 20);
		senha = new JPasswordField();
		senha.setEchoChar('*');
		senha.setBounds(120, 60, 200, 30);
		login = new JButton("Login");
		login.setBounds(120, 100, 200, 30);
		
		
		login.addActionListener(this);
		
		//colocando itens no painel 
		painel.add(rotulo1);
		painel.add(tfLogin);
		painel.add(rotulo2);
		painel.add(senha);
		painel.add(login);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login) {
			if (tfLogin.getText().length() > 0 && new String(senha.getPassword()).length() > 0) {
				int indice = UsuarioProcessa.verificarLogin(tfLogin.getText());
				if (indice != -1) {
					if (UsuarioProcessa.checarSenha(indice, Criptografia.encripta(new String(senha.getPassword())))) {
						this.dispose();
						TelaPrincipal pf = new TelaPrincipal();
						pf.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(this, "Acesso negado");
					}
				} else {
					JOptionPane.showMessageDialog(this, "Usuário não encontrado");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Preencha o login e a senha");
			}
		}
	}
	public static void main(String[] args) {
		UsuarioProcessa.abrir();
		LoginForm login = new LoginForm();
		login.setVisible(true);
	}


	public void setModal(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

