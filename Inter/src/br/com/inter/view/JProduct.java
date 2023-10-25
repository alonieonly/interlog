package br.com.inter.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeDoProduto;
	private JTextField textField_1;
	private JTextField textField_2;
	private Boolean isadmin = false;

	public JProduct(Boolean admin) {
		isadmin = admin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 307, 489);
		contentPane.add(panel);
		
		JLabel lblRegistrar = new JLabel("REGISTRAR PRODUTO");
		lblRegistrar.setForeground(new Color(0, 128, 128));
		lblRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegistrar.setBounds(53, 11, 200, 62);
		panel.add(lblRegistrar);
		
		JLabel lblNewLabel_1 = new JLabel("Preencha os campos abaixo");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(58, 56, 190, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("Inter\\icons\\interlog_teal64.png"));
		lblNewLabel_2.setBounds(121, 392, 64, 64);
		panel.add(lblNewLabel_2);
		
		txtNomeDoProduto = new JTextField();
		txtNomeDoProduto.setToolTipText("Nome do produto");
		txtNomeDoProduto.setForeground(new Color(0, 0, 0));
		txtNomeDoProduto.setBounds(48, 147, 211, 31);
		panel.add(txtNomeDoProduto);
		txtNomeDoProduto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome do produto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(92, 123, 122, 20);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Valor do produto");
		textField_1.setForeground(Color.BLACK);
		textField_1.setColumns(10);
		textField_1.setBounds(48, 213, 211, 31);
		panel.add(textField_1);
		
		JLabel lblValor = new JLabel("Valor do produto");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValor.setBounds(96, 189, 114, 20);
		panel.add(lblValor);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Quantidade em estoque");
		textField_2.setForeground(Color.BLACK);
		textField_2.setColumns(10);
		textField_2.setBounds(48, 279, 211, 31);
		panel.add(textField_2);
		
		JLabel lblQuantidadeEmEstoque = new JLabel("Quantidade em estoque");
		lblQuantidadeEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantidadeEmEstoque.setBounds(72, 255, 163, 20);
		panel.add(lblQuantidadeEmEstoque);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setBounds(48, 332, 211, 31);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNomeDoProduto.getText() != null && !txtNomeDoProduto.getText().isEmpty()) {
					if (textField_1.getText() != null && !textField_1.getText().isEmpty()) {
						if (textField_2.getText() != null && !textField_2.getText().isEmpty()) {
							try {
								Connection conn = JConnection.createConnection();
								if (conn != null) {
									String sqlconsult = "INSERT INTO produtos (NomeProduto,QuantidadeEstoque,Valor) VALUES(?,?,?)";
									// String sqlconsult = "INSERT INTO produtos (NomeProduto,QuantidadeEstoque,Valor) VALUES('alonie','1','1')";
									PreparedStatement ps = conn.prepareStatement(sqlconsult);
									ps.setString(1,txtNomeDoProduto.getText().toString());
									ps.setInt(2,Integer.parseInt(textField_2.getText()));
									ps.setInt(3,Integer.parseInt(textField_1.getText()));
									ps.execute();
									conn.commit();
									dispose();
									if (isadmin) {
										JHomeAdmin jPrincipal = new JHomeAdmin(isadmin);
										jPrincipal.setLocationRelativeTo(jPrincipal);
										jPrincipal.setVisible(true);
									} else {
										JHome jPrincipal = new JHome(isadmin);
										jPrincipal.setLocationRelativeTo(jPrincipal);
										jPrincipal.setVisible(true);
									}
								}
							}catch (SQLException f) {
								f.printStackTrace(); // Lida com exceções, se ocorrerem
							}
						} else {
							JOptionPane.showMessageDialog(textField_2, "Quantidade inválida!", "Aviso", JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(textField_1, "Valor inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(txtNomeDoProduto, "Nome inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
				}		
			}
		});
		
		JButton backButton = new JButton("Voltar");
		backButton.setForeground(new Color(0, 128, 128));
		backButton.setBounds(48, 368, 211, 31);
		panel.add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if (isadmin) {
					JHomeAdmin jPrincipal = new JHomeAdmin(isadmin);
					jPrincipal.setLocationRelativeTo(jPrincipal);
					jPrincipal.setVisible(true);
				} else {
					JHome jPrincipal = new JHome(isadmin);
					jPrincipal.setLocationRelativeTo(jPrincipal);
					jPrincipal.setVisible(true);
				}
			}	
		});
	}
}
