package com.unirriter.atividade2.presenter;

import com.unirriter.atividade2.models.Comment;

import java.util.List;

public interface CommentListContract {

    interface View {

        void showLoading();

        void hideLoading();

        void showComments(List<Comment> commentList);

        void showError(String message);
    }

    interface Presenter {

        void getComments();

        void detachView();
    }
}
