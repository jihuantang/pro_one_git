package com.example.jihuantang0415;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelecterActivity extends BaseActivity {

    private Button fanhui;
    private TextView textView;


    @Override
    protected int initLayout() {
        return R.layout.activity_selecter;
    }

    @Override
    protected void initView() {
        fanhui = findViewById(R.id.fanhui);
        textView = findViewById(R.id.text);

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelecterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        textView.setText(name);
    }

    @Override
    protected void initData() {

    }
}
