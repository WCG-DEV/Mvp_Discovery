package com.mvp.net;

import com.mvp.net.api.GithubApi;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cfp on 16-4-18.
 */
public class RetrofitService {

    private final static int DEFAULT_TIMEOUT = 5;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(NetWorkConfig.HTTP_GITHUB)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create());

    public RetrofitService(){

        httpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

    }

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null);
    }

    public static <S> S createService(Class<S> serviceClass, final Interceptor interceptor) {

        Retrofit retrofit ;

        if (interceptor != null) {
            //此处用于添加公共Header 信息
            httpClient.interceptors().add(interceptor);
        }

        retrofit = builder.client(httpClient.build()).build();

        return retrofit.create(serviceClass);

    }


}
