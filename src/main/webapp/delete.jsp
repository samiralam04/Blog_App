<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Blog Post</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-4">Delete Blog Post</h1>
    <p>Are you sure you want to delete this post?</p>
    <form action="/delete" method="post">
        <input type="hidden" name="id" value="${post.id}">
        <button type="submit" class="btn btn-danger">Yes, Delete</button>
    </form>
</div>
</body>
</html>
