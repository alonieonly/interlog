package br.com.inter.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField txtNomeDoProduto;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JProduct frame = new JProduct();
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
	public JProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(350, 11, 624, 489);
		contentPane.add(panel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 25, 477, 30);
		panel_1.add(textField);
		
		JButton btnNewButton_3 = new JButton("Pesquisar");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(new Color(0, 128, 128));
		btnNewButton_3.setBounds(495, 25, 119, 30);
		panel_1.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 604, 393);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Valor", "Estoque"
			}
		));
		scrollPane.setViewportView(table);
		
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
		lblNewLabel_2.setIcon(new ImageIcon("F:\\eclipse-workspace\\Inter\\icons\\interlog_teal64.png"));
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
		textField_1.setToolTipText("Nome do produto");
		textField_1.setForeground(Color.BLACK);
		textField_1.setColumns(10);
		textField_1.setBounds(48, 213, 211, 31);
		panel.add(textField_1);
		
		JLabel lblValor = new JLabel("Valor do produto");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValor.setBounds(96, 189, 114, 20);
		panel.add(lblValor);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Nome do produto");
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
	}
}
