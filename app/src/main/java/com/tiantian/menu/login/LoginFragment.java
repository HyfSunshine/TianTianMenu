package com.tiantian.menu.login;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tiantian.menu.R;
import com.tiantian.menu.ui.MainActivity;

/**
 * Created by Administrator - stick on 2017/12/7.
 * e-mail:253139409@qq.com
 * desc:负责初始化UI和接受Presenter指令来刷新UI。
 */

public class LoginFragment extends Fragment implements LoginContract.View {


    private EditText username,password;
    private Button btn_register,btn_login;
    private LoginContract.Presenter loginPresenter;

    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_login,container,false);
        username = root.findViewById(R.id.et_username);
        password = root.findViewById(R.id.et_password);
        btn_login = root.findViewById(R.id.btn_login);
        btn_register = root.findViewById(R.id.btn_register);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.login(getUserName(),getPassword());
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearUserName();
                clearPassword();
            }
        });

        return root;
    }


    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.loginPresenter = presenter;
    }

    @Override
    public String getUserName() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void clearUserName() {
        username.setText("");
    }

    @Override
    public void clearPassword() {
        password.setText("");
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hiddenLoading() {

    }

    @Override
    public void toMainActivity() {
        MainActivity.start(getActivity());
    }

    @Override
    public void showFailedError() {
        Toast.makeText(getActivity(),"login failed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
