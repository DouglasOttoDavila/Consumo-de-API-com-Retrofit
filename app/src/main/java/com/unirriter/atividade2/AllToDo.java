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

public class AllToDo extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_todo);

        //<Início> Instancia o botão para acessar a atividade MAIN
        Button backToHomeBtn = findViewById(R.id.backToHomeBtn);
        backToHomeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(AllToDo.this, MainActivity.class);
            startActivity(intent);
        });
        //<Final> Instancia o botão para acessar a atividade MAIN


        Button listAllToDo = findViewById(R.id.listAllToDo);
        listAllToDo.setOnClickListener(v -> {

            recyclerView = findViewById(R.id.recyclerViewToDo);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            JSONPlaceholderToDo jsonPlaceholder = retrofit.create(JSONPlaceholderToDo.class);
            Call<List<ToDo>> call = jsonPlaceholder.getToDo();
            call.enqueue(new Callback<List<ToDo>>() {
                @Override
                public void onResponse(Call<List<ToDo>> call, @NonNull Response<List<ToDo>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(AllToDo.this, response.code(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    List<ToDo> toDoList = response.body();
                    ToDoAdapter toDoAdapter = new ToDoAdapter(AllToDo.this, toDoList);
                    recyclerView.setAdapter(toDoAdapter);
                }

                @Override
                public void onFailure(@NonNull Call<List<ToDo>> call, Throwable t) {
                    Toast.makeText(AllToDo.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}