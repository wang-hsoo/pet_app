package com.example.petapp;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.GregorianCalendar;


import com.example.petapp.R;



public class introduce extends AppCompatActivity {
    ImageView imageView;
    Button button;
    Button userButton1;
    Button userButton2;
    LinearLayout user1Layout, user2Layout;
    ScrollView user1Scroll;
    TextView user_name, pet_name, edit_age, bDate, vaccine;
    ImageButton home;
    ImageButton trainBtn, question, conversation, introduce;


    //이미지 뷰, 메뉴누르면 전환
    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introduce);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        userButton1 = findViewById(R.id.userButton1);
        userButton2 = findViewById(R.id.userButton2);
        user1Layout = findViewById(R.id.user1Layout);
        user2Layout = findViewById(R.id.user2Layouyt);
        user1Scroll = findViewById(R.id.user1Scroll);
        user_name = findViewById(R.id.user_name);
        pet_name = findViewById(R.id.pet_name);
        edit_age = findViewById(R.id.edit_age);
        bDate = findViewById(R.id.bDate);
        vaccine = findViewById(R.id.vaccine);
        home = findViewById(R.id.home);
        trainBtn =  findViewById(R.id.training);
        question = findViewById(R.id.question);
        conversation = findViewById(R.id.conversation);
        introduce = findViewById(R.id.introduce);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
                imageView.setVisibility(View.VISIBLE);
                button.setVisibility(View.GONE);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }

        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }

        });

        userButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user1Scroll.setVisibility(View.VISIBLE);
                user1Layout.setVisibility(View.VISIBLE);
                user2Layout.setVisibility(View.GONE);
            }
        });

        userButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user2Layout.setVisibility(View.VISIBLE);
                user1Layout.setVisibility(View.GONE);
                user1Scroll.setVisibility(View.GONE);
            }
        });

        Intent receive_intent = getIntent();
        String temp = receive_intent.getStringExtra("edit_name");
        String pName = receive_intent.getStringExtra("pet_name");
        String eAge = receive_intent.getStringExtra("edit_age");
        String bD = receive_intent.getStringExtra("bDate");
        String vac = receive_intent.getStringExtra("vaccine");
        user_name.setText(temp);
        pet_name.setText(pName);
        edit_age.setText(eAge);
        bDate.setText(bD);
        vaccine.setText(vac);

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




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    imageView.setImageURI(uri);
                }
        }


    }
}