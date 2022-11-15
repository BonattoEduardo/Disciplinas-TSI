package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public static Connection getConnection(String host, String database, String user, String password) throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://" + host + "/" + database, // localhost:3306
            user,
            password
        );
    }
}
