package com.employrewars.ersmobile.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.employrewars.ersmobile.MainActivity;
import com.employrewars.ersmobile.R;
import com.employrewars.ersmobile.adapters.ImagesAdapter;
import com.employrewars.ersmobile.adapters.OptionsAdapter;
import com.employrewars.ersmobile.databinding.ActivityPayStubBinding;
import com.employrewars.ersmobile.models.ImagesModel;

import java.util.ArrayList;

public class PayStubActivity extends AppCompatActivity {
    ActivityPayStubBinding binding;
    ArrayList<ImagesModel> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPayStubBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        arrayList = new ArrayList<>();
        addData();
    }
    private void addData(){
        arrayList.clear();
        String str = "When You Overthink, Thoughts Run Circles\nAround Your Head And You Find Yourself Stuck In Reverse Unable To Move Forward. More So, You Start Coming Up With Bizarre Ideas That Totally Contradict Each other\n“I’m So Excited for this job interview” Transformas into “I wonder if they liked me” And then mprphs into “Oh, I’m so stupid! I shouldn’t have said that! I’m definitely not getting an offer”\nYou Start Blaming Yourself For Things You Didn't\nDo And Worrying About Scenarios That May Or May Not Happen.\nOverthinking Is Simoly The Act Of Thinkina About Something Too Much Or For Too Long.”";
        ImagesModel imagesModel = new ImagesModel(R.drawable.image_1,"Article","GOV.com","22 july","Ticket to Work | How it Works",str);
        ImagesModel imagesModel1 = new ImagesModel(R.drawable.image_2,"Video","APK.com","26 july","Ticket to Work | How it Works",str);
        ImagesModel imagesModel2 = new ImagesModel(R.drawable.image_1,"Article","GOV.com","23 july","Ticket to Work | How it Works",str);
        arrayList.add(imagesModel);
        arrayList.add(imagesModel1);
        arrayList.add(imagesModel2);

        binding.postsRecycler.setLayoutManager(new LinearLayoutManager(PayStubActivity.this));
        ImagesAdapter imagesAdapter = new ImagesAdapter(arrayList,PayStubActivity.this);
        binding.postsRecycler.setAdapter(imagesAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}