package com.example.year_of_st_joseph;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main extends AppCompatActivity {

    RecyclerView recyclerView;


    public static final String EXTRA_MESSAGE = "Temporary Name";
    String devotions[], descriptions[], content[];
    int pictures[] = {R.drawable.joseph_1, R.drawable.joseph_2, R.drawable.joseph_3, R.drawable.joseph_4};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        recyclerView = findViewById(R.id.recyclerView);

        devotions = getResources().getStringArray(R.array.devotions);
        descriptions = getResources().getStringArray(R.array.descriptions);
        content = getResources().getStringArray(R.array.content);

        RecyclerViewAdapter rva = new RecyclerViewAdapter(this, devotions, descriptions, content, pictures);
        recyclerView.setAdapter(rva);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    //Called when send button clicked
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


    //Called when reminders button clicked
    public void goToReminders(View view) {
        Intent intent = new Intent(this, Reminder.class);
        startActivity(intent);
    }

}