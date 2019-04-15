package com.example.jihuantang0415;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import bean.Login;
import mvp.Cotract;
import mvp.LoginPresenter;

public class MainActivity extends BaseActivity implements Cotract.ILoginView {

    private EditText login_ed_name,login_ed_password;
    private Button login,resign;
    private LoginPresenter loginPresenter;
    private String url = "http://172.17.8.100/small/user/v1/login";
    private Login login1;
    private String name;
    private String password;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        init();
        loginPresenter = new LoginPresenter();
        loginPresenter.attch(this);
    }

    private void init() {
        login_ed_name = findViewById(R.id.login_ed_name);
        login_ed_password = findViewById(R.id.login_ed_password);
        login = findViewById(R.id.login);
        resign = findViewById(R.id.resign);

        //登录点击事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取输入框的值
                name = login_ed_name.getText().toString();
                password = login_ed_password.getText().toString();
                //判断是否为空
                if (!name.isEmpty()&&!password.isEmpty()){
                    loginPresenter.getModel(url, name, password);
                }else{
                    Toast.makeText(MainActivity.this,"请输入手机号",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //注册事件
        resign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ResignActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void getPresenter(String data) {
        Gson gson = new Gson();
        login1 = gson.fromJson(data, Login.class);
        if (name.length()<11){
            Toast.makeText(this,"用户名格式不正确/密码错误",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,SelecterActivity.class);
            intent.putExtra("name",name);
            startActivity(intent);
            finish();
        }
    }
}
