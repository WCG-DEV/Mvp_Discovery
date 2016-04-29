package com.mvp.presenter.login;


import android.util.Log;

import com.mvp.net.RequestIntercept;
import com.mvp.net.RetrofitFactory;
import com.mvp.net.UserInfo;
import com.mvp.net.api.GithubApi;
import com.mvp.presenter.MvpBasePresenter;
import com.mvp.ui.login.LoginView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cfp on 16-4-13.
 */
public class LoginPresenter extends MvpBasePresenter<LoginView> {




    public void doLogin(String username) {
        if(isViewAttached()){
            getView().showLoading();
        }

        GithubApi githubApi = (GithubApi) RetrofitFactory.getInstance(GithubApi.class);
        githubApi.getUserInfo(username)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if(isViewAttached()){
                            getView().hideLoading();
                            getView().showError();
                        }
                    }

                    @Override
                    public void onNext(UserInfo userInfo) {
                        Log.d("TAG", userInfo.toString());
                        if(isViewAttached()){
                            getView().hideLoading();
                            getView().loginSuccess(userInfo);
                        }
                    }
                });
    }

}
