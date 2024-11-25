package finalAlgoritmo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBanco {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";  // Altere o nome do banco
    private static final String USER = "banco01";  // Altere conforme seu usuário
    private static final String PASSWORD = "1234";  // Altere conforme sua senha

    public static Connection getConexao() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver não encontrado.", e);
        }
    }
}
