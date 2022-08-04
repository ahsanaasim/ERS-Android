package com.employrewars.ersmobile.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.employrewars.ersmobile.MainActivity;
import com.employrewars.ersmobile.R;
import com.employrewars.ersmobile.adapters.OptionsAdapter;
import com.employrewars.ersmobile.databinding.ActivityContactUsBinding;
import com.employrewars.ersmobile.models.OptionsModel;

import java.util.ArrayList;

public class ContactUs extends AppCompatActivity {
    ActivityContactUsBinding binding;
    ArrayList<OptionsModel> optionsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityContactUsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        optionsArrayList = new ArrayList<>();
        dataToNaviAdapter();

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    private void dataToNaviAdapter(){
        OptionsModel optionsModel = new OptionsModel(R.drawable.ic_email,"Email Us",getString(R.string.contact));
        optionsArrayList.add(optionsModel);
        OptionsModel optionsModel1 = new OptionsModel(R.drawable.ic_phone,"Call Us",getString(R.string.phone));
        optionsArrayList.add(optionsModel1);
        OptionsModel optionsModel2 = new OptionsModel(R.drawable.ic_web,"Visit our webpage",getString(R.string.web));
        optionsArrayList.add(optionsModel2);

        binding.contactRecycler.setLayoutManager(new LinearLayoutManager(ContactUs.this));
        OptionsAdapter optionsAdapter = new OptionsAdapter(optionsArrayList,ContactUs.this,"");
        binding.contactRecycler.setAdapter(optionsAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}