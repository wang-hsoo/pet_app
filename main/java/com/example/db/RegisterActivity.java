package com.example.db;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_id, et_pass, et_name, et_age, et_petName, et_petDate,et_petVac, et_passC;
    private Button btn_register;
    CheckBox check1, check2, check3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_petName = findViewById(R.id.et_petName);
        et_petDate = findViewById(R.id.et_petDate);
        et_petVac = findViewById(R.id.et_petVac);
        et_passC = findViewById(R.id.et_passC);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);

        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                //공백 확인
                if (et_id.getText().toString().equals("") || et_pass.getText().toString().equals("") || et_name.getText().toString().equals("") || et_age.getText().toString().equals("")
                        || et_petName.getText().toString().equals("") || et_petDate.getText().toString().equals("") || et_petVac.getText().toString().equals("") || et_passC.getText().toString().equals("") ) {
                    Toast.makeText(getApplicationContext(), "공백부분을 입력해주세요!", Toast.LENGTH_SHORT).show();

                    if (et_id.getText().toString().equals("")) {
                        et_id.setBackground(getResources().getDrawable(R.drawable.redborder));
                    } else {
                        et_id.setBackground(getResources().getDrawable(R.drawable.titleborder));
                    }

                    if (et_pass.getText().toString().equals("")) {
                        et_pass.setBackground(getResources().getDrawable(R.drawable.redborder));
                    } else {
                        et_pass.setBackground(getResources().getDrawable(R.drawable.titleborder));
                    }

                    if (et_name.getText().toString().equals("")) {
                        et_name.setBackground(getResources().getDrawable(R.drawable.redborder));
                    } else {
                        et_name.setBackground(getResources().getDrawable(R.drawable.titleborder));
                    }

                    if (et_age.getText().toString().equals("")) {
                        et_age.setBackground(getResources().getDrawable(R.drawable.redborder));
                    } else {
                        et_age.setBackground(getResources().getDrawable(R.drawable.titleborder));
                    }

                    if (et_petName.getText().toString().equals("")) {
                        et_petName.setBackground(getResources().getDrawable(R.drawable.redborder));
                    } else {
                        et_petName.setBackground(getResources().getDrawable(R.drawable.titleborder));
                    }

                    if (et_petDate.getText().toString().equals("")) {
                        et_petDate.setBackground(getResources().getDrawable(R.drawable.redborder));
                    } else {
                        et_petDate.setBackground(getResources().getDrawable(R.drawable.titleborder));
                    }

                    if (et_petVac.getText().toString().equals("")) {
                        et_petVac.setBackground(getResources().getDrawable(R.drawable.redborder));
                    } else {
                        et_petVac.setBackground(getResources().getDrawable(R.drawable.titleborder));
                    }

                    if (et_passC.getText().toString().equals("")) {
                        et_passC.setBackground(getResources().getDrawable(R.drawable.redborder));
                    } else {
                        et_passC.setBackground(getResources().getDrawable(R.drawable.titleborder));
                    }

                }else if( check1.isChecked() == false || check2.isChecked() == false){

                        if (check1.isChecked() == false){
                            Toast.makeText(getApplicationContext(), "이용약간에 동의에 체크해주세요", Toast.LENGTH_SHORT).show();
                        }else if (check2.isChecked() == false){
                            Toast.makeText(getApplicationContext(), "개인정보 취급 방치 동의에 체크해주세요", Toast.LENGTH_SHORT).show();
                        }

                }else if (et_pass.getText().toString().equals(et_passC.getText().toString())){

                    String userID = et_id.getText().toString();
                    String userPass = et_pass.getText().toString();
                    String userName = et_name.getText().toString();
                    int userAge = Integer.parseInt(et_age.getText().toString());
                    String petName = et_petName.getText().toString();
                    String petDate = et_petDate.getText().toString();
                    String petVac = et_petVac.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {//회원 등록에 성공한 경우
                                Toast.makeText(getApplicationContext(), "회원 등록에 성공하였습니다", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginAtivity.class);
                                startActivity(intent);
                            }else {//회원 등록에 실패한 경우
                                Toast.makeText(getApplicationContext(), "회원 등록에 실패하였습니다", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(), "오류발생", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }

                    }
                };
                //서버로 volley를 이용해서 요청함
                RegisterRequest registerRequest = new RegisterRequest(userID, userPass, userName, userAge, petName, petDate, petVac, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);

            }else {
                    //비밀번호 다를 시 실행
                    Toast.makeText(getApplicationContext(), "비밀번호를 다시 확인해주세요", Toast.LENGTH_SHORT).show();
                    et_pass.setBackground(getResources().getDrawable(R.drawable.redborder));
                    et_passC.setBackground(getResources().getDrawable(R.drawable.redborder));

                }
            }
        });
    }



    //달력가져오기
    public void showDatePicker(View View){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day){
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);


        et_petDate.setText(year +"년 " + month + "월 " + day + "일" );
    }

    public void datepicker(View View){
        DialogFragment newFragment = new datepicker();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void datepickerResult(int year, int month, int day){
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);


        et_petVac.setText(year +"년 " + month + "월 " + day + "일" );
    }


    //뒤로가기
    public void backClick(View view){
        Intent intent = new Intent(RegisterActivity.this, LoginAtivity.class);
        startActivity(intent);
    }
}