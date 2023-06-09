package com.unirriter.atividade2.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.unirriter.atividade2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //<Início> Instancia o botão para acessar a atividade GET ALL USERS
        Button getAllUsersBtn = findViewById(R.id.getAllUsersBtn);
        getAllUsersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllUsersActivity.class);
                startActivity(intent);
            }
        });
        //<Final> Instancia o botão para acessar a atividade GET ALL USERS

        //<Início> Instancia o botão para acessar a atividade GET ALL POSTS
        Button getAllPostsBtn = findViewById(R.id.getAllPostsBtn);
        getAllPostsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllPostsActivity.class);
                startActivity(intent);
            }
        });
        //<Final> Instancia o botão para acessar a atividade GET ALL POSTS

        //<Início> Instancia o botão para acessar a atividade GET ALL COMMENTS
        Button getAllCommentsBtn = findViewById(R.id.getAllCommentsBtn);
        getAllCommentsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllCommentsActivity.class);
                startActivity(intent);
            }
        });
        //<Final> Instancia o botão para acessar a atividade GET ALL COMMENTS

        //<Início> Instancia o botão para acessar a atividade GET ALL TO-DO
        Button getToDoListBtn = findViewById(R.id.getToDoListBtn);
        getToDoListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllToDoActivity.class);
                startActivity(intent);
            }
        });
        //<Final> Instancia o botão para acessar a atividade GET ALL TO-DO

        //<Início> Instancia o botão para acessar a atividade GET ALL ALBUMS
        Button getAlbumListBtn = findViewById(R.id.getAlbumsBtn);
        getAlbumListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllAlbumsActivity.class);
                startActivity(intent);
            }
        });
        //<Final> Instancia o botão para acessar a atividade GET ALL ALBUMS
    }
}