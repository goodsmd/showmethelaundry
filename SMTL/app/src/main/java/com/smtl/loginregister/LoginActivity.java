package com.smtl.loginregister;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.smtl.loginregister.order.OrderActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText user_email = (EditText) findViewById(R.id.user_email);
        final EditText user_password = (EditText) findViewById(R.id.user_password);
        final TextView tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        final Button bLogin = (Button) findViewById(R.id.bSignIn);
        final Button btnChart = (Button)findViewById(R.id.btnChart);        //차트 버튼

        btnChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, com.smtl.loginregister.ChartActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });

        tvRegisterLink.setOnClickListener(new View.OnClickListener() {      //회원가입 버튼 누르면 회원가입 창으로
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, com.smtl.loginregister.RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = user_email.getText().toString();
                final String password = user_password.getText().toString();

                // Response received from the server
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {      //로그인 정보가 맞으면
                                String user_email = jsonResponse.getString("user_email");
                                String user_name = jsonResponse.getString("user_name");
                                String user_phone = jsonResponse.getString("user_phone");
                                String user_address = jsonResponse.getString("user_address");
                                int user_who = jsonResponse.getInt("user_who");

                                if (user_who == 0) {        //고객이면
                                    Intent intent = new Intent(LoginActivity.this, OrderActivity.class);
                                    intent.putExtra("in_user_email", user_email);
                                    intent.putExtra("in_user_name", user_name);
                                    intent.putExtra("in_user_phone", user_phone);
                                    intent.putExtra("in_user_address", user_address);
                                    LoginActivity.this.startActivity(intent);
                                } else {        //고객이 아니면 (주인이면)
                                    Toast.makeText(getApplicationContext(),"주인 ㅎㅇ",Toast.LENGTH_SHORT).show();
                                }
                            } else {       //로그인 정보가 맞지않으면
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(email, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}
