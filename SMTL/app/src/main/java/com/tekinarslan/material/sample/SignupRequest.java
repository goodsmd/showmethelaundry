package com.tekinarslan.material.sample;

/**
 * Created by Lee on 2016-09-18.
 */
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SignupRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://wbatw2003.cafe24.com/login_register/Register.php";
    private Map<String, String> params;

    public SignupRequest(String user_email, String user_password, String user_name, String user_phone, String user_address,
                         Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("user_email", user_email);
        params.put("user_password", user_password);
        params.put("user_name", user_name);
        params.put("user_phone", user_phone);
        params.put("user_address", user_address);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
