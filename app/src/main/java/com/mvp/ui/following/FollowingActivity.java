package com.mvp.ui.following;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mvp.R;
import com.mvp.net.UserInfo;
import com.mvp.presenter.following.FollowingPresenter;
import com.mvp.ui.following.adapter.FollowingRecyclerViewAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class FollowingActivity extends AppCompatActivity implements FollowingView{


    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.ptrFrameLayout)
    PtrFrameLayout ptrFrameLayout;

    private List<UserInfo> followings;
    private FollowingPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_following);
        ButterKnife.bind(this);
        if(mPresenter == null){

            mPresenter = new FollowingPresenter();
        }
        mPresenter.attachView(this);
        mPresenter.getFollowing("chengfangpeng");


    }

    @Override
    public void showContent(List<UserInfo> followings) {
        ptrFrameLayout.refreshComplete();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); //使用线性展示类似于listview

        mRecyclerView.setAdapter(new FollowingRecyclerViewAdapter(this, followings));

        ptrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mRecyclerView,header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mPresenter.getFollowing("chengfangpeng");
            }
        });


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
