package com.unirriter.atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AllComments extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_comments);

        //<Início> Instancia o botão para acessar a atividade MAIN
        Button backToHomeBtn = findViewById(R.id.backToHomeBtn);
        backToHomeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(AllComments.this, MainActivity.class);
            startActivity(intent);
        });
        //<Final> Instancia o botão para acessar a atividade MAIN

        Button listAllComments = findViewById(R.id.listAllCommentsBtn);
        listAllComments.setOnClickListener(v -> {

            recyclerView = findViewById(R.id.recyclerViewComments);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            JSONPlaceholderComments jsonPlaceholder = retrofit.create(JSONPlaceholderComments.class);
            Call<List<Comment>> call = jsonPlaceholder.getComment();
            call.enqueue(new Callback<List<Comment>>() {
                @Override
                public void onResponse(@NonNull Call<List<Comment>> call, @NonNull Response<List<Comment>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(AllComments.this, response.code(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    List<Comment> commentList = response.body();
                    CommentAdapter commentAdapter = new CommentAdapter(AllComments.this, commentList);
                    recyclerView.setAdapter(commentAdapter);
                }

                @Override
                public void onFailure(@NonNull Call<List<Comment>> call, @NonNull Throwable t) {
                    Toast.makeText(AllComments.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}