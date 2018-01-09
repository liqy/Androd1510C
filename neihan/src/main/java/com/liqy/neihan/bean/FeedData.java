package com.liqy.neihan.bean;

import java.util.List;

/**
 * Created by liqy on 2018/1/9.
 */

public class FeedData<T> {
    public boolean has_more;
    public String tip;
    public boolean has_new_message;
    public double max_time;
    public int min_time;
    public List<T> data;
}
