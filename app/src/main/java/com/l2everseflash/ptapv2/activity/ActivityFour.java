package com.l2everseflash.ptapv2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.l2everseflash.ptapv2.BottomNavigationViewHelper;
import com.l2everseflash.ptapv2.R;


public class ActivityFour extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        TextView title = (TextView) findViewById(R.id.activityTitle4);
        title.setText("This is Activityfour");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:
                        Intent intent0 = new Intent(ActivityFour.this, MainActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_news:
                        Intent intent1 = new Intent(ActivityFour.this, ActivityOne.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_sos:
                        Intent intent2 = new Intent(ActivityFour.this, ActivityTwo.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_more:
                        Intent intent3 = new Intent(ActivityFour.this, ActivityThree.class);
                        startActivity(intent3);
                        break;

                }


                return false;
            }
        });
    }
}
