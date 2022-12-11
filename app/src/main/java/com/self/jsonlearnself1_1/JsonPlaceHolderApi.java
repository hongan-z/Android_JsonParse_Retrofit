package com.self.jsonlearnself1_1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi
{
    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/3/comments")
    Call<List<Comment>> getComments();
 }
