package com.mvp.ui.following;

import com.mvp.net.UserInfo;
import com.mvp.ui.MvpLceView;
import com.mvp.ui.MvpView;

import java.util.List;

/**
 * Created by cfp on 16-4-29.
 */
public interface FollowingView extends MvpLceView{


    public void showContent(List<UserInfo> followings);




}
