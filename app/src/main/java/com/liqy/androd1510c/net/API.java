package com.liqy.androd1510c.net;

import com.liqy.androd1510c.model.Goods;
import com.liqy.androd1510c.model.HttpResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by liqy on 2018/1/5.
 */

public interface API {

    @GET("avatars_subjects")
    Observable<HttpResult<List<Goods>>> avatarsSubjects();
}
