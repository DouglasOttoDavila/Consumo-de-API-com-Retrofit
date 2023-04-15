package com.unirriter.atividade2.data;

import com.unirriter.atividade2.models.Comment;
import com.unirriter.atividade2.models.Post;
import com.unirriter.atividade2.models.ToDo;
import com.unirriter.atividade2.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {

    private static ApiHelper instance;
    private ApiService apiService;

    private ApiHelper() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static synchronized ApiHelper getInstance() {
        if (instance == null) {
            instance = new ApiHelper();
        }
        return instance;
    }

    public void getUsers(Callback<List<User>> callback) {
        Call<List<User>> call = apiService.getUsers();
        call.enqueue(callback);
    }

    public void getPosts(Callback<List<Post>> callback) {
        Call<List<Post>> call = apiService.getPosts();
        call.enqueue(callback);
    }

    public void getComments(Callback<List<Comment>> callback) {
        Call<List<Comment>> call = apiService.getComments();
        call.enqueue(callback);
    }

    public void getToDos(Callback<List<ToDo>> callback) {
        Call<List<ToDo>> call = apiService.getTodos();
        call.enqueue(callback);
    }
}
