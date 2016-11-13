package com.example.sth0409.newlife.Fragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.sth0409.newlife.R;
import com.example.sth0409.newlife.Ui.DataActivity;
import com.example.sth0409.newlife.Ui.CardViewActivity;
import com.example.sth0409.newlife.Ui.WaterfallActivity;

public class Main_fragment extends Fragment implements View.OnClickListener {
private Button button;
    private Button button2;
    Button button3;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      view=inflater.inflate(R.layout.fragment_main,null);
        button= (Button) view.findViewById(R.id.button);
        button2= (Button) view.findViewById(R.id.button2);
        button3= (Button) view.findViewById(R.id.button3);
        button2.setOnClickListener(this);
        button.setOnClickListener(this);
        button3.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.button:
                intent.setClass(getActivity(), WaterfallActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent.setClass(getActivity(), CardViewActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.pop, null);

                PopupWindow popupWindow = new PopupWindow(view1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
                popupWindow.setContentView(view1);
                popupWindow.setBackgroundDrawable(new ColorDrawable());
                popupWindow.setFocusable(true);
                // popupWindow.showAsDropDown(findViewById(R.id.activity_waterfall));

                popupWindow.showAsDropDown(view, Gravity.RIGHT, 0, 0);
                Log.i("dddd", "ssss");
                break;
        }



    }
}
