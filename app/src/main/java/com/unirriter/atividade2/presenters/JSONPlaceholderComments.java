package com.unirriter.atividade2.presenters;

import com.unirriter.atividade2.models.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholderComments {
    @GET("comments")
    Call<List<Comment>> getComment();
}


