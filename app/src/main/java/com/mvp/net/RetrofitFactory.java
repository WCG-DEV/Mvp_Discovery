package com.mvp.net;

import android.support.annotation.Nullable;

import com.mvp.net.api.GithubApi;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;

/**
 * Created by cfp on 16-4-18.
 */
public class RetrofitFactory {

    private static Map<Class<?>, Object> INSTANCES_MAP =
            new HashMap<Class<?>, Object>();

    public RetrofitFactory() {
    }

    public synchronized static <S> S getInstance(Class<S> instanceClass) {
        if (INSTANCES_MAP.containsKey(instanceClass)) {
            return (S) INSTANCES_MAP.get(instanceClass);
        } else {
            S instance = new RetrofitService().createService(instanceClass);
            INSTANCES_MAP.put(instanceClass, instance);
            return instance;
        }
    }
}
