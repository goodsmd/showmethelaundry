package com.smtl.loginregister.order;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.smtl.loginregister.R;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Lee on 2016-08-20.
 */
public class ItemDetailActivity extends AppCompatActivity {
    int year, month, day, hour, minute;
    EditText detail_start_date;
    EditText detail_start_time;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detail_start_date = (EditText) findViewById(R.id.detail_start_date);
        detail_start_time = (EditText) findViewById(R.id.detail_start_time);

        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        detail_start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ItemDetailActivity.this, dateSetListener, year, month, day).show();
            }
        });
        detail_start_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(ItemDetailActivity.this, timeSetListener, hour, minute, false).show();
            }
        });
    }

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            String msg = String.format("%d - %d - %d", year, monthOfYear + 1, dayOfMonth);
            detail_start_date.setText(msg);
        }
    };
    TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String msg = String.format("%d : %d", hourOfDay, minute);
            detail_start_time.setText(msg);
        }
    };
}
