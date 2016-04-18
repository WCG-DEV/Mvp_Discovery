package com.mvp.net.api;

import com.mvp.net.GithubUrl;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by cfp on 16-4-18.
 */
public interface GithubApi {

    @GET("/")
    Observable<GithubUrl> getGithubUrl();
}
