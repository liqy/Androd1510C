package com.liqy.neihan.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by liqy on 2018/1/9.
 */

public class Group {


    @SerializedName("360p_video")
    public Media p360_video;

    public String mp4_url;
    public String text;
    public int category_activity_start_time;

    @SerializedName("720p_video")
    public Media p720_video;

    public int digg_count;
    public double duration;

    @SerializedName("480p_video")
    public Media  p480_video;

    public int create_time;
    public String share_url;
    public int go_detail_count;
    public String keywords;
    public long id;
    public int favorite_count;
    public String m3u8_url;
    public Media large_cover;
    public String category_activity_schema_url;
    public int user_favorite;
    public int share_type;
    public String title;
    public String category_activity_text;
    public User user;
    public int is_can_share;
    public int category_type;
    public String download_url;
    public int label;
    public String content;
    public int video_height;
    public int comment_count;
    public String id_str;
    public int media_type;
    public int share_count;
    public int type;
    public int category_id;
    public int status;
    public int has_comments;
    public String publish_time;
    public int user_bury;
    public Media origin_video;
    public String status_desc;
    public int play_count;
    public int user_repin;
    public int category_activity_end_time;
    public Media medium_cover;
    public int user_digg;
    public int video_width;
    public int online_time;
    public String category_name;
    public String flash_url;
    public boolean category_visible;
    public int bury_count;
    public boolean is_anonymous;
    public int repin_count;
    public String video_id;
    public String uri;
    public int is_public_url;
    public int has_hot_comments;
    public int category_show_ranking;
    public String cover_image_uri;
    public int category_is_activity;
    public String cover_image_url;
    public long group_id;
    public int is_video;
    public boolean allow_dislike;
    public int display_type;
    public List<?> dislike_reason;


}
