package com.example.mvp_interface;

public interface ILoginPresenter {
    void getModel();

    //绑定
    void attch(ILoginView view);

    //取消绑定
    void detch();
}
