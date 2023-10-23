package br.com.inter.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class JCreateUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UsertextField;
	private JTextField UsertextField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCreateUser frame = new JCreateUser();
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
	public JCreateUser() {
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
	}
}
