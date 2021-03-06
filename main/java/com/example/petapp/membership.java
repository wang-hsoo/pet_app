package com.example.petapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

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
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.GregorianCalendar;
import android.widget.DatePicker;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.petapp.R;

import org.json.JSONException;
import org.json.JSONObject;

public class membership extends AppCompatActivity {
    EditText edit_name, pet_name, userId, userPw, userPwCh;
    EditText edit_age, bDate;
    RadioButton m;
    RadioButton g;
    Button send;
    View radioGroup;
    EditText vaccine;
    
    
    public void showDatePicker(View View){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }
    public void datepicker(View View){
        DialogFragment newFragment = new datepicker();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day){
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String yaer_string = Integer.toString(year);


            bDate.setText("??????: " + year +"??? " + month + "??? " + day + "???" );
    }

    public void datepickerResult(int year, int month, int day){
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String yaer_string = Integer.toString(year);


        vaccine.setText("1??? ?????????: " + year +"??? " + month + "??? " + day + "???" );
    }


    //????????? ???, ??????????????? ??????
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
        bDate = findViewById(R.id.bDate);
        pet_name = findViewById(R.id.pet_name);
        userId =findViewById(R.id.userId);
        userPw =findViewById(R.id.userPw);
        userPwCh =findViewById(R.id.userPwCh);
        userId = findViewById(R.id.userId);
        userPw = findViewById(R.id.userPw);







        setTitle("????????????");


        send.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void onClick(View v) {



                if (edit_name.length() == 0 || edit_age.length() == 0 || vaccine.length() == 0 || pet_name.length() == 0 || userId.length() == 0 || userPw.length() == 0 || userPwCh.length() == 0 || bDate.length() == 0 ) {
                    Toast.makeText(getApplicationContext(), "??????????????? ??????????????????!", Toast.LENGTH_SHORT).show();

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

                    if (pet_name.length() == 0) {
                        pet_name.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    } else {
                        pet_name.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    }

                    if (userId.length() == 0) {
                        userId.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    } else {
                        userId.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    }

                    if (userPw.length() == 0) {
                        userPw.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    } else {
                        userPw.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    }

                    if (userPwCh.length() == 0) {
                        userPwCh.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    } else {
                        userPwCh.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    }

                    if (bDate.length() == 0) {
                        bDate.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    } else {
                        bDate.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    }

                } else if( userPw.getText().toString().equals(userPwCh.getText().toString())){

                    String userID = userId.getText().toString();
                    String userPW = userPw.getText().toString();
                    String userName = edit_name.getText().toString();
                    String pName = pet_name.getText().toString();
                    String eAge = edit_age.getText().toString();
                    String bD = bDate.getText().toString();
                    String vac = vaccine.getText().toString();

                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                boolean success = jsonObject.getBoolean("success");
                                if (success){
                                    Toast.makeText(getApplicationContext(), "?????? ????????? ?????????????????????." , Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(membership.this, MainActivity.class);
                                    startActivity(intent);
                                } else{
                                    Toast.makeText(getApplicationContext(), "?????? ????????? ?????????????????????." , Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    };

                    //????????? volley??? ???????????? ?????????
                    RegisterRequest registerRequest = new RegisterRequest(userID, userPW, userName, pName, eAge, bD, vac, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(membership.this);
                    queue.add(registerRequest);




                }else{
                    Toast.makeText(getApplicationContext(), "??????????????? ?????? ??????????????????!", Toast.LENGTH_SHORT).show();
                    userPw.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    userPwCh.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    userId.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    pet_name.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    vaccine.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    edit_age.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    edit_name.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                    bDate.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));

                }



            }

        });
    }


}


