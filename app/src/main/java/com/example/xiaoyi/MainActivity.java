package com.example.xiaoyi;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);

        list.add(new com.example.xiaoyi.Fragment());
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("姬焕堂","onstart");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.i("姬焕堂","oncreat");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("姬焕堂","onresume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("姬焕堂","onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("姬焕堂","onstop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("姬焕堂","ondestory");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("姬焕堂","onrestart");
    }
}
