package com.servlets.Blog_App;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/blog")
public class BlogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve all posts from the database using PostDAO
        List<Post> posts = PostDAO.getAllPosts();

        // Check if posts exist
        if (posts == null || posts.isEmpty()) {
            request.setAttribute("message", "No posts available.");
        } else {
            request.setAttribute("posts", posts);
        }

        // Forward the request to a JSP page to display posts dynamically
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve title and content from the form
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        // Create a new Post object with the provided title and content
        Post post = new Post(title, content);

        // Save the post to the database using PostDAO
        PostDAO.savePost(post);

        // Redirect to the /blog page to show the updated list of posts
        response.sendRedirect("/blog");
    }
}
