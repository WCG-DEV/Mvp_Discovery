package com.mvp.presenter;

import android.support.annotation.Nullable;
import android.support.annotation.UiThread;


import com.mvp.ui.MvpView;

import java.lang.ref.WeakReference;

/**
 * Created by cfp on 16-4-13.
 */
public class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V>{


    private WeakReference<V> viewRef;

    @UiThread
    @Override
    public void attachView(V view) {

        viewRef = new WeakReference<V>(view);
    }
    @UiThread
    @Nullable
    public V getView(){

        return viewRef == null ? null : viewRef.get();
    }

    public boolean isViewAttached(){
        return viewRef != null && viewRef.get() != null;
    }

    @Override
    public void detachView(boolean retainInstance) {
        if(viewRef != null){
            viewRef.clear();
            viewRef = null;
        }
    }
}
