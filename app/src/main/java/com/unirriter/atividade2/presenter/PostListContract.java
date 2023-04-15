package com.unirriter.atividade2.presenter;

import com.unirriter.atividade2.models.Post;

import java.util.List;

public interface PostListContract {

    interface View {

        void showLoading();

        void hideLoading();

        void showPosts(List<Post> postList);

        void showError(String message);
    }

    interface Presenter {

        void getPosts();

        void detachView();
    }
}
