package com.servlets.Blog_App;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {

    // Helper method to establish a connection to PostgreSQL
    private static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/blogapp";
        String username = "postgres";
        String password = "mark47"; // Replace with your actual DB password
        return DriverManager.getConnection(url, username, password);
    }

    // Retrieve all posts from the database
    public static List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM posts";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                Post post = new Post(id, title, content);
                posts.add(post);
            }
        } catch (SQLException e) {
            // Improved: Log the exception (you can use a logging framework like SLF4J or Log4J)
            e.printStackTrace();
        }
        return posts;
    }

    // Insert a new post into the database
    public static void savePost(Post post) {
        String query = "INSERT INTO posts (title, content) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Log the exception
            e.printStackTrace();
        }
    }

    // Retrieve a specific post by ID from the database
    public static Post getPostById(int id) {
        String query = "SELECT * FROM posts WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                String content = rs.getString("content");
                return new Post(id, title, content);
            }
        } catch (SQLException e) {
            // Log the exception
            e.printStackTrace();
        }
        return null;
    }

    // Update an existing post in the database
    public static void updatePost(Post post) {
        String query = "UPDATE posts SET title = ?, content = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setInt(3, post.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Log the exception
            e.printStackTrace();
        }
    }

    // Delete a post from the database
    public static void deletePost(int id) {
        String query = "DELETE FROM posts WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Log the exception
            e.printStackTrace();
        }
    }
}
