package com.unirriter.atividade2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unirriter.atividade2.R;
import com.unirriter.atividade2.models.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    List<User> userList;
    Context context;

    public UserAdapter(Context context, List<User> users) {
        this.context = context;
        userList = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.alluserscard, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.userId.setText(user.getId());
        holder.userName.setText(user.getName());
        holder.userUsername.setText(user.getUsername());
        holder.userPhone.setText(user.getPhone());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        TextView userId, userName, userUsername, userPhone;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            userId = itemView.findViewById(R.id.user_user_id);
            userName = itemView.findViewById(R.id.user_name);
            userUsername = itemView.findViewById(R.id.user_username);
            userPhone = itemView.findViewById(R.id.user_phone);

        }
    }

}
