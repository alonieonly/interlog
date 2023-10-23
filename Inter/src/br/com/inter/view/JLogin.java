package br.com.inter.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class JLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JLogin() {
		setTitle("InterLog");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 984, 511);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel login_panel = new JPanel();
		login_panel.setBounds(10, 11, 307, 489);
		panel.add(login_panel);
		login_panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(103, 41, 100, 50);
		login_panel.add(lblNewLabel);
		
		txtLogin = new JTextField();
		txtLogin.setBackground(new Color(255, 255, 255));
		txtLogin.setForeground(new Color(0, 0, 0));
		txtLogin.setBounds(30, 200, 247, 27);
		login_panel.add(txtLogin);
		txtLogin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setBounds(30, 264, 247, 27);
		login_panel.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(30, 185, 57, 14);
		login_panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(30, 249, 46, 14);
		login_panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(90, 425, 127, 23);
		login_panel.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Lembrar dados");
		chckbxNewCheckBox.setBounds(30, 298, 127, 23);
		login_panel.add(chckbxNewCheckBox);
		
		JPanel logo_panel = new JPanel();
		logo_panel.setBackground(new Color(0, 128, 128));
		logo_panel.setBounds(340, 0, 644, 511);
		panel.add(logo_panel);
		logo_panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("F:\\eclipse-workspace\\Inter\\icons\\interlog.png"));
		lblNewLabel_3.setBounds(188, 122, 267, 266);
		logo_panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("2023 © Todos os diretos reservados.");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(236, 486, 185, 25);
		logo_panel.add(lblNewLabel_4);
	}
}
