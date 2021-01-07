package com.martin.training.intentschallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //declaring UI elements
    Button newContact;
    ImageView rating, phone, web, maps;
    String webS, phoneS, mapsS;
    final int activityID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing UI elements
        newContact = findViewById(R.id.createbtn);
        rating = findViewById(R.id.IVrating);
        rating.setVisibility(View.GONE);
        phone = findViewById(R.id.IVphone);
        phone.setVisibility(View.GONE);
        web = findViewById(R.id.IVweb);
        web.setVisibility(View.GONE);
        maps = findViewById(R.id.IVmaps);
        maps.setVisibility(View.GONE);

        newContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act2 = new Intent(MainActivity.this, com.martin.training.intentschallenge.InputActivity.class);
                startActivityForResult(act2, activityID);
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +phoneS));
                startActivity(i);
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" +webS));
                startActivity(i);
            }
        });

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" +mapsS));
                startActivity(i);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == activityID){
            if(resultCode == RESULT_OK){
                if(data.getStringExtra("img_id").equals("happy")){
                    rating.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_alt_24);
                } else if(data.getStringExtra("img_id").equals("satisfied")){
                    rating.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_24);
                } else {
                    rating.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24);
                }
                phoneS = data.getStringExtra("phone");
                webS = data.getStringExtra("web");
                mapsS = data.getStringExtra("maps");

                rating.setVisibility(View.VISIBLE);
                phone.setVisibility(View.VISIBLE);
                web.setVisibility(View.VISIBLE);
                maps.setVisibility(View.VISIBLE);
            }
        }


    }

}