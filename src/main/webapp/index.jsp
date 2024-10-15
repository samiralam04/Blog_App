<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blog Posts</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-4">All Blog Posts</h1>
    <!-- Link to create new post, make sure the URL is correctly mapped to /create -->
    <a href="/Blog_App/create" class="btn btn-primary mb-4">Create New Post</a>

    <div class="row">
        <!-- Loop through posts and display them -->
        <c:forEach var="post" items="${posts}">
            <div class="col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <h5 class="card-title">${post.title}</h5>
                        <p class="card-text">${post.content}</p>
                        <!-- Edit button, map to the servlet URL for editing the post -->
                        <a href="/Blog_App/edit?id=${post.id}" class="btn btn-warning">Edit</a>

                        <!-- Delete form, ensure the action matches your servlet mapping for delete -->
                        <form action="/Blog_App/delete" method="post" style="display:inline;">
                            <input type="hidden" name="id" value="${post.id}">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
