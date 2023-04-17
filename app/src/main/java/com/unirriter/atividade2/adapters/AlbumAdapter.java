package com.unirriter.atividade2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unirriter.atividade2.R;
import com.unirriter.atividade2.models.Album;
import com.unirriter.atividade2.models.User;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    List<Album> albumList;
    Context context;

    public AlbumAdapter(Context context, List<Album> albums) {
        this.context = context;
        albumList = albums;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.allalbumscard, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.albumUserId.setText("User ID: " + album.getUserId());
        holder.albumId.setText("ID: " + album.getId());
        holder.albumTitle.setText("Title: " + album.getTitle());
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder{
        TextView albumUserId, albumId, albumTitle;
        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);

            albumUserId = itemView.findViewById(R.id.album_user_id);
            albumId = itemView.findViewById(R.id.album_id);
            albumTitle = itemView.findViewById(R.id.album_title);

        }
    }

}
