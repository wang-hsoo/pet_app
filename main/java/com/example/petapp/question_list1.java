package com.example.petapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class question_list1 extends AppCompatActivity {
    EditText et_name,et_msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list1);
        setTitle("질문 창");

        Button imageButton2 = (Button) findViewById(R.id.btn2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), question_list2.class);
                startActivity(intent);
            }
        });


        final String[] mid = {"질문1", "-> 질문1의 답","질문2","->질문2의 답","질문3","질문3의 답","질문4","질문4의 답","질문5","질문5의 답","질문6"};
        ListView list = (ListView) findViewById(R.id.listView1);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mid);
        list.setAdapter(adapter);


        }



    }

