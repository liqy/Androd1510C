package com.liqy.androd1510c.view;

import com.liqy.androd1510c.model.Goods;
import com.liqy.androd1510c.model.HttpResult;

import java.util.List;

/**
 * Created by liqy on 2018/1/5.
 */

public interface IGoodsView {
    void ok(HttpResult<List<Goods>> result);
    void failed(String msg);
}
