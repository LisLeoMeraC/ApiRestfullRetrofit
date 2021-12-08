package com.example.apirestfullretrofit;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonUserApi {
    @GET("users")
    Call<List<Post>> getPosts();
}
