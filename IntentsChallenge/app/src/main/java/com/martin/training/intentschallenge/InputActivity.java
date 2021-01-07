package com.martin.training.intentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity implements View.OnClickListener {
    //declaring variables
    EditText name, phone, web, maps;
    ImageView happy, satisfied, sad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        //initializing
        name = findViewById(R.id.PTname);
        phone = findViewById(R.id.PTnum);
        web = findViewById(R.id.PTweb);
        maps = findViewById(R.id.PTmaps);

        happy = findViewById(R.id.IVhappy);
        satisfied = findViewById(R.id.IVsatisfied);
        sad = findViewById(R.id.IVsad);

        happy.setOnClickListener(this);
        satisfied.setOnClickListener(this);
        sad.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if((name.getText().toString().isEmpty() || phone.getText().toString().isEmpty() || web.getText().toString().isEmpty() || maps.getText().toString().isEmpty())){
            Toast.makeText(this, "enter all the information",Toast.LENGTH_SHORT).show();
        } else{
            Intent info = new Intent();
            info.putExtra("name", name.getText().toString().trim())
                    .putExtra("phone", phone.getText().toString().trim())
                    .putExtra("web", web.getText().toString().trim())
                    .putExtra("maps", maps.getText().toString().trim());
            //changes according to icon clicked
            if(v.getId()== R.id.IVhappy){
                info.putExtra("img_id", "happy");
            } else if(v.getId()== R.id.IVsatisfied){
                info.putExtra("img_id", "satisfied");
            } else if(v.getId()== R.id.IVsad){
                info.putExtra("img_id", "sad");
            }
            setResult(RESULT_OK, info);
            InputActivity.this.finish();
        }
    }
}