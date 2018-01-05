package com.liqy.androd1510c.model;

import com.google.gson.Gson;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by liqy on 2018/1/5.
 */

@Entity
public class Goods {

    @Id(autoincrement = true)
    public Long id;

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

    @Generated(hash = 326302961)
    public Goods(Long id, String goods_sn, int goods_id, String goods_name,
            String short_name, int is_onsale, String thumb_url, String hd_thumb_url,
            int price, String image_url, int market_price, int sales, String logo,
            int is_app, int event_type, int customer_num, int normal_price,
            String country, int goods_type, int has_mall_coupon) {
        this.id = id;
        this.goods_sn = goods_sn;
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.short_name = short_name;
        this.is_onsale = is_onsale;
        this.thumb_url = thumb_url;
        this.hd_thumb_url = hd_thumb_url;
        this.price = price;
        this.image_url = image_url;
        this.market_price = market_price;
        this.sales = sales;
        this.logo = logo;
        this.is_app = is_app;
        this.event_type = event_type;
        this.customer_num = customer_num;
        this.normal_price = normal_price;
        this.country = country;
        this.goods_type = goods_type;
        this.has_mall_coupon = has_mall_coupon;
    }

    @Generated(hash = 1770709345)
    public Goods() {
    }

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

    public String getGoods_sn() {
        return this.goods_sn;
    }

    public void setGoods_sn(String goods_sn) {
        this.goods_sn = goods_sn;
    }

    public int getGoods_id() {
        return this.goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return this.goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getShort_name() {
        return this.short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public int getIs_onsale() {
        return this.is_onsale;
    }

    public void setIs_onsale(int is_onsale) {
        this.is_onsale = is_onsale;
    }

    public String getThumb_url() {
        return this.thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public String getHd_thumb_url() {
        return this.hd_thumb_url;
    }

    public void setHd_thumb_url(String hd_thumb_url) {
        this.hd_thumb_url = hd_thumb_url;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getMarket_price() {
        return this.market_price;
    }

    public void setMarket_price(int market_price) {
        this.market_price = market_price;
    }

    public int getSales() {
        return this.sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getIs_app() {
        return this.is_app;
    }

    public void setIs_app(int is_app) {
        this.is_app = is_app;
    }

    public int getEvent_type() {
        return this.event_type;
    }

    public void setEvent_type(int event_type) {
        this.event_type = event_type;
    }

    public int getCustomer_num() {
        return this.customer_num;
    }

    public void setCustomer_num(int customer_num) {
        this.customer_num = customer_num;
    }

    public int getNormal_price() {
        return this.normal_price;
    }

    public void setNormal_price(int normal_price) {
        this.normal_price = normal_price;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getGoods_type() {
        return this.goods_type;
    }

    public void setGoods_type(int goods_type) {
        this.goods_type = goods_type;
    }

    public int getHas_mall_coupon() {
        return this.has_mall_coupon;
    }

    public void setHas_mall_coupon(int has_mall_coupon) {
        this.has_mall_coupon = has_mall_coupon;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
