package com.servlets.Blog_App;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        if (id != null && !id.isEmpty()) {
            // Fetch and display a single blog post by ID
            viewSinglePost(request, response, id);
        } else {
            // Fetch and display all blog posts
            viewAllPosts(request, response);
        }
    }

    // Method to view a single post
    private void viewSinglePost(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
        BlogPost post = null;

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM posts WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                post = new BlogPost(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (post != null) {
            request.setAttribute("post", post);
            request.getRequestDispatcher("/view.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Blog post not found");
        }
    }

    // Method to view all posts
    private void viewAllPosts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BlogPost> blogPosts = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM posts";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BlogPost post = new BlogPost(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content")
                );
                blogPosts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("posts", blogPosts);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
