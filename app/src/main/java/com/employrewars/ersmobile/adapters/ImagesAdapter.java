package com.employrewars.ersmobile.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.employrewars.ersmobile.R;
import com.employrewars.ersmobile.activities.DetailsActivity;
import com.employrewars.ersmobile.models.ImagesModel;

import java.util.ArrayList;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.viewHolder>{
    ArrayList<ImagesModel> arrayList;
    Context context;

    public ImagesAdapter(ArrayList<ImagesModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ImagesAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.images_item, parent, false);
        return new ImagesAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesAdapter.viewHolder holder, int position) {
        holder.icon.setImageResource(arrayList.get(holder.getAdapterPosition()).getImage());
        holder.title.setText(arrayList.get(holder.getAdapterPosition()).getTitle());
        holder.desc.setText(arrayList.get(holder.getAdapterPosition()).getDesc());
        holder.author.setText(arrayList.get(holder.getAdapterPosition()).getAuthor());
        holder.date.setText(arrayList.get(holder.getAdapterPosition()).getDate());
        holder.article.setText(arrayList.get(holder.getAdapterPosition()).getArticle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("title",arrayList.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("desc",arrayList.get(holder.getAdapterPosition()).getDesc());
                intent.putExtra("author",arrayList.get(holder.getAdapterPosition()).getAuthor());
                intent.putExtra("date",arrayList.get(holder.getAdapterPosition()).getDate());
                intent.putExtra("type",arrayList.get(holder.getAdapterPosition()).getArticle());
                intent.putExtra("icon",String.valueOf(arrayList.get(holder.getAdapterPosition()).getImage()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView title, desc, author, date, article;
        ImageView icon;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
            author = itemView.findViewById(R.id.author);
            date = itemView.findViewById(R.id.date);
            article = itemView.findViewById(R.id.type);
            icon = itemView.findViewById(R.id.image);
        }
    }
}
