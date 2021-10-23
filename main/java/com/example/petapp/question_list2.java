package com.example.petapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class question_list2 extends AppCompatActivity {

    EditText et_name,et_msg;
    ImageView iv;
    Button imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list2);
        setTitle("게시글 작성");

        et_name=(EditText) findViewById(R.id.et_name);
        et_msg=(EditText) findViewById(R.id.et_msg);
        iv=findViewById(R.id.iv);

        imageButton2 = (Button) findViewById(R.id.btn_second);

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "업로드완료", Toast.LENGTH_SHORT).show();

                String temp = et_name.getText().toString();
                String pName = et_msg.getText().toString();


                Intent intent = new Intent(getApplicationContext(), question_list3.class);
                intent.putExtra("et_name", et_name.getText().toString());
                intent.putExtra("et_msg", et_msg.getText().toString());
                startActivity(intent);


            }
        });
    }


    public void clickBtn(View view) {

        Intent intent= new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK) {

                    Uri uri = data.getData();
                    if (uri != null) {
                        iv.setImageURI(uri);
                    }

                } else {
                    Toast.makeText(this, "이미지 선택을 하지 않았습니다.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void clickUpload(View view) {
    }


    public void clickLoad(View view) {
    }
}

