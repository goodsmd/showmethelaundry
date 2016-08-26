package com.smtl.loginregister.order;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lee on 2016-08-16.
 */
public class ItemRequest extends StringRequest{
    private static final String Item_REQUEST_URL = "http://wbatw2003.cafe24.com/order/Order.php";
    private Map<String, String> params;

    public ItemRequest(String item_startdate, String item_enddate, String item_name, int item_quantity, int how_to_pay, String user_name,
            String user_phone,int item_order, Response.Listener<String> listener) {
        super(Method.POST, Item_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("item_startdate", item_startdate);
        params.put("item_enddate", item_enddate);
        params.put("item_name", item_name);
        params.put("item_quantity", item_quantity+"");
        params.put("how_to_pay", how_to_pay+"");
        params.put("user_name", user_name);
        params.put("user_phone", user_phone);
        params.put("item_order", item_order+"");

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

