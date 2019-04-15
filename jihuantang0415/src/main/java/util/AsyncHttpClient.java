package util;

import android.os.AsyncTask;

import com.google.common.io.ByteStreams;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class AsyncHttpClient {
    private static final AsyncHttpClient ourInstance = new AsyncHttpClient();

    public static AsyncHttpClient getInstance() {
        return ourInstance;
    }

    private AsyncHttpClient() {
    }
    //暴露一个方法
    public void PostData(String url, String name, String password, final CallBack callBack){
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return postAsync(strings[0],strings[1],strings[2]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                callBack.onSuccess(s);
            }
        }.execute(url,name,password);
    }

    private String postAsync(String url, String name, String password) {
        HttpURLConnection connection;
        try {
            URL url1 = new URL(url);
            connection = (HttpURLConnection) url1.openConnection();

            connection.setRequestMethod("POST");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);

            //请求头
            String body = "phone="+URLEncoder.encode(name)+"&password="+URLEncoder.encode(password);
            connection.getOutputStream().write(body.getBytes());
            if (connection.getResponseCode()==200){
                InputStream inputStream = connection.getInputStream();
                String s = new String(ByteStreams.toByteArray(inputStream));
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //定义接口
    public interface CallBack{
        void onError(int code,String msg);
        void onSuccess(String result);
    }
}
