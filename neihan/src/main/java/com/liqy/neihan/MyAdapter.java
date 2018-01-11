package com.liqy.neihan;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liqy.neihan.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqy on 2018/1/10.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User> list;
    private OnItemClickListener listener;

    public MyAdapter() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new User(i, "用户" + i));
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //整个条目的内容
        binder(holder, position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        if (payloads.isEmpty()){
            super.onBindViewHolder(holder, position, payloads);
        }else {
            //条目某个控件的内容
            MyHolder myHolder=(MyHolder)holder;
            ((MyHolder) holder).hello.setText("局部率新");

        }
    }

    private void binder(RecyclerView.ViewHolder holder, final int position) {
        MyHolder myHolder = (MyHolder) holder;
       final User user = list.get(position);
        myHolder.hello.setText(user.name);
        myHolder.helloId.setText("用户ID:"+user.user_id);

        myHolder.hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(user,v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        TextView hello;
        TextView helloId;

        public MyHolder(View itemView) {
            super(itemView);
            hello = itemView.findViewById(R.id.hello);
            helloId = itemView.findViewById(R.id.helloId);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(User user,View view,int position);
    }

}
