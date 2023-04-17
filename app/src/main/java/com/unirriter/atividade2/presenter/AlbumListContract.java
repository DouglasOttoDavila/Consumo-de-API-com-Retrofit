package com.unirriter.atividade2.presenter;

import com.unirriter.atividade2.models.Album;
import com.unirriter.atividade2.models.User;

import java.util.List;

public interface AlbumListContract {

    interface View {

        void showLoading();

        void hideLoading();

        void showAlbums(List<Album> albumList);

        void showError(String message);
    }

    interface Presenter {

        void getAlbums();

        void detachView();
    }
}
