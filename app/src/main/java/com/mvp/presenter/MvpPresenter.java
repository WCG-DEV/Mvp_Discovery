package com.mvp.presenter;

import android.support.annotation.UiThread;

import com.mvp.ui.MvpView;


/**
 * Created by cfp on 16-4-13.
 */
public interface MvpPresenter<V extends MvpView> {


    @UiThread
    void attachView(V view);

    @UiThread
    void detachView(boolean retainInstance);
}
