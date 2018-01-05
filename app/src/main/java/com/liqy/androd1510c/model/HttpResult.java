package com.liqy.androd1510c.model;

import java.util.List;

/**
 * Created by liqy on 2018/1/5.
 */

public class HttpResult<T> {

    public long server_time;
    public T goods_list;
    public List<String> avatars;

    @Override
    public String toString() {
        return "HttpResult{" +
                "server_time=" + server_time +
                ", goods_list=" + goods_list +
                ", avatars=" + avatars +
                '}';
    }
}
