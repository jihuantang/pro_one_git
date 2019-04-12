package com.example.mvp_interface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements ILoginView{

    private EditText name,password;
    private Button button;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        loginPresenter = new LoginPresenter();
        loginPresenter.attch(this);
    }

    private void init() {
        name = findViewById(R.id.ed_login_name);
        password = findViewById(R.id.ed_login_password);
        button = findViewById(R.id.login_button);
    }


    @Override
    public void getpresenter(String name) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detch();
    }
}
