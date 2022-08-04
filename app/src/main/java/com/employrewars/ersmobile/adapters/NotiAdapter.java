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

public class NotiAdapter extends RecyclerView.Adapter<NotiAdapter.viewHolder>{
    ArrayList<String> arrayList;

    public NotiAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public NotiAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.noti_item, parent, false);
        return new NotiAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotiAdapter.viewHolder holder, int position) {
        holder.title.setText(arrayList.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.desc);
        }
    }
}
