package com.mvp.base;

import android.support.v7.app.AppCompatActivity;

import com.mvp.presenter.MvpPresenter;
import com.mvp.ui.MvpView;

/**
 * Created by cfp on 16-4-20.
 */
public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter<V>>
        extends AppCompatActivity {


}
