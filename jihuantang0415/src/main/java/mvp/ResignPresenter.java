package mvp;

import com.example.jihuantang0415.ResignActivity;

public class ResignPresenter implements Cotract.IResignPresenter {

    private LoginModel loginModel;
    private Cotract.ILoginView view;
    @Override
    public void getModel(String url, String name, String password) {
        loginModel.getRequest(url, name, password, new Cotract.IloginModel.CallBack() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(String data) {
                view.getPresenter(data);
            }
        });
    }

    @Override
    public void attch(ResignActivity resignActivity) {
        loginModel = new LoginModel();
        this.view = resignActivity;
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
