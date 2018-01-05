package com.liqy.androd1510c.view;

import android.os.Bundle;
import android.widget.TextView;

import com.liqy.androd1510c.R;
import com.liqy.androd1510c.base.BaseActivity;
import com.liqy.androd1510c.model.Goods;
import com.liqy.androd1510c.model.HttpResult;
import com.liqy.androd1510c.presenter.GoodsPresenter;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements IGoodsView {

    @BindView(R.id.tv_hello)
    TextView tv_hello;

    GoodsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new GoodsPresenter(this);
        presenter.getData();
    }

    @Override
    public void ok(List<Goods> result) {
        tv_hello.setText(result.toString());
    }

    @Override
    public void failed(String msg) {
        tv_hello.setText(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unBindView();
    }
}
