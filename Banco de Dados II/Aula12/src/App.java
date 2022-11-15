import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String args[]) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/teste",
                "root",
                "root"
            );

            System.out.println("Conectado");
            
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            
        }
    }

}
