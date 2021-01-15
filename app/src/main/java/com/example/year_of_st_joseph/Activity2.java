package com.example.year_of_st_joseph;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

public class Activity2 extends AppCompatActivity {

    ImageView image_on_a2;
    TextView devotion, description, content;

    String data1, data2, data3;
    int picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        image_on_a2 = findViewById(R.id.picture_2);
        devotion = findViewById(R.id.devotion_2);
        description = findViewById(R.id.description_2);
        content = findViewById(R.id.content_2);

        //set to scrollable
        content.setMovementMethod(new ScrollingMovementMethod());

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("pics") && getIntent().hasExtra("data1") &&
        getIntent().hasExtra("data2") && getIntent().hasExtra("data3")){

            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            data3 = getIntent().getStringExtra("data3");
            picture = getIntent().getIntExtra("pics", 1);

        }
        else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        devotion.setText(data1);
        description.setText(data2);
        content.setText(data3);
        image_on_a2.setImageResource(picture);
    }
}