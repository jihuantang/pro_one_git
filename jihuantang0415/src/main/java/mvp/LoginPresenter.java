package mvp;

import com.example.jihuantang0415.MainActivity;
import com.example.jihuantang0415.ResignActivity;

public class LoginPresenter implements Cotract.ILoginPresenter {

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
    public void attch(MainActivity mainActivity) {
        loginModel = new LoginModel();
        this.view = mainActivity;
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
