package com.smtl.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        Intent intent = getIntent();
        String in_user_email = intent.getStringExtra("in_user_email");
        String in_user_name = intent.getStringExtra("in_user_name");
        String in_user_phone = intent.getStringExtra("in_user_phone");
        String in_user_address = intent.getStringExtra("in_user_address");

        EditText order_user_name = (EditText) findViewById(R.id.order_user_name);
        EditText order_user_address = (EditText) findViewById(R.id.order_user_address);
        EditText order_user_phone = (EditText) findViewById(R.id.order_user_phone);
        EditText item_name = (EditText) findViewById(R.id.item_name);
        EditText start_date = (EditText) findViewById(R.id.start_date);
        EditText laundry_name = (EditText) findViewById(R.id.laundry_name);
        Button bOrder = (Button)findViewById(R.id.bOrder);

        // Display user details
        order_user_name.setText(in_user_name);
        order_user_address.setText(in_user_address);
        order_user_phone.setText(in_user_phone);
    }
}
