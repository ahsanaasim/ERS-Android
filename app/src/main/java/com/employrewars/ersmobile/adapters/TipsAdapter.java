package com.employrewars.ersmobile.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.employrewars.ersmobile.R;
import com.employrewars.ersmobile.models.TipsModel;

import java.util.ArrayList;

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.viewHolder>{
    ArrayList<TipsModel> arrayList;

    public TipsAdapter(ArrayList<TipsModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public TipsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tips_item, parent, false);
        return new TipsAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TipsAdapter.viewHolder holder, int position) {
        holder.title.setText(arrayList.get(holder.getAdapterPosition()).getTitle());
        holder.desc.setText(arrayList.get(holder.getAdapterPosition()).getDesc());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView title, desc;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
        }
    }
}
