package com.example.androidstudyguide;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JSONPlaceholderAPI {

    @GET("photos")
    Call<List<Photos>> getPhotos();

    @GET("posts")
    Call<List<Post>> getPosts();

    @POST("posts")
    Call<Post> createPost(@Body Post post);
}
