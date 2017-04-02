package com.att.tsa.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.att.tsa.R;
import com.att.tsa.common.BaseActivity;
import com.att.tsa.home.HomeActivity;
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.etUsername)
    MaterialEditText etUsername;
    @BindView(R.id.etPassword)
    MaterialEditText etPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.tvTroubleSignIn)
    TextView tvTroubleSignIn;
    @BindView(R.id.tvSignUp)
    TextView tvSignUp;
    @BindView(R.id.tvAttUsers)
    TextView tvAttUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnLogin, R.id.tvTroubleSignIn, R.id.tvSignUp, R.id.tvAttUsers})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                HomeActivity.launch(this);
                break;
            case R.id.tvTroubleSignIn:
                break;
            case R.id.tvSignUp:
                break;
            case R.id.tvAttUsers:
                break;
        }
    }
}
