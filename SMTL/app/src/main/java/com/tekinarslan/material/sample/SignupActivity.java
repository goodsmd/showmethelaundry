package com.tekinarslan.material.sample;

/**
 * Created by Lee on 2016-09-18.
 */

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SignupActivity extends AppCompatActivity {
    int who=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final EditText user_email = (EditText) findViewById(R.id.user_email);
        final EditText user_password = (EditText) findViewById(R.id.user_password);
        final EditText user_name = (EditText) findViewById(R.id.user_name);
        final EditText user_phone = (EditText) findViewById(R.id.user_phone);
        final EditText user_address = (EditText) findViewById(R.id.user_address);
        final CheckBox user_who = (CheckBox)findViewById(R.id.user_who);
        final Button bRegister = (Button) findViewById(R.id.bRegister);
        final EditText laundry_name = (EditText) findViewById(R.id.laundry_name);

        user_who.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){        //주인이면 1, 고객이면 0(기본값)
                    who=1;
                    laundry_name.setVisibility(View.VISIBLE);
                }else{
                    laundry_name.setVisibility(View.INVISIBLE);
                }
            }
        });

        bRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String email = user_email.getText().toString();
                final String password = user_password.getText().toString();
                final String name = user_name.getText().toString();
                final String phone = user_phone.getText().toString();
                final String address = user_address.getText().toString();

                if (who == 0) {
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                                    SignupActivity.this.startActivity(intent);

                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                                    builder.setMessage("Register Failed")
                                            .setNegativeButton("Retry", null)
                                            .create()
                                            .show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    SignupRequest signupRequest = new SignupRequest(email, password, name, phone, address, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(SignupActivity.this);
                    queue.add(signupRequest);

                } else if(who == 1) {
                    final String laundryname = laundry_name.getText().toString();

                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                                    SignupActivity.this.startActivity(intent);

                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                                    builder.setMessage("Register Failed")
                                            .setNegativeButton("Retry", null)
                                            .create()
                                            .show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    LaundryRegisterRequest signupRequest = new LaundryRegisterRequest(email, password, name, phone, address, laundryname,
                            responseListener);
                    RequestQueue queue = Volley.newRequestQueue(SignupActivity.this);
                    queue.add(signupRequest);
                }
            }
        });
    }
}
