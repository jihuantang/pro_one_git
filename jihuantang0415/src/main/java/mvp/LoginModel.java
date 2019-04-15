package mvp;

import util.AsyncHttpClient;

public class LoginModel implements Cotract.IloginModel {

    @Override
    public void getRequest(String url, String name, String password, final CallBack callBack) {
        AsyncHttpClient.getInstance().PostData(url, name, password, new AsyncHttpClient.CallBack() {
            @Override
            public void onError(int code, String msg) {

            }

            @Override
            public void onSuccess(String result) {
                callBack.onSuccess(result);
            }
        });
    }
}
