package com.smtl.loginregister;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://wbatw2003.cafe24.com/login_register/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String user_email, String user_password, String user_name, String user_phone, String user_address, int user_who, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("user_email", user_email);
        params.put("user_password", user_password);
        params.put("user_name", user_name);
        params.put("user_phone", user_phone);
        params.put("user_address", user_address);
        params.put("user_who", user_who + "");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
