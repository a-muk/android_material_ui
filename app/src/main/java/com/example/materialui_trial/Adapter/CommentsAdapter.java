package com.example.materialui_trial.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialui_trial.Models.CommentModel;
import com.example.materialui_trial.R;
import com.example.materialui_trial.VideosFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {
    Context context;
    ArrayList<CommentModel> arrComments=new ArrayList<>();
    public CommentsAdapter(Context context, ArrayList<CommentModel> arrComments){
        this.context=context;
        this.arrComments=arrComments;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View commentCard=LayoutInflater.from(context).inflate(R.layout.comments_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(commentCard);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.eachIp.setText(arrComments.get(position).ip);
        holder.eachComment.setText(arrComments.get(position).comment);

    }

    @Override
    public int getItemCount() {
        return arrComments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView eachIp,eachComment;
        public ViewHolder(View itemView){
            super(itemView);
            eachIp=itemView.findViewById(R.id.eachIp);
            eachComment=itemView.findViewById(R.id.eachComment);
        }
    }

}
