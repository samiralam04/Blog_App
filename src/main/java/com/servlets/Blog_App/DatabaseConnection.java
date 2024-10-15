package com.servlets.Blog_App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/blogapp";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "mark47";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace(); // Log the error
            return null;
        }
    }
}
