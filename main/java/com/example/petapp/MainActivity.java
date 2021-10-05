package com.example.petapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.widget.RadioButton;
import android.widget.Toast;
import java.util.GregorianCalendar;


import com.example.petapp.R;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;
    Button userButton1;
    Button userButton2;
    LinearLayout user1;
    LinearLayout user2;
    EditText edit_name;
    EditText edit_age;
    RadioButton m;
    RadioButton g;
    EditText edit_b_day;
    Button send;
    View radioGroup;
    EditText vaccine;


    //이미지 뷰, 메뉴누르면 전환
    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        userButton1 = findViewById(R.id.userButton1);
        userButton2 = findViewById(R.id.userButton2);
        user1 = findViewById(R.id.User1);
        user2 = findViewById(R.id.User2);
        edit_name = findViewById(R.id.edit_name);
        edit_age = findViewById(R.id.edit_age);
        m = findViewById(R.id.m);
        g = findViewById(R.id.g);
        edit_b_day = findViewById(R.id.edit_b_day);
        send = findViewById(R.id.send);
        radioGroup = findViewById(R.id.radioGroup);
        vaccine = findViewById(R.id.vaccine);


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
                user1.setVisibility(View.VISIBLE);
                user2.setVisibility(View.GONE);
            }
        });

        userButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user2.setVisibility(View.VISIBLE);
                user1.setVisibility(View.GONE);
            }
        });



        send.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void onClick(View v) {
                if (edit_name.length() == 0 || edit_age.length() == 0 || edit_b_day.length() == 0 || vaccine.length() == 0){
                    Toast.makeText(getApplicationContext(), "공백부분을 입력해주세요!", Toast.LENGTH_SHORT).show();
                    if (edit_name.length() == 0) {
                        edit_name.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    } else {
                        edit_name.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    }

                    if (edit_age.length() == 0 ) {
                        edit_age.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    } else {
                        edit_age.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    }

                    if (edit_b_day.length() == 0) {
                        edit_b_day.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    } else {
                        edit_b_day.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    }
                    if(vaccine.length() == 0){
                        vaccine.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    }else{
                        vaccine.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    }

                } else {

                }
            }

        });
    }

    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    imageView.setImageURI(uri);
                }
        }
    }


    private class radioGroup {
    }
}