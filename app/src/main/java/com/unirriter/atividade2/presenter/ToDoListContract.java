package com.unirriter.atividade2.presenter;

import com.unirriter.atividade2.models.ToDo;

import java.util.List;

public interface ToDoListContract {

    interface View {

        void showLoading();

        void hideLoading();

        void showToDos(List<ToDo> ToDoList);

        void showError(String message);
    }

    interface Presenter {

        void getToDos();

        void detachView();
    }
}
