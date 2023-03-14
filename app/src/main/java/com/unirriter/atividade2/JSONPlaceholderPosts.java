package com.unirriter.atividade2;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholderPosts {
    @GET("posts")
    Call<List<Post>> getPost();
}


