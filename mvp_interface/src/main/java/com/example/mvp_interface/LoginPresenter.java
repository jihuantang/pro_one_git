package com.example.mvp_interface;

import android.util.Log;

public class LoginPresenter implements ILoginPresenter {

    private LoginModel loginModel;
    private ILoginView view;
    @Override
    public void getModel() {

    }

    @Override
    public void attch(final ILoginView view) {
        loginModel = new LoginModel();
        this.view = view;
        loginModel.login(new ILoginModel.CallBack() {
            @Override
            public void onSuccess(String name) {
                view.getpresenter(name);
                Log.i("TAG",name);
            }

            @Override
            public void onError() {

            }
        });

    }

    @Override
    public void detch() {
        if (loginModel!=null){
            loginModel=null;
        }
        if (view!=null){
            view=null;
        }
        System.gc();
    }
}
