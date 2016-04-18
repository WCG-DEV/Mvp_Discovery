package com.mvp.ui;

import android.support.annotation.UiThread;

/**
 * Created by cfp on 16-4-13.
 */
public interface MvpLceView<M> extends MvpView {

    @UiThread
    public void showLoading(boolean pullToRefresh);
    @UiThread
    public void showContent();
    @UiThread
    public void showError(Throwable e, boolean pullToRefresh);
    @UiThread
    public void setData(M data);

    @UiThread
    public void loadData(boolean pullToRefresh);
}
