package com.mvp.presenter.following;

import com.mvp.net.RetrofitFactory;
import com.mvp.net.UserInfo;
import com.mvp.presenter.MvpBasePresenter;
import com.mvp.ui.following.FollowingView;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cfp on 16-4-29.
 */
public class FollowingPresenter extends MvpBasePresenter<FollowingView>{


    /**
     * 获取用户的Following
     * @param username
     */
    public void getFollowing(String username){

        if(isViewAttached()){
            getView().showLoading(false);
        }

        RetrofitFactory.getGithubSingleton().getFollowings(username)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<UserInfo>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if(isViewAttached()){
                            getView().showError(e, false);
                        }

                    }

                    @Override
                    public void onNext(List<UserInfo> userInfos) {
                        if(isViewAttached()){
                            getView().showContent(userInfos);
                        }
                    }
                });

    }
}
