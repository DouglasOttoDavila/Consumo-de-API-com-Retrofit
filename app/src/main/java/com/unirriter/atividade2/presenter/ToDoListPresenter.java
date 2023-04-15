package com.unirriter.atividade2.presenter;

import com.unirriter.atividade2.data.ApiHelper;
import com.unirriter.atividade2.models.ToDo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ToDoListPresenter implements ToDoListContract.Presenter {

    private ToDoListContract.View view;
    private ApiHelper apiHelper;

    public ToDoListPresenter(ToDoListContract.View view) {
        this.view = view;
        apiHelper = ApiHelper.getInstance();
    }

    @Override
    public void getToDos() {
        view.showLoading();
        apiHelper.getToDos(new Callback<List<ToDo>>() {
            @Override
            public void onResponse(Call<List<ToDo>> call, Response<List<ToDo>> response) {
                view.hideLoading();
                if (response.isSuccessful()) {
                    List<ToDo> toDoList = response.body();
                    view.showToDos(toDoList);
                } else {
                    view.showError(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<ToDo>> call, Throwable t) {
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
