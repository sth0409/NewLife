package com.example.sth0409.newlife.Ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.sth0409.newlife.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<String> data;
    int width1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        WindowManager wm1 = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        width1 = wm1.getDefaultDisplay().getWidth();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        initData();
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(new Adapter());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // recyclerView.addItemDecoration(new DividerItemDecoration());
    }

    private void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            data.add(i + "");
        }
    }

    class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(DataActivity.this).inflate(R.layout.iten, parent, false));
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            ViewGroup.LayoutParams params = holder.cardView.getLayoutParams();
            params.height = (int) (100 + Math.random() * 300);
            params.width=width1/2;
            holder.cardView.setLayoutParams(params);
            holder.textView.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            CardView cardView;

            public MyViewHolder(View itemView) {
                super(itemView);
                cardView = (CardView) itemView.findViewById(R.id.cardView);
                textView = (TextView) itemView.findViewById(R.id.textView);
            }
        }
    }

}
