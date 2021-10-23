package com.example.petapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;

public class question extends AppCompatActivity {
   Button btn1, btn2, btn3, btn4, btn5, btn6, btn7,btn8;
    private EditText mTodoEdit;
    private TextView mResultTextView;
    SearchView mSearchView;
    ImageButton home, trainBtn, question, conversation, introduce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        setTitle("앱 이름");
        final Button btn1 = (Button) findViewById(R.id.btn1);
        final Button btn2 = (Button) findViewById(R.id.btn2);
        final Button btn3 = (Button) findViewById(R.id.btn3);
        final Button btn8 = (Button) findViewById(R.id.btn8);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        home = findViewById(R.id.home);
        trainBtn =  findViewById(R.id.training);
        question = findViewById(R.id.question);
        conversation = findViewById(R.id.conversation);
        introduce = findViewById(R.id.introduce);


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




        Button imageButton = (Button) findViewById(R.id.btn7);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), question_list1.class);
                startActivity(intent);
            }
        });









        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(question.this);
                dlg.setTitle("재채기를 해요, 기침을 해요");
                dlg.setMessage("1번 질문에 대한 내용");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(question.this);
                dlg.setTitle("간식만 먹고 사료를 잘 먹지 않아요");
                dlg.setMessage("2번 질문에 대한 내용");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(question.this);
                dlg.setTitle("스트레스는 어떻게 풀어주나요");
                dlg.setMessage("3번 질문에 대한 내용");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.show();
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(question.this);
                dlg.setTitle("피부에 문제 생긴 것 같아요");
                dlg.setMessage("4번 질문에 대한 내용");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.show();
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent =new Intent(Intent.ACTION_VIEW, Uri.parse("smsto:010-5537-3440"));
                startActivity(mintent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent =new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/031-721-1470"));
                startActivity(mintent);
            }
        });


    }
}



