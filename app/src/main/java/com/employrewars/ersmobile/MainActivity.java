package com.employrewars.ersmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.employrewars.ersmobile.adapters.NotiAdapter;
import com.employrewars.ersmobile.adapters.OptionsAdapter;
import com.employrewars.ersmobile.adapters.TipsAdapter;
import com.employrewars.ersmobile.databinding.ActivityMainBinding;
import com.employrewars.ersmobile.models.OptionsModel;
import com.employrewars.ersmobile.models.TipsModel;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    LinearLayout rl_footer;
    ArrayList<OptionsModel> optionsArrayList;
    ArrayList<TipsModel> tipsArrayList;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        rl_footer = binding.linear;
        optionsArrayList = new ArrayList<>();
        tipsArrayList = new ArrayList<>();
        arrayList = new ArrayList<>();
        addData();
        dataToNaviAdapter();
        binding.scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (binding.text.getVisibility()== View.VISIBLE){
                    binding.text.setVisibility(View.GONE);
                }else {
                    binding.text.setVisibility(View.VISIBLE);
                }
                //Do something
            }
        });

        binding.navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.nav.setTextColor(getResources().getColor(R.color.white));
                binding.noti.setTextColor(getResources().getColor(R.color.black));
                binding.navigation.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.toolbar_dark)));
                binding.notification.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
                dataToNaviAdapter();
            }
        });
        binding.notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.nav.setTextColor(getResources().getColor(R.color.black));
                binding.noti.setTextColor(getResources().getColor(R.color.white));
                binding.navigation.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
                binding.notification.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.toolbar_dark)));
                dataToNotiAdapter();
            }
        });
    }

    private void addData(){
        TipsModel tipsModel = new TipsModel("Daily Quick Tip","Toggle the navigation to \nsee notifications");
        TipsModel tipsModel1 = new TipsModel("Have new paystubs?","Toggle the navigation to \nsee notifications");
        TipsModel tipsModel2 = new TipsModel("Daily Quick Tip","Go to settings to watch \nthe tour again");
        tipsArrayList.add(tipsModel);
        tipsArrayList.add(tipsModel1);
        tipsArrayList.add(tipsModel2);

        binding.tipsRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        TipsAdapter tipsAdapter = new TipsAdapter(tipsArrayList);
        binding.tipsRecycler.setAdapter(tipsAdapter);
    }

    private void dataToNotiAdapter(){
        arrayList.add("Welcome to ERS Mobile!");
        arrayList.add("Click here to explore the\nPaystub Camera");
        arrayList.add("Test!");

        binding.optionsRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        NotiAdapter notiAdapter = new NotiAdapter(arrayList);
        binding.optionsRecycler.setAdapter(notiAdapter);
    }

    private void dataToNaviAdapter(){
        OptionsModel optionsModel = new OptionsModel(R.drawable.ic_contact_us,"Contact Us",getString(R.string.contact));
        optionsArrayList.add(optionsModel);
        OptionsModel optionsModel1 = new OptionsModel(R.drawable.ic_email,"Paystub Camera",getString(R.string.paystubs));
        optionsArrayList.add(optionsModel1);
        OptionsModel optionsModel2 = new OptionsModel(R.drawable.resources,"Resources",getString(R.string.resources));
        optionsArrayList.add(optionsModel2);

        binding.optionsRecycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        OptionsAdapter optionsAdapter = new OptionsAdapter(optionsArrayList,MainActivity.this,"Main");
        binding.optionsRecycler.setAdapter(optionsAdapter);
    }
}