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
import android.widget.RadioButton;
import android.widget.Toast;
import java.util.GregorianCalendar;
import android.widget.DatePicker;


import com.example.petapp.R;

public class membership extends AppCompatActivity {
    LinearLayout user1;
    LinearLayout user2;
    EditText edit_name;
    EditText edit_age;
    RadioButton m;
    RadioButton g;
    Button send;
    View radioGroup;
    EditText vaccine;


    //이미지 뷰, 메뉴누르면 전환
    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membership);

        edit_name = findViewById(R.id.edit_name);
        edit_age = findViewById(R.id.edit_age);
        m = findViewById(R.id.m);
        g = findViewById(R.id.g);
        send = findViewById(R.id.send);
        radioGroup = findViewById(R.id.radioGroup);
        vaccine = findViewById(R.id.vaccine);




        send.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void onClick(View v) {
                if (edit_name.length() == 0 || edit_age.length() == 0 || vaccine.length() == 0) {
                    Toast.makeText(getApplicationContext(), "공백부분을 입력해주세요!", Toast.LENGTH_SHORT).show();
                    if (edit_name.length() == 0) {
                        edit_name.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    } else {
                        edit_name.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    }

                    if (edit_age.length() == 0) {
                        edit_age.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    } else {
                        edit_age.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    }
                    if (vaccine.length() == 0) {
                        vaccine.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    } else {
                        vaccine.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    }

                } else {

                }
            }

        });
    }


}


