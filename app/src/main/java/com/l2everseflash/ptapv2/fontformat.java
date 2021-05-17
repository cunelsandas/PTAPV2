package com.l2everseflash.ptapv2;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by l2eVerseFlash on 2/3/2018.
 */

public class fontformat extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initfont();
    }

    private void initfont() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
        .setDefaultFontPath("fonts/ekkamai.ttf")
        .setFontAttrId(R.attr.fontPath)
        .build());
    }
}
