package com.example.petapp;


import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    //서버 URL 설정(PHP 파일 연동)
    final static private String URL = "http://petapp.ivyro.net/Login.php";
    private Map<String, String> map;

    public LoginRequest(String userID, int userPW, Response.Listener<String>listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID", userID);
        map.put("userPW", userPW + "");


    }

    @Override
    protected Map<String, String> getPostParams() throws AuthFailureError {
        return map;
    }
}



