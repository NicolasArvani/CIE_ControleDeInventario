package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class frmCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtValor;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public frmCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lvlTitle = new JLabel("Cadastro de Ativos");
		lvlTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lvlTitle.setBounds(20, 10, 236, 30);
		contentPane.add(lvlTitle);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(252, 173, 102, 30);
		contentPane.add(btnCadastrar);
		
		txtNome = new JTextField();
		txtNome.setBounds(94, 47, 96, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(30, 50, 45, 13);
		contentPane.add(lblNome);
		
		JLabel lvlValor = new JLabel("Valor:");
		lvlValor.setBounds(29, 73, 46, 13);
		contentPane.add(lvlValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(94, 70, 96, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JCheckBox chkGeradorDeReceita = new JCheckBox("Gerador de Receita");
		chkGeradorDeReceita.setBounds(94, 93, 162, 21);
		contentPane.add(chkGeradorDeReceita);
	}
}
