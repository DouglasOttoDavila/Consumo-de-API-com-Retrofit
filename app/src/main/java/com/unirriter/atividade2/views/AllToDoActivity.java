package com.unirriter.atividade2.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.unirriter.atividade2.R;
import com.unirriter.atividade2.adapters.ToDoAdapter;
import com.unirriter.atividade2.adapters.UserAdapter;
import com.unirriter.atividade2.models.ToDo;
import com.unirriter.atividade2.models.User;
import com.unirriter.atividade2.presenter.ToDoListContract;
import com.unirriter.atividade2.presenter.ToDoListPresenter;
import com.unirriter.atividade2.presenter.UserListContract;
import com.unirriter.atividade2.presenter.UserListPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AllToDoActivity extends AppCompatActivity implements ToDoListContract.View {

    private RecyclerView recyclerView;
    private ToDoListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_todo);

        //<Início> Instancia o botão para acessar a atividade MAIN
        Button backToHomeBtn = findViewById(R.id.backToHomeBtn);
        backToHomeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(AllToDoActivity.this, MainActivity.class);
            startActivity(intent);
        });
        //<Final> Instancia o botão para acessar a atividade MAIN

        recyclerView = findViewById(R.id.recyclerViewToDo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter = new ToDoListPresenter(this);
        presenter.getToDos();
    }

    @Override
    public void showLoading() {
        // show loading progress
    }

    @Override
    public void hideLoading() {
        // hide loading progress
    }

    @Override
    public void showToDos(List<ToDo> toDoList) {
        ToDoAdapter toDoAdapter = new ToDoAdapter(this, toDoList);
        recyclerView.setAdapter(toDoAdapter);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}