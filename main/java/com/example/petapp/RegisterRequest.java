package com.example.petapp;


import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    //서버 URL 설정(PHP 파일 연동)
    final static private String URL = "http://petapp.ivyro.net/Resiter.php";
    private Map<String, String> map;

    public RegisterRequest(String userName, String petName, String userID, String userPW, String petAge, String petBir, String petVac, Response.Listener<String>listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID", userID);
        map.put("userName", userName);
        map.put("petName", petName);
        map.put("userPW", userPW + "");
        map.put("petAge", petAge + "");
        map.put("petBir", petBir);
        map.put("petVac", petVac);

    }

    @Override
    protected Map<String, String> getPostParams() throws AuthFailureError {
        return map;
    }
}



