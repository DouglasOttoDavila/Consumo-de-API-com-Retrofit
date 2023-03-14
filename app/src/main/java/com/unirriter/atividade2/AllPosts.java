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

public class AllPosts extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_posts);

        //<Início> Instancia o botão para acessar a atividade MAIN
        Button backToHomeBtn = findViewById(R.id.backToHomeBtn);
        backToHomeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(AllPosts.this, MainActivity.class);
            startActivity(intent);
        });
        //<Final> Instancia o botão para acessar a atividade MAIN

        Button listAllUsers = findViewById(R.id.listAllUsers);
        listAllUsers.setOnClickListener(v -> {

            recyclerView = findViewById(R.id.recyclerViewPosts);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            JSONPlaceholderPosts jsonPlaceholder = retrofit.create(JSONPlaceholderPosts.class);
            Call<List<Post>> call = jsonPlaceholder.getPost();
            call.enqueue(new Callback<List<Post>>() {
                @Override
                public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(AllPosts.this, response.code(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    List<Post> postList = response.body();
                    PostAdapter postAdapter = new PostAdapter(AllPosts.this, postList);
                    recyclerView.setAdapter(postAdapter);
                }

                @Override
                public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                    Toast.makeText(AllPosts.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}