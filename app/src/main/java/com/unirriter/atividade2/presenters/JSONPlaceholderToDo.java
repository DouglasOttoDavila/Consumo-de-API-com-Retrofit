package com.unirriter.atividade2.presenters;

import com.unirriter.atividade2.models.ToDo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholderToDo {
    @GET("todos")
    Call<List<ToDo>> getToDo();
}


