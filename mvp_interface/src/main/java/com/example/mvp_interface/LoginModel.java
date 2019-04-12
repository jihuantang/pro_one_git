package com.example.mvp_interface;

public class LoginModel implements ILoginModel {
    @Override
    public void login(CallBack callBack) {
        String name = "努力学会，升班";
        callBack.onSuccess(name);
    }
}
