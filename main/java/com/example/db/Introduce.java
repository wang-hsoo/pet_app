package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Introduce extends AppCompatActivity {
    ImageView imgV;
    Button imgBtn;
    ImageButton btnI, btnM;
    LinearLayout intLayout, meLayout;
    private TextView userName, petName, petDate, petVac;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        setTitle("소개해요");

        imgV = findViewById(R.id.imgV);
        imgBtn = findViewById(R.id.imgBtn);

        btnI = findViewById(R.id.btnI);
        btnM = findViewById(R.id.btnM);
        intLayout = findViewById(R.id.intLayout);
        meLayout = findViewById(R.id.meLayout);

        userName = findViewById(R.id.userName);
        petName = findViewById(R.id.petName);
        petDate = findViewById(R.id.petDate);
        petVac = findViewById(R.id.petVac);


        //배경 이미지 선택
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
                imgBtn.setVisibility(View.INVISIBLE);
            }
        });
        imgV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }

        });



        //메인 컨텐츠 레이아웃 선택
        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intLayout.setVisibility(View.VISIBLE);
                meLayout.setVisibility(View.INVISIBLE);
            }
        });

        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meLayout.setVisibility(View.VISIBLE);
                intLayout.setVisibility(View.INVISIBLE);
            }
        });


        //디비에 저장된 값 가져오기
        Intent intent = getIntent();

        String userN = intent.getStringExtra("userName");
        String petN = intent.getStringExtra("petName");
        String date = intent.getStringExtra("petDate");
        String Vac = intent.getStringExtra("petVac");

        userName.setText(userN);
        petName.setText(petN);
        petDate.setText(date);
        petVac.setText(Vac);






    }


    //갤러리 사진 이미지 뷰에 넣기
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    imgV.setImageURI(uri);
                }
        }


    }



}