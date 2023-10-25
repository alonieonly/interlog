package br.com.inter.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JDeleteProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	public Boolean isadmin = false;

	/**
	 * Create the frame.
	 */
	public JDeleteProduct(Boolean admin) {
		isadmin = admin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(11, 10, 307, 489);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EXCLUIR PRODUTO");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(62, 5, 183, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Preencha os campos abaixo");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(62, 31, 191, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(48, 210, 211, 37);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID do produto");
		lblNewLabel_2.setBounds(48, 190, 75, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setBounds(48, 257, 211, 37);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText() != null && !textField.getText().isEmpty()) {
					try {
						Connection conn = JConnection.createConnection();
						if (conn != null) {
							String sqlCheck = "SELECT * FROM produtos WHERE IDProduto = ?";
							PreparedStatement ps2 = conn.prepareStatement(sqlCheck);
							ps2.setInt(1,Integer.parseInt(textField.getText()));
							ResultSet rs = ps2.executeQuery();
							if (rs.next()) {
								String sqlconsult = "DELETE FROM produtos WHERE IDProduto = ?";
								// String sqlconsult = "INSERT INTO produtos (NomeProduto,QuantidadeEstoque,Valor) VALUES('alonie','1','1')";
								PreparedStatement ps = conn.prepareStatement(sqlconsult);
								ps.setInt(1,Integer.parseInt(textField.getText()));
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
							}else {
								JOptionPane.showMessageDialog(btnNewButton, "ID não encontrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
							}
						}
					}catch (SQLException f) {
						f.printStackTrace(); // Lida com exceções, se ocorrerem
					}
				} else {
					JOptionPane.showMessageDialog(textField, "ID inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		JButton backButton = new JButton("Voltar");
		backButton.setForeground(new Color(0, 128, 128));
		backButton.setBounds(48, 305, 211, 37);
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
