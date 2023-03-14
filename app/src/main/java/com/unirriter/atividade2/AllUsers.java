package com.unirriter.atividade2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AllUsers extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);

        //<Início> Instancia o botão para acessar a atividade MAIN
        Button backToHomeBtn = findViewById(R.id.backToHomeBtn);
        backToHomeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(AllUsers.this, MainActivity.class);
            startActivity(intent);
        });
        //<Final> Instancia o botão para acessar a atividade MAIN


        Button listAllUsers = findViewById(R.id.listAllUsers);
        listAllUsers.setOnClickListener(v -> {

            recyclerView = findViewById(R.id.recyclerViewUsers);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            JSONPlaceholderUsers jsonPlaceholder = retrofit.create(JSONPlaceholderUsers.class);
            Call<List<User>> call = jsonPlaceholder.getUser();
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, @NonNull Response<List<User>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(AllUsers.this, response.code(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    List<User> userList = response.body();
                    UserAdapter userAdapter = new UserAdapter(AllUsers.this, userList);
                    recyclerView.setAdapter(userAdapter);
                }

                @Override
                public void onFailure(@NonNull Call<List<User>> call, Throwable t) {
                    Toast.makeText(AllUsers.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}