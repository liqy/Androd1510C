package com.liqy.androd1510c.net;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
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
                    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                    OkHttpClient client = new OkHttpClient.Builder()
                            .addInterceptor(new MyInterceptor())
                            .addInterceptor(logging)
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

    /**
     * 添加公共参数拦截器
     */
   static class MyInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl httpUrl = request
                    .url()
                    .newBuilder()
                    .addQueryParameter("pdduid", "3470667255")
                    .build();
            Request requestNew = request
                    .newBuilder()
                    .url(httpUrl)
                    .build();
            return chain.proceed(requestNew);
        }
    }

}
