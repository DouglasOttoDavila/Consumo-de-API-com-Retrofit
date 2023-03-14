package com.unirriter.atividade2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    List<Post> postList;
    Context context;

    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        postList = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.allpostscard, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.id.setText("ID: " + post.getId());
        holder.userId.setText("Username: " + post.getUserId());
        holder.title.setText("Title: " + post.getTitle());
        holder.body.setText("Message: " + post.getBody());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        TextView title, id, userId, body;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.post_title);
            id = itemView.findViewById(R.id.post_id);
            userId = itemView.findViewById(R.id.post_user_id);
            body = itemView.findViewById(R.id.post_body);

        }
    }

}
