package com.self.jsonlearnself1_1;

import com.google.gson.annotations.SerializedName;

public class Post {

    private  int userId;
    @SerializedName("it")
    private int id;
    private String title;
    private String body;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
