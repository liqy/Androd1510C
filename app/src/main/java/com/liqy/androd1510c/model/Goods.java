package com.liqy.androd1510c.model;

import com.google.gson.Gson;

/**
 * Created by liqy on 2018/1/5.
 */

public class Goods {

    public String goods_sn;
    public int goods_id;
    public String goods_name;
    public String short_name;
    public int is_onsale;
    public String thumb_url;
    public String hd_thumb_url;
    public int price;
    public String image_url;
    public int market_price;
    public int sales;
    public String logo;
    public int is_app;
    public int event_type;
    public int customer_num;
    public int normal_price;
    public String country;
    public int goods_type;
    public int has_mall_coupon;

    @Override
    public String toString() {
        return "Goods{" +
                "goods_sn='" + goods_sn + '\'' +
                ", goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", short_name='" + short_name + '\'' +
                ", is_onsale=" + is_onsale +
                ", thumb_url='" + thumb_url + '\'' +
                ", hd_thumb_url='" + hd_thumb_url + '\'' +
                ", price=" + price +
                ", image_url='" + image_url + '\'' +
                ", market_price=" + market_price +
                ", sales=" + sales +
                ", logo='" + logo + '\'' +
                ", is_app=" + is_app +
                ", event_type=" + event_type +
                ", customer_num=" + customer_num +
                ", normal_price=" + normal_price +
                ", country='" + country + '\'' +
                ", goods_type=" + goods_type +
                ", has_mall_coupon=" + has_mall_coupon +
                '}';
    }
}
