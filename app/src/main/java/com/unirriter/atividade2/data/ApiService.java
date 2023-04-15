package com.unirriter.atividade2.data;

import com.unirriter.atividade2.models.Comment;
import com.unirriter.atividade2.models.Post;
import com.unirriter.atividade2.models.ToDo;
import com.unirriter.atividade2.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("users")
    Call<List<User>> getUsers();

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("comments")
    Call<List<Comment>> getComments();

    @GET("todos")
    Call<List<ToDo>> getTodos();
}
