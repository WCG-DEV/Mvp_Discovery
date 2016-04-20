package com.mvp.ui.login;


import com.mvp.net.UserInfo;
import com.mvp.ui.MvpLceView;
import com.mvp.ui.MvpView;

/**
 * Created by cfp on 16-4-13.
 */
public interface LoginView extends MvpView {


    public void showLoading();

    public void hideLoading();

    public void showError();


    public void loginSuccess(UserInfo userInfo);

}
