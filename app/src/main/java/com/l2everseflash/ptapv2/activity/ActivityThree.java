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

/**
 * Created by User on 4/15/2017.
 */

public class ActivityThree extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        TextView title = (TextView) findViewById(R.id.activityTitle3);
        title.setText("This is ActivityThree");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:
                        Intent intent0 = new Intent(ActivityThree.this, MainActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_news:
                        Intent intent1 = new Intent(ActivityThree.this, ActivityOne.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_sos:
                        Intent intent2 = new Intent(ActivityThree.this, ActivityTwo.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_more:

                        break;


                }


                return false;
            }
        });
    }
}
