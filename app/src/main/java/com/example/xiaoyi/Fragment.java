package com.example.xiaoyi;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment extends android.support.v4.app.Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("姬焕堂1","onattach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("姬焕堂1","oncreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("姬焕堂1","oncreateview");
        return inflater.inflate(R.layout.one,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("姬焕堂1","onviewcreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("姬焕堂1","onactivitycreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("姬焕堂1","onstart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("姬焕堂1","onresume");
    }
}
