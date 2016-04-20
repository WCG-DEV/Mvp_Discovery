package com.mvp.ui.login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mvp.R;
import com.mvp.net.UserInfo;
import com.mvp.presenter.login.LoginPresenter;
import com.mvp.utils.SystemUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends AppCompatActivity implements LoginView {


    private ProgressDialog progressDialog;
    private LoginPresenter presenter;

    @Bind(R.id.username_et)
    EditText userNameEt;

    @Bind(R.id.userinfo_tv)
    TextView userInfoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        if (presenter == null) {
            presenter = new LoginPresenter();
        }
        presenter.attachView(this);
    }

    @Override
    public void showLoading() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(LoginActivity.this);
        }
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showError() {
        Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(UserInfo userInfo) {
        SystemUtils.hideKeyboard(userNameEt);
        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
        userInfoTv.setText(userInfo.toString());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView(false);
        }
    }


    @OnClick(R.id.login_btn)
    void login() {
        Log.d("TAG", "do login");
        String username = userNameEt.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(LoginActivity.this, R.string.username_not_null, Toast.LENGTH_SHORT).show();
            return;
        }
        presenter.doLogin(username);
    }
}
