package br.com.inter.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JEditProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField PIDtextField;
	private JTextField PNametextField;
	private JTextField PValortextField;
	private JTextField PqtdtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JEditProduct frame = new JEditProduct();
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
	public JEditProduct() {
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
		
		JLabel lblNewLabel = new JLabel("EDITAR PRODUTO");
		lblNewLabel.setBounds(71, 5, 164, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(0, 128, 128));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Preencha os campos abaixo");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(76, 30, 154, 14);
		panel.add(lblNewLabel_1);
		
		PIDtextField = new JTextField();
		PIDtextField.setBounds(48, 108, 211, 31);
		panel.add(PIDtextField);
		PIDtextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID do produto");
		lblNewLabel_2.setBounds(48, 90, 73, 14);
		panel.add(lblNewLabel_2);
		
		PNametextField = new JTextField();
		PNametextField.setColumns(10);
		PNametextField.setBounds(48, 174, 211, 31);
		panel.add(PNametextField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nome do produto");
		lblNewLabel_2_1.setBounds(48, 155, 91, 14);
		panel.add(lblNewLabel_2_1);
		
		PValortextField = new JTextField();
		PValortextField.setColumns(10);
		PValortextField.setBounds(48, 235, 211, 31);
		panel.add(PValortextField);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Valor do produto");
		lblNewLabel_2_1_1.setBounds(48, 216, 91, 14);
		panel.add(lblNewLabel_2_1_1);
		
		PqtdtextField = new JTextField();
		PqtdtextField.setColumns(10);
		PqtdtextField.setBounds(48, 296, 211, 31);
		panel.add(PqtdtextField);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Quantidade em estoque");
		lblNewLabel_2_1_1_1.setBounds(48, 277, 124, 14);
		panel.add(lblNewLabel_2_1_1_1);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setBounds(48, 350, 211, 37);
		panel.add(btnNewButton);
		
	}
}
