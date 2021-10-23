package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class trainingMain extends AppCompatActivity {
    ImageButton home, trainBtn, question, conversation, introduce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingmain);

        ListView listView = findViewById(R.id.listview);
        home = findViewById(R.id.home);
        trainBtn =  findViewById(R.id.training);
        question = findViewById(R.id.question);
        conversation = findViewById(R.id.conversation);
        introduce = findViewById(R.id.introduce);

        List<String> list = new ArrayList<>();
        list.add("강아지 기다려 훈련 기초편");
        list.add("강아지 기다려 훈련 심화편");
        list.add("강아지 배변 훈련 기초편");
        list.add("강아지 배변 훈련 심화편");
        list.add("강아지 배식 훈련 기초편");
        list.add("강아지 배식 훈련 심화편");
        list.add("강아지 수면 훈련 기초편");
        list.add("강아지 수면 훈련 심화편");


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


        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    startActivity(new Intent(trainingMain.this, trainingSub1.class));
                    //리스트 1번
                } else if (position == 1) {
                    startActivity(new Intent(trainingMain.this, trainingSub2.class));
                    //리스트 2번
                }  else if (position ==2) {
                    startActivity(new Intent(trainingMain.this, trainingSub3.class));
                    //리스트 3번
                }

                }
        });




    }

}

