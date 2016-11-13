package com.example.sth0409.newlife.Entity;

import android.graphics.drawable.Drawable;

/**
 * Created by STH0409 on 2016/10/8.
 */

public class Entity_Data {
    public String tv_title;
    public String pic_url;

    public Entity_Data(String tv_title, String pic_url) {
        this.tv_title = tv_title;
        this.pic_url = pic_url;
    }

    public Entity_Data() {

    }

    public String getTv_title() {
        return tv_title;
    }

    public void setTv_title(String tv_title) {
        this.tv_title = tv_title;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }
}
