package com.mvp.net;

import com.mvp.net.api.GithubApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cfp on 16-4-18.
 */
public class RetrofitService {

    public final GithubApi githubApi;

    private final static int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;

    public RetrofitService(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(NetWorkConfig.HTTP_GITHUB)
                .build();

        githubApi = retrofit.create(GithubApi.class);

    }

    public GithubApi getGithubApi(){

        return githubApi;
    }


}
