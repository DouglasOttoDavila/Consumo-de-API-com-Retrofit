package com.unirriter.atividade2.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.unirriter.atividade2.R;
import com.unirriter.atividade2.adapters.CommentAdapter;
import com.unirriter.atividade2.models.Comment;
import com.unirriter.atividade2.presenter.CommentListContract;
import com.unirriter.atividade2.presenter.CommentListPresenter;

import java.util.List;

public class AllCommentsActivity extends AppCompatActivity implements CommentListContract.View {

    private RecyclerView recyclerView;
    private CommentListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_comments);

        //<Início> Instancia o botão para acessar a atividade MAIN
        Button backToHomeBtn = findViewById(R.id.backToHomeBtn);
        backToHomeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(AllCommentsActivity.this, MainActivity.class);
            startActivity(intent);
        });
        //<Final> Instancia o botão para acessar a atividade MAIN

        recyclerView = findViewById(R.id.recyclerViewComments);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter = new CommentListPresenter(this);
        presenter.getComments();
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
    public void showComments(List<Comment> commentList) {
        CommentAdapter commentAdapter = new CommentAdapter(this, commentList);
        recyclerView.setAdapter(commentAdapter);
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