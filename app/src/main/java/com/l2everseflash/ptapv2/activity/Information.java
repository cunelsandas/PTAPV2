package com.l2everseflash.ptapv2.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.l2everseflash.ptapv2.R;
import com.l2everseflash.ptapv2.data.EZSharedPreferences;
import com.l2everseflash.ptapv2.utils.AnimationsUtils;
import com.l2everseflash.ptapv2.utils.HerDaysUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class Information extends BaseActivity {
    private static final String TAG = Information.class.getSimpleName();
    private final Context ctx = Information.this;

    private CardView cvCycleLength;
    private CardView cvMensLength;
    private TextView tvLastPeriod, tvCycleLength, tvMensLength;
    private Button btnContinue;

    private AnimationsUtils anim;

    private String sLastPeriod;
    private String sCycleLength;
    private String sMensLength;
    private Calendar calendarAlarm;

    int flash = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        setupActivity();

    }


    private void setupActivity() {
        initWidgets();
        initListener();
        initData();
    }

    private void initWidgets() {
        CardView cvLastPeriod = (CardView) findViewById(R.id.cvLastPeriod);
        cvCycleLength = (CardView) findViewById(R.id.cvCycleLength);
        cvCycleLength.setVisibility(INVISIBLE);

        cvMensLength = (CardView) findViewById(R.id.cvMensLength);
        cvMensLength.setVisibility(INVISIBLE);

        tvLastPeriod = (TextView) findViewById(R.id.tvLastPeriod);
        tvCycleLength = (TextView) findViewById(R.id.tvCycleLength);
        tvMensLength = (TextView) findViewById(R.id.tvMensLength);

        btnContinue = (Button) findViewById(R.id.btnContinue);

    }

    private void initListener() {
        tvLastPeriod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLastPeriodListener();
            }
        });

        tvCycleLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onCycleLengthListener();
                onCycleSwitch();
            }
        });

        tvMensLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMensLengthListener();
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onContinueListener();
            }
        });
    }

    private void initData() {
        anim = new AnimationsUtils(ctx);
    }

    private void onLastPeriodListener() {

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        final int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        Calendar minDate = Calendar.getInstance();
        minDate.add(Calendar.DAY_OF_YEAR, -28);

        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                Date date = new Date(year - HerDaysUtils.YEAR_DEFAULT, month, day);

                calendarAlarm = Calendar.getInstance();
                calendarAlarm.setTime(date);
                calendarAlarm.add(Calendar.DAY_OF_MONTH, -1);

                Log.d(TAG, "YEAR: " + year);
                SimpleDateFormat format = new  SimpleDateFormat("EEEE, dd MMMM, yyyy", new Locale("en","TH"));
                String formattedDate = format.format(date);

                tvLastPeriod.setText(formattedDate);
                Log.d(TAG, formattedDate);
                sLastPeriod = formattedDate;
                date = new Date(formattedDate);
                Log.d(TAG, "YEAR " + date.getYear());

                if (cvCycleLength.getVisibility() == INVISIBLE) {
                    anim.slideDown(cvCycleLength);
//                    displayHow();
                    cvCycleLength.setVisibility(VISIBLE);
                }

            }
        }, year, month, day);

        dpd.getDatePicker().setMaxDate(new Date().getTime() - 1);
        dpd.getDatePicker().setMinDate(minDate.getTime().getTime());
        dpd.show();

    }

    private void onCycleSwitch() {
        if (flash == 0) {
            displayHow();
        } else
        onCycleLengthListener();
    }

    private void displayHow() {

        String message = "?????????????????????????????????????????????????????????????????????????????????????????????????????? ??? ??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????" +
                "?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????? 28 ????????? ????????????????????????????????????????????????????????????????????? 20 ????????? 45 ?????????";

        AlertDialog.Builder builder = new AlertDialog.Builder(Information.this);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                onCycleLengthListener();
            }
        });
        builder.show();
    }

    private void onCycleLengthListener() {
        /// NumberPicker np = new NumberPicker(ctx, new)//
        //    show();
        final AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle("????????????????????????????????????");
        final EditText text = new EditText(ctx);
        text.setGravity(Gravity.CENTER);
        text.setInputType(InputType.TYPE_CLASS_NUMBER);

        builder.setView(text);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sCycleLength = text.getText().toString();
                tvCycleLength.setText(sCycleLength + " ?????????");

                if (btnContinue.getVisibility() == INVISIBLE) {
                    anim.fadeIn(btnContinue);
                    btnContinue.setVisibility(VISIBLE);
                }

//                if (cvMensLength.getVisibility() == INVISIBLE) {
//                    anim.slideDown(cvMensLength);
//                    cvMensLength.setVisibility(VISIBLE);
//                }
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();


    }

    private void onMensLengthListener() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle("????????????????????????????????????");
        final EditText text = new EditText(ctx);
        text.setGravity(Gravity.CENTER);
        text.setInputType(InputType.TYPE_CLASS_NUMBER);

        builder.setView(text);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sMensLength = text.getText().toString();
                tvMensLength.setText(sMensLength + " ?????????");

                if (btnContinue.getVisibility() == INVISIBLE) {
                    anim.fadeIn(btnContinue);
                    btnContinue.setVisibility(VISIBLE);
                }
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void onContinueListener() {
        HashMap<String, String> map = new HashMap<>();
        map.put(EZSharedPreferences.KEY_DATE, sLastPeriod);
        map.put(EZSharedPreferences.KEY_CYCLE, sCycleLength);
//        map.put(EZSharedPreferences.KEY_MENS, sMensLength);
        EZSharedPreferences.setInformation(ctx, map);
        startActivity(new Intent(ctx, MainActivity.class));
        finish();
    }


}
