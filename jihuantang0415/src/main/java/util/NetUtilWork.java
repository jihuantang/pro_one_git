package util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetUtilWork {
    public static boolean isconn(Context context){
        ConnectivityManager manager;
        manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        if (info!=null){
            Toast.makeText(context,"有网络",Toast.LENGTH_SHORT).show();
            return true;
        }else{
            Toast.makeText(context,"没有网络",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
