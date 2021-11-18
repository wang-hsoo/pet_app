package com.example.db;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    //서버URL 설정(PHP 파일 연동)
    final static private String URL = "http://petapp.ivyro.net/Register.php";
    private Map<String, String> map;

    public  RegisterRequest(String userID, String userPassword, String userName, int userAge,  String petName, String petDate, String petVac, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID", userID);
        map.put("userPassword", userPassword);
        map.put("userName", userName);
        map.put("userAge", userAge + "");
        map.put("petName", petName);
        map.put("petDate", petDate);
        map.put("petVac", petVac);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
