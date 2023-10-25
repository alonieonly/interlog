package br.com.inter.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable table;
	private JTextField textField;
	private Boolean isadmin = false;

	public JHome(Boolean admin) {
		isadmin = admin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 552);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(17, 11, 307, 489);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BEM-VINDO(A)!");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(48, 11, 211, 62);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("O que deseja fazer agora?");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(58, 56, 190, 20);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_5 = new JButton("Registrar produto");
		btnNewButton_5.setBackground(new Color(0, 128, 128));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBounds(48, 203, 211, 31);
		panel.add(btnNewButton_5);

		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JProduct jPrincipal = new JProduct(isadmin);
				jPrincipal.setLocationRelativeTo(jPrincipal);
				jPrincipal.setVisible(true);
			}
		});  
		JButton btnNewButton_1 = new JButton("Editar produto");
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(48, 241, 211, 31);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JEditProduct jPrincipal = new JEditProduct(isadmin);
				jPrincipal.setLocationRelativeTo(jPrincipal);
				jPrincipal.setVisible(true);
			}
		});  
		
		JButton btnNewButton_2 = new JButton("Excluir produto");
		btnNewButton_2.setBackground(new Color(0, 128, 128));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(48, 278, 211, 31);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JDeleteProduct jPrincipal = new JDeleteProduct(isadmin);
				jPrincipal.setLocationRelativeTo(jPrincipal);
				jPrincipal.setVisible(true);
			}
		});
		
		JButton exitButton = new JButton ("Sair");
		exitButton.setBackground(new Color(0, 128, 128));
		exitButton.setForeground(new Color(255, 255 ,255));
		exitButton.setBounds(48, 318, 211, 31);
		panel.add(exitButton);		
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JLogin frame = new JLogin();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}	
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("Inter\\icons\\interlog_teal64.png"));
		lblNewLabel_2.setBounds(121, 359, 64, 64);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(350, 11, 624, 489);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 604, 393);
		panel_1.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		scrollPane.setViewportView(table);
		table.setModel(model);
		model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Estoque");
        model.addColumn("Valor");
		
		try {
			Connection conn = JConnection.createConnection();
			if (conn != null) {
				String sqlconsult = "SELECT * FROM produtos";
				PreparedStatement ps = conn.prepareStatement(sqlconsult);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("IDProduto");
					String nome = rs.getString("NomeProduto");
					int estoque = rs.getInt("QuantidadeEstoque");
					int valor = rs.getInt("Valor");
					model.addRow(new Object[]{id, nome, estoque,valor});
				}
			}
		}catch (SQLException f) {
			f.printStackTrace(); // Lida com exceções, se ocorrerem
		}
	}
}
