package com.liqy.androd1510c.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liqy on 2018/1/5.
 */

public class RetrofitHelper {

    private static Retrofit retrofit;

    private static API api;

    /**
     * 初始化Retrofit 单例模式
     */
    private static Retrofit getRetrofit() {
        //线程安全
        if (retrofit == null) {
            synchronized (RetrofitHelper.class) {
                if (retrofit == null) {

                    OkHttpClient client=new OkHttpClient.Builder()
//                            .addInterceptor() 应用拦截器
//                            .addNetworkInterceptor() 网路拦截器
                            .build();


                    retrofit = new Retrofit.Builder()
                            .baseUrl(Urls.BASE_URL)
                            .client(client)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }

        return retrofit;
    }

    public static API getAPI() {
        if (api == null) {
            synchronized (RetrofitHelper.class) {
                if (api == null) {
                    api = getRetrofit().create(API.class);
                }
            }
        }
        return api;
    }


}
