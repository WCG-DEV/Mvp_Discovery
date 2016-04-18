package com.mvp.net;

import com.mvp.net.api.GithubApi;

/**
 * Created by cfp on 16-4-18.
 */
public class RetrofitFactory {

    protected static final Object monitor = new Object();

    private static GithubApi githubSingleton = null;

    public static GithubApi getGithubSingleton(){

        synchronized(monitor){

            if (githubSingleton == null){

                githubSingleton = new RetrofitService().getGithubApi();
            }
        }
        return githubSingleton;
    }


}
