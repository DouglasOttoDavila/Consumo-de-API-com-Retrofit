package com.unirriter.atividade2.presenter;

import com.unirriter.atividade2.data.ApiHelper;
import com.unirriter.atividade2.models.Album;
import com.unirriter.atividade2.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumListPresenter implements AlbumListContract.Presenter {

    private AlbumListContract.View view;
    private ApiHelper apiHelper;

    public AlbumListPresenter(AlbumListContract.View view) {
        this.view = view;
        apiHelper = ApiHelper.getInstance();
    }

    @Override
    public void getAlbums() {
        view.showLoading();
        apiHelper.getAlbums(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                view.hideLoading();
                if (response.isSuccessful()) {
                    List<Album> albumList = response.body();
                    view.showAlbums(albumList);
                } else {
                    view.showError(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
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
