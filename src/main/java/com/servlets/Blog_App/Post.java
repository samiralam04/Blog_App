package com.servlets.Blog_App;

public class Post {
    private int id;  // Auto-incrementing primary key
    private String title;
    private String content;

    // Constructor for creating a new Post (without an ID)
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Constructor for updating or retrieving a Post with an ID
    public Post(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // Getters and setters for the fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Optional: Useful for logging or debugging purposes
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
