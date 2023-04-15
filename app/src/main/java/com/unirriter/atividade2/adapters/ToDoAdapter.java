package com.unirriter.atividade2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unirriter.atividade2.R;
import com.unirriter.atividade2.models.ToDo;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder> {

    List<ToDo> toDoList;
    Context context;

    public ToDoAdapter(Context context, List<ToDo> todos) {
        this.context = context;
        toDoList = todos;
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.alltodocard, parent, false);
        return new ToDoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        ToDo todo = toDoList.get(position);
        holder.userId.setText("User ID: " + todo.getUserId());
        holder.id.setText("Item ID: " + todo.getId());
        holder.title.setText("Title: " + todo.getTitle());
        holder.completed.setText("Completed? " + todo.getCompleted());
    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }

    public class ToDoViewHolder extends RecyclerView.ViewHolder{
        TextView userId, id, title, completed;
        public ToDoViewHolder(@NonNull View itemView) {
            super(itemView);

            userId = itemView.findViewById(R.id.todo_user_id);
            id = itemView.findViewById(R.id.todo_id);
            title = itemView.findViewById(R.id.todo_title);
            completed = itemView.findViewById(R.id.todo_completed);

        }
    }

}
