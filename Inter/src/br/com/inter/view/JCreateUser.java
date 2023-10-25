package br.com.inter.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JCreateUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UsertextField;
	private JTextField UsertextField_1;
	public Boolean isadmin = false;

	/**
	 * Create the frame.
	 */
	public JCreateUser(Boolean admin) {
		isadmin = admin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(11, 11, 307, 489);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRAR FUNCIONARIO");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(31, 11, 244, 19);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Preencha os campos abaixo");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(71, 33, 165, 14);
		panel.add(lblNewLabel_1);
		
		UsertextField = new JTextField();
		UsertextField.setBounds(48, 128, 211, 37);
		panel.add(UsertextField);
		UsertextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setBounds(49, 108, 46, 14);
		panel.add(lblNewLabel_2);
		
		UsertextField_1 = new JTextField();
		UsertextField_1.setColumns(10);
		UsertextField_1.setBounds(47, 200, 211, 37);
		panel.add(UsertextField_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Senha");
		lblNewLabel_2_1.setBounds(48, 180, 46, 14);
		panel.add(lblNewLabel_2_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Administrador");
		chckbxNewCheckBox.setBounds(46, 256, 97, 23);
		panel.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setBounds(48, 300, 211, 37);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (UsertextField.getText() != null && !UsertextField.getText().isEmpty()) {
					if (UsertextField_1.getText() != null && !UsertextField_1.getText().isEmpty()) {
						try {
							Connection conn = JConnection.createConnection();
							if (conn != null) {
								String sqlCheck = "SELECT * FROM funcionarios WHERE Usuario = ?";
								PreparedStatement ps2 = conn.prepareStatement(sqlCheck);
								ps2.setString(1,UsertextField.getText().toString());
								ResultSet rs = ps2.executeQuery();
								System.out.println(rs.next());
								if (rs.next()) {
									JOptionPane.showMessageDialog(btnNewButton, "Usuário já registrado!", "Aviso", JOptionPane.WARNING_MESSAGE);
								} else {
									String sqlconsult = "INSERT INTO funcionarios (Usuario,Senha,isadmin) VALUES(?,?,?)";
									int setadmin = 0;
									boolean estaMarcado = chckbxNewCheckBox.isSelected();
									if (estaMarcado) {
										setadmin = 1;
									}
									// String sqlconsult = "INSERT INTO produtos (NomeProduto,QuantidadeEstoque,Valor) VALUES('alonie','1','1')";
									PreparedStatement ps = conn.prepareStatement(sqlconsult);
									ps.setString(1,UsertextField.getText().toString());
									ps.setString(2,UsertextField_1.getText().toString());
									ps.setInt(3,setadmin);
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
							}
						}catch (SQLException f) {
							f.printStackTrace(); // Lida com exceções, se ocorrerem
						}
					} else {
						JOptionPane.showMessageDialog(UsertextField_1, "Senha inválida!", "Aviso", JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(UsertextField, "Usuario inválido!", "Aviso", JOptionPane.WARNING_MESSAGE);
				}	
			}
		});
		
		JButton backButton = new JButton("Voltar");
		backButton.setForeground(new Color(0, 128, 128));
		backButton.setBounds(48, 348, 211, 37);
		panel.add(backButton);
	}
}
