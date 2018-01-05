package com.liqy.androd1510c.presenter;

import com.liqy.androd1510c.model.Goods;
import com.liqy.androd1510c.model.HttpResult;
import com.liqy.androd1510c.net.RetrofitHelper;
import com.liqy.androd1510c.view.IGoodsView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * ？暂定网络请求
 * Created by liqy on 2018/1/5.
 */

public class GoodsPresenter {

    private IGoodsView goodsView;

    public GoodsPresenter(IGoodsView goodsView) {
        this.goodsView = goodsView;
    }

    /**
     * 获取数据，RxJava
     */
    public void getData() {
        RetrofitHelper.getAPI().avatarsSubjects("3470667255")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HttpResult<List<Goods>>>() {
                    @Override
                    public void accept(HttpResult<List<Goods>> result) throws Exception {
                        if (goodsView != null) {// 异步网络，延迟执行
                            goodsView.ok(result);
                        }
                    }
                });

    }

    public void unBindView() {
        if (goodsView != null) {
            goodsView = null;
        }
    }
}
