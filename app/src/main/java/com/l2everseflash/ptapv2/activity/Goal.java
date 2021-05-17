package com.l2everseflash.ptapv2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.l2everseflash.ptapv2.R;


public class Goal extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);



       Button btn1 = findViewById(R.id.btn_goal1);
       btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent myintent = new Intent(view.getContext(),Information.class);
               view.getContext().startActivities(new Intent[]{myintent});

           }
       });

        Button btn2 =  findViewById(R.id.btn_goal2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(view.getContext(),Information.class);
                view.getContext().startActivities(new Intent[]{myintent});

            }
        });

        Button btn3 =  findViewById(R.id.btn_goal3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(view.getContext(),Welcome_Health.class);
                view.getContext().startActivities(new Intent[]{myintent});

            }
        });



    }

    }



