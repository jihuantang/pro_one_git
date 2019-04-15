package mvp;

import com.example.jihuantang0415.MainActivity;
import com.example.jihuantang0415.ResignActivity;

public interface Cotract {

    interface IloginModel{
        void getRequest(String url,String name,String password,CallBack callBack);
        interface CallBack{
            void onError();
            void onSuccess(String data);
        }
    }
    interface ILoginView{
        void getPresenter(String data);
    }
    interface ILoginPresenter{
        void getModel(String url,String name,String password);
        void attch(MainActivity mainActivity);
        void detch();
    }
    interface IResignPresenter{
        void getModel(String url,String name,String password);
        void attch(ResignActivity resignActivity);
        void detch();
    }
}
