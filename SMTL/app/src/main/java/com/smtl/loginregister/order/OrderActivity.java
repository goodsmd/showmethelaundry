package com.smtl.loginregister.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.smtl.loginregister.R;

public class OrderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        final String in_user_email = intent.getStringExtra("in_user_email");
        final String in_user_name = intent.getStringExtra("in_user_name");
        final String in_user_phone = intent.getStringExtra("in_user_phone");
        final String in_user_address = intent.getStringExtra("in_user_address");

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

        bOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itemIntent = new Intent(OrderActivity.this, ItemActivity.class);
                itemIntent.putExtra("item_user_email", in_user_email);
                itemIntent.putExtra("item_user_name", in_user_name);
                itemIntent.putExtra("item_user_phone", in_user_phone);
                itemIntent.putExtra("item_user_address", in_user_address);
                OrderActivity.this.startActivity(itemIntent);

            }
        });
    }
}
