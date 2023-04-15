package com.unirriter.atividade2.presenter;

import com.unirriter.atividade2.models.User;

import java.util.List;

public interface UserListContract {

    interface View {

        void showLoading();

        void hideLoading();

        void showUsers(List<User> userList);

        void showError(String message);
    }

    interface Presenter {

        void getUsers();

        void detachView();
    }
}
