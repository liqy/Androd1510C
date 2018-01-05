package com.liqy.androd1510c;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.liqy.androd1510c.model.Goods;
import com.liqy.androd1510c.model.HttpResult;
import com.liqy.androd1510c.net.RetrofitHelper;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
    }

    /**
     * 获取数据，RxJava
     */
    private void getData() {
        RetrofitHelper.getAPI().avatarsSubjects("3470667255")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HttpResult<List<Goods>>>() {
                    @Override
                    public void accept(HttpResult<List<Goods>> result) throws Exception {
                        Log.d(getLocalClassName(),result.toString());
                    }
                });

    }
}
