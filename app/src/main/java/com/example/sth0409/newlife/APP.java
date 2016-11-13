package com.example.sth0409.newlife;

import android.app.Application;
import android.content.Context;
import android.view.WindowManager;

/**
 * Created by STH0409 on 2016/10/7.
 */

public class APP extends Application {
    @Override
    public void onCreate() {
        /***
         * 获得屏幕宽高
         */
        WindowManager wm1 = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        int width1 = wm1.getDefaultDisplay().getWidth();
        int height1 = wm1.getDefaultDisplay().getHeight();
    }
}
