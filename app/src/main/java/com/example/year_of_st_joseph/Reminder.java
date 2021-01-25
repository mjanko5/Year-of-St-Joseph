package com.example.year_of_st_joseph;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Reminder extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder);

        recyclerView = findViewById(R.id.reminderRecyclerView);
    }


    //Called when add(+) button clicked
    public void addReminder(View view) {
        Intent intent = new Intent(this, CreateReminder.class);
        startActivity(intent);
    }

}