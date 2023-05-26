package org.example.SpringMVCApp.util;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
@NoArgsConstructor
public class PostgresInit {
    private static final String url = "jdbc:postgresql://localhost:5432/my_db";
    private static final String userName = "postgres";
    private static final String password = "postgres";
    private static final String driver = "org.postgresql.Driver";
    private static Connection connection;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        if (connection == null) {
            connection = DriverManager.getConnection(url, userName, password);
        }
        return connection;
    }

}
