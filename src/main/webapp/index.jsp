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
    <a href="/Blog_App/create" class="btn btn-primary mb-4">Create New Post</a>

    <div class="row">
        <c:forEach var="post" items="${posts}">
            <div class="col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <h5 class="card-title">${post.title}</h5>
                        <p class="card-text">${post.content}</p>
                        <a href="/edit.jsp?id=${post.id}" class="btn btn-warning">Edit</a>
                        <form action="/delete" method="post" style="display:inline;">
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
