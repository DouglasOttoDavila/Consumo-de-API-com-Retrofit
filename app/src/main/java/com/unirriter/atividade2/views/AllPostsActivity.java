package com.unirriter.atividade2.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.unirriter.atividade2.R;
import com.unirriter.atividade2.adapters.PostAdapter;
import com.unirriter.atividade2.models.Post;
import com.unirriter.atividade2.presenter.PostListContract;
import com.unirriter.atividade2.presenter.PostListPresenter;

import java.util.List;

public class AllPostsActivity extends AppCompatActivity implements PostListContract.View {

    private RecyclerView recyclerView;
    private PostListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_posts);

        //<Início> Instancia o botão para acessar a atividade MAIN
        Button backToHomeBtn = findViewById(R.id.backToHomeBtn);
        backToHomeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(AllPostsActivity.this, MainActivity.class);
            startActivity(intent);
        });
        //<Final> Instancia o botão para acessar a atividade MAIN

        recyclerView = findViewById(R.id.recyclerViewPosts);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter = new PostListPresenter(this);
        presenter.getPosts();
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
    public void showPosts(List<Post> postList) {
        PostAdapter postAdapter = new PostAdapter(this, postList);
        recyclerView.setAdapter(postAdapter);
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

        /*Button listAllUsers = findViewById(R.id.listAllUsers);
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
                        Toast.makeText(AllPostsActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    List<Post> postList = response.body();
                    PostAdapter postAdapter = new PostAdapter(AllPostsActivity.this, postList);
                    recyclerView.setAdapter(postAdapter);
                }

                @Override
                public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                    Toast.makeText(AllPostsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });*/
}