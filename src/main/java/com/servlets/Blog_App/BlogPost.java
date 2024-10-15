package com.servlets.Blog_App;

public class BlogPost {
    private int id;
    private String title;
    private String content;

    // Constructor
    public BlogPost(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String toString() {
        return "BlogPost{id=" + id + ", title='" + title + "', content='" + content + "'}";
    }
}
