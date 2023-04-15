package com.unirriter.atividade2.presenter;

import com.unirriter.atividade2.data.ApiHelper;
import com.unirriter.atividade2.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListPresenter implements UserListContract.Presenter {

    private UserListContract.View view;
    private ApiHelper apiHelper;

    public UserListPresenter(UserListContract.View view) {
        this.view = view;
        apiHelper = ApiHelper.getInstance();
    }

    @Override
    public void getUsers() {
        view.showLoading();
        apiHelper.getUsers(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                view.hideLoading();
                if (response.isSuccessful()) {
                    List<User> userList = response.body();
                    view.showUsers(userList);
                } else {
                    view.showError(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
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
