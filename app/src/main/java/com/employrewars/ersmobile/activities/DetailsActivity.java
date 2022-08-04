package com.employrewars.ersmobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.employrewars.ersmobile.R;
import com.employrewars.ersmobile.adapters.ViewPagerAdapter;
import com.employrewars.ersmobile.databinding.ActivityDetailsBinding;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding binding;
    String title,desc,author,date,type,icon;
    int[] images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        images = new int[]{R.drawable.image_1, R.drawable.image_2};
        title = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("desc");
        author = getIntent().getStringExtra("author");
        date = getIntent().getStringExtra("date");
        type = getIntent().getStringExtra("type");
        icon = getIntent().getStringExtra("icon");

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        binding.author.setText(author+" | "+date);
        binding.desc.setText(desc);
        binding.type.setText(type);
        binding.title.setText(title);
        binding.viewPager.setAdapter(new ViewPagerAdapter(images,this));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}