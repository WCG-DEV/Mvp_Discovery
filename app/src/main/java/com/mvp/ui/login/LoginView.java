package com.mvp.ui.login;


import com.mvp.ui.MvpLceView;

/**
 * Created by cfp on 16-4-13.
 */
public interface LoginView extends MvpLceView {

    public void showProgress();

    public void hideProgress();

    public void setUserNameError();

    public void setPasswordError();

    public void navigateHome();

}
