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
import com.employrewars.ersmobile.activities.ContactUs;
import com.employrewars.ersmobile.activities.PayStubActivity;
import com.employrewars.ersmobile.models.OptionsModel;

import java.util.ArrayList;

public class OptionsAdapter extends RecyclerView.Adapter<OptionsAdapter.viewHolder> {
    ArrayList<OptionsModel> arrayList;
    Context context;
    String extra;

    public OptionsAdapter(ArrayList<OptionsModel> arrayList, Context context, String extra) {
        this.arrayList = arrayList;
        this.context = context;
        this.extra = extra;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.options_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.title.setText(arrayList.get(holder.getAdapterPosition()).getTitle());
        holder.desc.setText(arrayList.get(holder.getAdapterPosition()).getDesc());

        if (!extra.equalsIgnoreCase("Main")){
            holder.iconCard.setVisibility(View.GONE);
            holder.icon1.setVisibility(View.VISIBLE);
            holder.icon1.setImageResource(arrayList.get(holder.getAdapterPosition()).getIcon());
        }else {
            holder.icon.setImageResource(arrayList.get(holder.getAdapterPosition()).getIcon());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (extra.equalsIgnoreCase("Main")){
                    if (holder.title.getText().toString().equals("Contact Us")){
                        Intent intent = new Intent(context, ContactUs.class);
                        context.startActivity(intent);
                    }else if (holder.title.getText().toString().equalsIgnoreCase("Paystub Camera")){
                        Intent intent = new Intent(context, PayStubActivity.class);
                        context.startActivity(intent);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView title, desc;
        ImageView icon,icon1;
        CardView iconCard;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.icon);
            icon1 = itemView.findViewById(R.id.icon1);
            iconCard = itemView.findViewById(R.id.iconCard);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
        }
    }
}
