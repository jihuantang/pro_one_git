package com.example.mvp_interface;

public interface ILoginModel {
    void login(CallBack callBack);

    interface CallBack{
        void onSuccess(String name);
        void onError();
    }
}
