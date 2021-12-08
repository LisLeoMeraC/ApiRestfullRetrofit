package com.example.apirestfullretrofit;

import com.google.gson.annotations.SerializedName;

public class Post {
    private String id, name,email, gender, status;

    @SerializedName("body")
    private String text;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }

    public String getText() {
        return text;
    }
}
