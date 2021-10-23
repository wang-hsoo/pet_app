package com.example.petapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class conversation_list2 extends AppCompatActivity {
    TextView txt_next, txt_next1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation_list2);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("et_name");
        String name1 = intent.getExtras().getString("et_msg");

        txt_next = (TextView) findViewById(R.id.txt_next);
        txt_next.setText(name);
        txt_next = (TextView) findViewById(R.id.txt_next1);
        txt_next.setText(name1);


    }
}


