package com.smtl.loginregister;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by MOO DOL on 2016-08-19.
 */
public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {      //로그인 정보가 맞으면
                        int field1 = jsonResponse.getInt("field1");
                        int field2 = jsonResponse.getInt("field2");
                        int field3 = jsonResponse.getInt("field3");
                        int field4 = jsonResponse.getInt("field4");
                        LineChart lineChart = (LineChart) findViewById(R.id.chart);

                        ArrayList<Entry> entries = new ArrayList<>();
                        entries.add(new Entry(field1, 0));
                        entries.add(new Entry(field2, 1));
                        entries.add(new Entry(field3, 2));
                        entries.add(new Entry(field4, 3));


                        LineDataSet dataset = new LineDataSet(entries, "# of Calls");

                        ArrayList<String> labels = new ArrayList<String>();
                        labels.add("4월");
                        labels.add("5월");
                        labels.add("6월");
                        labels.add("7월");


                        LineData data = new LineData(labels, dataset);
                        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
                        dataset.setDrawCubic(true);
                        dataset.setDrawFilled(true);

                        lineChart.setData(data);
                        lineChart.animateY(5000);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        ChartRequest chartRequest = new ChartRequest(responseListener);
        RequestQueue queue = Volley.newRequestQueue(ChartActivity.this);
        queue.add(chartRequest);



    }
}
