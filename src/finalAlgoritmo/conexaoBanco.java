package finalAlgoritmo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBanco{
    // Configurações de conexão com o banco de dados
    private static final String URL = "jdbc:postgresql://localhost:5432/nomedobanco"; // Substitua com seu banco
    private static final String USER = "seu_usuario";  // Seu usuário do PostgreSQL
    private static final String PASSWORD = "sua_senha"; // Sua senha do PostgreSQL

    // Método que retorna uma conexão
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
