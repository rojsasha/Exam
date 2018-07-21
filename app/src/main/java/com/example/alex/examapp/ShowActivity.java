package com.example.alex.examapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {
    private String text;
    private String [] textArray;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        mListView = findViewById(R.id.listView);
        ArrayList<String> list = new ArrayList<>();
        Intent intent = getIntent();
        if (intent.getBooleanExtra("flag", true)){

        }else {
            if (intent != null){
                textArray = text.split(text);
            }

            if (textArray != null){
                for (int i = 0; i < textArray.length; i++) {
                    list.add(textArray[i]);
                }
            }

        }

        mListView.setAdapter(new ListViewAdapter(this, list));
    }
}
