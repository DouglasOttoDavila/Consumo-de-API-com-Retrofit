package com.unirriter.atividade2.presenters;

import com.unirriter.atividade2.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholderUsers {
    @GET("users")
    Call<List<User>> getUser();
}


