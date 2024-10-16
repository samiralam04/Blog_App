package com.servlets.Blog_App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/blogapp"; // PostgreSQL URL
    private static final String USER = "postgres"; // PostgreSQL username
    private static final String PASSWORD = "mark47"; // PostgreSQL password
    private static final String DRIVER_CLASS = "org.postgresql.Driver"; // PostgreSQL driver class

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName(DRIVER_CLASS); // Load the PostgreSQL JDBC driver
            connection = DriverManager.getConnection(URL, USER, PASSWORD); // Establish connection
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
