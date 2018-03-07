package com.example.acer.demo04;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ACER on 2018/2/25.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private List<People> peopleList;
    private Context context;

    public RecycleAdapter(List<People> peopleList, Context context) {
        this.peopleList = peopleList;
        this.context = context;
    }

    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        ViewHolder holder=new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.ViewHolder holder, int position) {
        holder.ag.setText(peopleList.get(position).getAge());
        holder.na.setText(peopleList.get(position).getName());
        holder.se.setText(peopleList.get(position).getSex());
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView na;
        private final TextView ag;
        private final TextView se;

        public ViewHolder(View itemView) {
            super(itemView);
            na = itemView.findViewById(R.id.na);
            ag = itemView.findViewById(R.id.ag);
            se = itemView.findViewById(R.id.se);
        }
    }
}
