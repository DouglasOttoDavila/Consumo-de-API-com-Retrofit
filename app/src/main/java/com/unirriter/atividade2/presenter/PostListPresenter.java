package com.unirriter.atividade2.presenter;

import com.unirriter.atividade2.data.ApiHelper;
import com.unirriter.atividade2.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostListPresenter implements PostListContract.Presenter {

    private PostListContract.View view;
    private ApiHelper apiHelper;

    public PostListPresenter(PostListContract.View view) {
        this.view = view;
        apiHelper = ApiHelper.getInstance();
    }

    @Override
    public void getPosts() {
        view.showLoading();
        apiHelper.getPosts(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                view.hideLoading();
                if (response.isSuccessful()) {
                    List<Post> postList = response.body();
                    view.showPosts(postList);
                } else {
                    view.showError(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                view.hideLoading();
                view.showError(t.getMessage());
            }
        });
    }

    @Override
    public void detachView() {
        view = null;
    }

}
