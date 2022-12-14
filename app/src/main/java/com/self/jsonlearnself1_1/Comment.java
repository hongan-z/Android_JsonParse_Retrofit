package com.self.jsonlearnself1_1;

import com.google.gson.annotations.SerializedName;

public class Comment {
    private int postId;
    @SerializedName("it")
    private  int id;
    private String name;
    private String email;
    private String body;

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
