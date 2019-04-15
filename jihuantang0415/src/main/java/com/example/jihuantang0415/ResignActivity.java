package com.example.jihuantang0415;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import bean.Resign;
import mvp.Cotract;
import mvp.ResignPresenter;

public class ResignActivity extends BaseActivity implements Cotract.ILoginView {

    private EditText resign_ed_name,resign_ed_password,resign_ed_password1;
    private Button login,resign;
    private ResignPresenter resignPresenter;
    private Resign resign1;
    private String url = "http://172.17.8.100/small/user/v1/register";
    private String name;
    private String password;
    private String password1;

    @Override
    protected int initLayout() {
        return R.layout.activity_resign;
    }

    @Override
    protected void initView() {
        init();
        resignPresenter = new ResignPresenter();
        resignPresenter.attch(this);
    }

    private void init() {
        resign_ed_name = findViewById(R.id.resign_ed_name);
        resign_ed_password = findViewById(R.id.resign_ed_password);
        resign_ed_password1 = findViewById(R.id.resign_ed_password1);
        login = findViewById(R.id.login);
        resign = findViewById(R.id.resign);

        //注册事件
        resign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = resign_ed_name.getText().toString();
                password = resign_ed_password.getText().toString();
                password1 = resign_ed_password1.getText().toString();
                if (!name.isEmpty()&&!password.isEmpty()&&name.length()>10){
                    resignPresenter.getModel(url, name, password);
                }else if(password==password1){
                    Toast.makeText(ResignActivity.this,"请检验用户名和密码",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //登录事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResignActivity.this,MainActivity.class);
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
        resign1 = gson.fromJson(data, Resign.class);
        Toast.makeText(ResignActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ResignActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
