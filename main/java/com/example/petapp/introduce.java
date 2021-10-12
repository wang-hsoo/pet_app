package com.example.petapp;

import androidx.annotation.Nullable;
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
import android.widget.ScrollView;
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

}
