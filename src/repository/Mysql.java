package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {

    private static final String URL = "jdbc:mysql://localhost:3306/text_adventure_game";  // Substitua "seu_banco" pelo nome do banco de dados
    private static final String USER = "root";  // Usuário do MySQL
    private static final String PASSWORD = "@GabrielHSS06";  // Senha do MySQL

    public static Connection getConnection() {
        try {
            // Registra o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Retorna a conexão com o banco de dados
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }
    }
}
