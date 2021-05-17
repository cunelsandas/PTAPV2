package com.l2everseflash.ptapv2.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.l2everseflash.ptapv2.R;

public class Welcome_Health extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_health);

        Button btn1 = findViewById(R.id.btn_health);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(view.getContext(),medical_id.class);
                view.getContext().startActivities(new Intent[]{myintent});

            }
        });
    }
}
