package com.example.sth0409.newlife;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import com.example.sth0409.newlife.Fragment.Main_fragment;
import com.example.sth0409.newlife.View.ObservableScrollView;

public class MainActivity extends FragmentActivity implements ObservableScrollView.Callbacks {
    private LinearLayout layout1;
    private LinearLayout layout2;
    private ObservableScrollView observableScrollView;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        Fragment fragment = new Main_fragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout, fragment);
        fragmentTransaction.commit();
        initWeiget();
        setScrollView();
    }

    private void setScrollView() {
        observableScrollView.setCallbacks(this);
        observableScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                onScrollChanged(observableScrollView.getScrollY());
            }
        });

    }

    private void initWeiget() {
        layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout2 = (LinearLayout) findViewById(R.id.layout2);
        observableScrollView = (ObservableScrollView) findViewById(R.id.scroll_View);
    }

    @Override
    public void onScrollChanged(int scrollY) {
        layout2.setTranslationY(Math.max(layout1.getTop(), scrollY));

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent() {

    }
}
