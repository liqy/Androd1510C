package com.liqy.neihan;

import android.app.IntentService;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.liqy.neihan.bean.User;

/**
 * 内涵段子首页
 * 接口
 * http://lf.snssdk.com/neihan/service/tabs/
 */
public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler=(RecyclerView)findViewById(R.id.recycler);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        recycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        final MyAdapter myAdapter=new MyAdapter();
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(User user, View view,int position) {
                user.name="我被点击了";
                //第一种 全局刷新
//                myAdapter.notifyDataSetChanged();

//                //第二种 单个条目刷新
//                myAdapter.notifyItemChanged(position);
//
//                //第三种 payloads 有数据
                myAdapter.notifyItemChanged(position,user);
//                myAdapter.no

            }
        });
        recycler.setAdapter(myAdapter);



    }



//    IntentService

//    HandlerThread
}
