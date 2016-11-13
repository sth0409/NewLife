package com.example.sth0409.newlife.Ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.sth0409.newlife.Configer.Configer;
import com.example.sth0409.newlife.Entity.Entity_Data;
import com.example.sth0409.newlife.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;


import java.util.ArrayList;
import java.util.List;



public class CardViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView_CardView;
    private List<Entity_Data> entity_datas;
    MyCardViewAdapter CardViewAdapter;
    private String typeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);
        recyclerView_CardView = (RecyclerView) findViewById(R.id.CardView_recyclerView);
        CardViewAdapter = new MyCardViewAdapter();
        entity_datas=new ArrayList<>();
        recyclerView_CardView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView_CardView.setAdapter(CardViewAdapter);
        loadData();
    }

    private void loadData() {
        for (int i = 0; i < 20; i++) {
            entity_datas.add(new Entity_Data("" + i, "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3306678955,4100526467&fm=111&gp=0.jpg"));
        }
        CardViewAdapter.notifyDataSetChanged();
        OkHttpUtils.post().url(Configer.URL_lIST)
                .addParams("showapi_appid", Configer.showapi_appid)
                .addParams("showapi_sign", Configer.showapi_sign)
                .addParams("type", "type=/category/mengchong")
                .addParams("page", "1")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(okhttp3.Call call, Exception e, int i) {

                    }

                    @Override
                    public void onResponse(String s, int i) {
                        Toast.makeText(CardViewActivity.this, s, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    class MyCardViewAdapter extends RecyclerView.Adapter<MyCardViewAdapter.MyCardViewHolder> {


        @Override
        public MyCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyCardViewHolder myCardViewHolder = new MyCardViewHolder(LayoutInflater.from(CardViewActivity.this).inflate(R.layout.item_cardview, parent, false));
            return myCardViewHolder;
        }

        @Override
        public void onBindViewHolder(MyCardViewHolder holder, int position) {
            holder.tv_title.setText(entity_datas.get(position).tv_title);
            Glide.with(CardViewActivity.this).load(entity_datas.get(position).pic_url).into(holder.pic);
            //  holder.pic
        }

        @Override
        public int getItemCount() {
            return entity_datas.size();
        }

        class MyCardViewHolder extends RecyclerView.ViewHolder {
            TextView tv_title;
            ImageView pic;

            public MyCardViewHolder(View itemView) {
                super(itemView);
                tv_title = (TextView) itemView.findViewById(R.id.tv_title);
                pic = (ImageView) itemView.findViewById(R.id.pic);
            }
        }
    }
}
