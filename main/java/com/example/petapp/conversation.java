package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class conversation extends AppCompatActivity {

    ImageButton home, trainBtn, question, conversation, introduce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        home = findViewById(R.id.home);
        trainBtn =  findViewById(R.id.training);
        question = findViewById(R.id.question);
        conversation = findViewById(R.id.conversation);
        introduce = findViewById(R.id.introduce);

        Button developer_info_btn = (Button) findViewById(R.id.name_activity_sub);
        developer_info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), conversation_list.class);
                startActivity(intent);
            }
        });

        trainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),trainingMain.class);
                startActivity(intent);
            }
        });

        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),question.class);
                startActivity(intent);
            }
        });

        conversation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),conversation.class);
                startActivity(intent);
            }
        });

        introduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),introduce.class);
                startActivity(intent);
            }
        });
    }



}

