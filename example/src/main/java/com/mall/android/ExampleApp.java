package com.mall.android;

import android.app.Application;

import com.example.latte.app.latte;

/**
 * Created by Jsoner on 2017/7/23.
 */

public class ExampleApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        latte.init(this)
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
