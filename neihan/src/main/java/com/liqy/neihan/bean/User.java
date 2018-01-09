package com.liqy.neihan.bean;

import java.util.List;

/**
 * Created by liqy on 2018/1/9.
 */

public class User {
    public boolean is_living;
    public long user_id;
    public String name;
    public int followings;
    public boolean user_verified;
    public int ugc_count;
    public String avatar_url;
    public int followers;
    public boolean is_following;
    public boolean is_pro_user;
    public List<Medal> medals;
}
