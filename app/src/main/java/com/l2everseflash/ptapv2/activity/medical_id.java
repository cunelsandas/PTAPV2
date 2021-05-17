package com.l2everseflash.ptapv2.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.l2everseflash.ptapv2.R;
import com.l2everseflash.ptapv2.utils.HerDaysUtils;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class medical_id extends AppCompatActivity implements View.OnClickListener {

    EditText selectDate, selectWeight;
    private int mYear, mMonth, mDay, mWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medical_id);

        selectDate = (EditText) findViewById(R.id.input_dob);
        selectDate.setOnClickListener(this);

        selectWeight = (EditText) findViewById(R.id.input_weight);

    }

    @Override
    public void onClick(View v) {
        if (v == selectDate) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            selectDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();

            }

        }
    }
