package br.com.inter.view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JConnection {
    public JConnection() {
        
    }

    public static Connection createConnection() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/interdados"; //Nome da base de dados
		String user = "root"; //nome do usuário do MySQL
		String password = ""; //senha do MySQL
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(url, user, password);
            conexao.setAutoCommit(false);
        } catch (SQLException | ClassNotFoundException e) {			
            System.out.println("Erro ao conectar com o banco de dados: "+e.getMessage());
        }
		return conexao;
	}
}
