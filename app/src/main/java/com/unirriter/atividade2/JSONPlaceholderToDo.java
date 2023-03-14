package com.unirriter.atividade2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholderToDo {
    @GET("todos")
    Call<List<ToDo>> getToDo();
}


