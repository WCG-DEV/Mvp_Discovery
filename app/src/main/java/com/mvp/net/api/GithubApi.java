package com.mvp.net.api;

import com.mvp.net.RetrofitFactory;
import com.mvp.net.UserInfo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by cfp on 16-4-18.
 */
public interface GithubApi {

    @GET("/users/{username}")
    Observable<UserInfo> getUserInfo(@Path("username") String username);
    @GET("/users/{username}/following")
    Observable<List<UserInfo>> getFollowings(@Path("username") String username);
}
