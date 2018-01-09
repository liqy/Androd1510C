package com.liqy.neihan.bean;

import java.util.List;

/**
 * Created by liqy on 2018/1/9.
 */

public class Media {

    public int width;
    public String uri;
    public int height;
    public List<Url> url_list;

    public static class Url {
        public String url;
    }

}
