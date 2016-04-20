package com.mvp.ui.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mvp.R;

import butterknife.ButterKnife;

public class UserInfoActivity extends AppCompatActivity implements UserInfoView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ButterKnife.bind(this);
    }

    @Override
    public void showLoading(boolean pullToRefresh) {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {

    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {

    }
}
