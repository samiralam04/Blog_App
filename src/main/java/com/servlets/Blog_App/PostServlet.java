package com.servlets.Blog_App;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post")
public class PostServlet extends HttpServlet {

    // Handle GET request to display the details of a post
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve the post ID from the request parameters
            int postId = Integer.parseInt(request.getParameter("id"));

            // Fetch the post details from the database using the PostDAO
            Post post = PostDAO.getPostById(postId);

            // Set the post as an attribute to forward to the post-detail page
            request.setAttribute("post", post);

            // Forward the request to the post-detail.html (or JSP if you're using JSP)
            request.getRequestDispatcher("/post-detail.html").forward(request, response);
        } catch (NumberFormatException e) {
            // Handle invalid post ID format
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid post ID format.");
        }
    }

    // Handle POST request to update a specific post
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve the post ID, title, and content from the request parameters
            int postId = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            // Create a new Post object to hold the updated data
            Post post = new Post(postId, title, content);

            // Update the post in the database using PostDAO
            PostDAO.updatePost(post);

            // Redirect to the post detail page to reflect the updated post
            response.sendRedirect("/post?id=" + postId);
        } catch (NumberFormatException e) {
            // Handle invalid post ID format or other request parameter issues
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid post ID or missing parameters.");
        }
    }

    // Handle DELETE request to delete a post
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve the post ID from the request parameters
            int postId = Integer.parseInt(request.getParameter("id"));

            // Delete the post from the database using PostDAO
            PostDAO.deletePost(postId);

            // Redirect to the blog list page after deleting the post
            response.sendRedirect("/blog");
        } catch (NumberFormatException e) {
            // Handle invalid post ID format or other request issues
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid post ID format.");
        }
    }
}
