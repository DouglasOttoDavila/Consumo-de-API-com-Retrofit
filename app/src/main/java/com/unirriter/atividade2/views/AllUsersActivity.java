package com.unirriter.atividade2.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import com.unirriter.atividade2.R;
import com.unirriter.atividade2.adapters.UserAdapter;
import com.unirriter.atividade2.models.User;
import com.unirriter.atividade2.presenter.UserListContract;
import com.unirriter.atividade2.presenter.UserListPresenter;
import java.util.List;

public class AllUsersActivity extends AppCompatActivity implements UserListContract.View {

    private RecyclerView recyclerView;
    private UserListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);

        //<Início> Instancia o botão para acessar a atividade MAIN
        Button backToHomeBtn = findViewById(R.id.backToHomeBtn);
        backToHomeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(AllUsersActivity.this, MainActivity.class);
            startActivity(intent);
        });
        //<Final> Instancia o botão para acessar a atividade MAIN

        recyclerView = findViewById(R.id.recyclerViewUsers);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter = new UserListPresenter(this);
        presenter.getUsers();
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
    public void showUsers(List<User> userList) {
        UserAdapter userAdapter = new UserAdapter(this, userList);
        recyclerView.setAdapter(userAdapter);
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