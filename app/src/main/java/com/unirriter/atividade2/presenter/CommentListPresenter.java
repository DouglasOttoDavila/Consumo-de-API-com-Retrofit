package com.unirriter.atividade2.presenter;

import com.unirriter.atividade2.data.ApiHelper;
import com.unirriter.atividade2.models.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentListPresenter implements CommentListContract.Presenter {

    private CommentListContract.View view;
    private ApiHelper apiHelper;

    public CommentListPresenter(CommentListContract.View view) {
        this.view = view;
        apiHelper = ApiHelper.getInstance();
    }

    @Override
    public void getComments() {
        view.showLoading();
        apiHelper.getComments(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                view.hideLoading();
                if (response.isSuccessful()) {
                    List<Comment> commentList = response.body();
                    view.showComments(commentList);
                } else {
                    view.showError(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
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
