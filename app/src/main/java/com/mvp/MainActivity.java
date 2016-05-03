package com.mvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mvp.ui.following.FollowingActivity;
import com.mvp.ui.login.LoginActivity;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        XGPushManager.registerPush(getApplicationContext(), "cfp", new XGIOperateCallback() {
            @Override
            public void onSuccess(Object o, int i) {
                Log.d("TAG", o.toString());
            }

            @Override
            public void onFail(Object o, int i, String s) {
                Log.e("TAG", s.toString() + " i = " + i);
            }
        });

        //测试热修复
        aPatchTest();



    }

    @OnClick(R.id.login_home_btn)
    void login(){

        Intent intent = new Intent(this, LoginActivity.class);

        startActivity(intent);
    }

    @OnClick(R.id.following_get_btn)
    void getFollowing(){

        Intent intent = new Intent(this, FollowingActivity.class);
        startActivity(intent);

    }

    /**
     * 热修复test
     */
    private void aPatchTest(){

        Toast.makeText(MainActivity.this, "old",Toast.LENGTH_SHORT).show();
    }
}
