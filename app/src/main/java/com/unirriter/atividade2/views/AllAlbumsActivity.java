package com.unirriter.atividade2.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.unirriter.atividade2.R;
import com.unirriter.atividade2.adapters.AlbumAdapter;
import com.unirriter.atividade2.adapters.UserAdapter;
import com.unirriter.atividade2.models.Album;
import com.unirriter.atividade2.models.User;
import com.unirriter.atividade2.presenter.AlbumListContract;
import com.unirriter.atividade2.presenter.AlbumListPresenter;
import com.unirriter.atividade2.presenter.UserListContract;
import com.unirriter.atividade2.presenter.UserListPresenter;

import java.util.List;

public class AllAlbumsActivity extends AppCompatActivity implements AlbumListContract.View {

    private RecyclerView recyclerView;
    private AlbumListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_albums);

        //<Início> Instancia o botão para acessar a atividade MAIN
        Button backToHomeBtn = findViewById(R.id.backToHomeBtn);
        backToHomeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(AllAlbumsActivity.this, MainActivity.class);
            startActivity(intent);
        });
        //<Final> Instancia o botão para acessar a atividade MAIN

        recyclerView = findViewById(R.id.recyclerViewAlbums);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter = new AlbumListPresenter(this);
        presenter.getAlbums();
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
    public void showAlbums(List<Album> albumList) {
        AlbumAdapter albumAdapter = new AlbumAdapter(this, albumList);
        recyclerView.setAdapter(albumAdapter);
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