package com.smtl.loginregister.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.smtl.loginregister.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lee on 2016-08-13.
 */
public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Intent intent = getIntent();
        final String item_user_email = intent.getStringExtra("item_user_email");
        final String item_user_name = intent.getStringExtra("item_user_name");
        final String item_user_phone = intent.getStringExtra("item_user_phone");
        final String item_user_address = intent.getStringExtra("item_user_address");

        final Button[] btnMinus = new Button[3];        //마이너스 버튼
        final Integer[] btnMinusID = {R.id.btnMinus1, R.id.btnMinus2, R.id.btnMinus3};
        final Button[] btnPlus = new Button[3];     //플러스 버튼
        final Integer[] btnPlusID = {R.id.btnPlus1, R.id.btnPlus2, R.id.btnPlus3};
        final EditText[] edtItemQuantity = new EditText[3];     //아이템 수량
        final Integer[] edtItemQuantityID = {R.id.edtItemQuantity1, R.id.edtItemQuantity2, R.id.edtItemQuantity3};
        final TextView[] txtItemName = new TextView[3];     //아이템 이름
        final Integer[] txtItemNameID = {R.id.txtItemName1,R.id.txtItemName2,R.id.txtItemName3};
        final Button bItemRegister = (Button) findViewById(R.id.bItemRegister);     //등록하기 버튼

        int i;

        for (i = 0; i < 3; i++) {
            btnMinus[i] = (Button) findViewById(btnMinusID[i]);
            btnPlus[i] = (Button) findViewById(btnPlusID[i]);
            edtItemQuantity[i] = (EditText) findViewById(edtItemQuantityID[i]);
            txtItemName[i]=(TextView)findViewById(txtItemNameID[i]);
        }

        for (i = 0; i < 3; i++) {       // +, - 버튼 눌렀을 때 수량 변하도록
            final int index;
            index = i;

            btnMinus[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int quantity = Integer.parseInt(edtItemQuantity[index].getText().toString());
                    String strQuantity = String.valueOf(quantity);

                    if (quantity == 0) {
                        edtItemQuantity[index].setText(strQuantity);
                    } else {
                        strQuantity = String.valueOf(quantity - 1);
                        edtItemQuantity[index].setText(strQuantity);
                    }
                }
            });
            btnPlus[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int quantity = Integer.parseInt(edtItemQuantity[index].getText().toString());
                    String strQuantity = String.valueOf(quantity + 1);
                    edtItemQuantity[index].setText(strQuantity);
                }
            });
        }

        bItemRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 3; i++) {
                    final int index;
                    index = i;
                    if (Integer.parseInt(edtItemQuantity[index].getText().toString()) != 0) {
                        String item_startdate = "5";
                        String item_enddate = "5";
                        String item_name = txtItemName[index].getText().toString();
                        int item_quantity = Integer.parseInt(edtItemQuantity[index].getText().toString());
                        int how_to_pay = 0;
                        String user_name = item_user_name;
                        String user_phone = item_user_phone;
                        int item_order = 1;

                        Response.Listener<String> responseListener = new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonResponse = new JSONObject(response);
                                    boolean success = jsonResponse.getBoolean("success");
                                    if (success) {
                                        Intent intent = new Intent(ItemActivity.this, ItemDetailActivity.class);
                                        ItemActivity.this.startActivity(intent);
                                    } else {
                                        Toast.makeText(getApplicationContext(),"실패ㅠㅠ",Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        };

                        ItemRequest itemRequest = new ItemRequest(item_startdate, item_enddate, item_name, item_quantity,
                                how_to_pay, user_name, user_phone, item_order, responseListener);
                        RequestQueue queue = Volley.newRequestQueue(ItemActivity.this);
                        queue.add(itemRequest);
                    }
                }


            }
        });

    }
}