package com.unirriter.atividade2.presenters;

import com.unirriter.atividade2.models.Post;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholderPosts {
    @GET("posts")
    Call<List<Post>> getPost();
}


