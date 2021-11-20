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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Introduce extends AppCompatActivity {
    ImageView imgV;
    Button imgBtn;
    ImageButton btnI, btnM;
    LinearLayout intLayout, meLayout;
    private TextView userName, petName, petDate, petVac, petAge;



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
        petAge = findViewById(R.id.petAge);


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

        userName.setText(userN + "님 환영합니다.");
        petName.setText("펫 이름:  " + petN);
        petDate.setText("생년월일" + date);
        petVac.setText("1차 백신" + Vac);


        //펫 나이 구하기
        String getDate = date.substring(0, date.indexOf("년"));


        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat yearformat = new SimpleDateFormat( "yyyy", Locale.getDefault());

        String year = yearformat.format(currentTime);

        String age = Integer.toString(Integer.parseInt(year) - Integer.parseInt(getDate));

        petAge.setText("PET 나이:  " + age + "살");



        //백신 주기 구하기
        











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