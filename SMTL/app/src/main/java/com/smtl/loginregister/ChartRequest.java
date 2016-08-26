package com.smtl.loginregister;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MOO DOL on 2016-08-20.
 */
public class ChartRequest extends StringRequest {

    private static final String CHART_REQUEST_URL = "http://wbatw2003.cafe24.com/Chart/Chart.php";
    private Map<String, String> params;

    public ChartRequest(Response.Listener<String> listener) {
        super(Method.POST, CHART_REQUEST_URL, listener, null);
        params = new HashMap<>();
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}

