package com.unirriter.atividade2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unirriter.atividade2.models.Comment;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    List<Comment> commentList;
    Context context;

    public CommentAdapter(Context context, List<Comment> comments) {
        this.context = context;
        commentList = comments;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.allcommentscard, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment comment = commentList.get(position);
        holder.postId.setText("Post ID: " + comment.getPostId());
        holder.id.setText("Comment ID: " + comment.getId());
        holder.name.setText("Name: " + comment.getName());
        holder.email.setText("Email: " + comment.getEmail());
        holder.body.setText("Message: " + comment.getBody());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder{
        TextView postId, id, name, email, body;
        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);

            postId = itemView.findViewById(R.id.comment_post_id);
            id = itemView.findViewById(R.id.comment_id);
            name = itemView.findViewById(R.id.comment_name);
            email = itemView.findViewById(R.id.comment_email);
            body = itemView.findViewById(R.id.comment_body);

        }
    }

}
