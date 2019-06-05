package com.example.learning.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learning.App;
import com.example.learning.R;

/**
 * Time:2019/5/31
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public class ToastUtils {

   private ToastUtils mSingleTon = null;

   private ToastUtils(){}

    private static class SingletonHolder{
        private static ToastUtils instance = new ToastUtils(App.getInstance());
    }

    public static ToastUtils getSingleton() {
        return SingletonHolder.instance;
    }

    Context context;
    String msg;
    Toast toast;

    public ToastUtils(Context context){
        this.context = context;
    }

    public void showToast(String text){
        if (toast == null){
            toast = createToast();
        }
        TextView tvMsg = toast.getView().findViewById(R.id.tv_toast_msg);
        tvMsg.setText(text);
        toast.show();
    }

    private Toast createToast(){
        View contentView = View.inflate(context, R.layout.dialog_toast,null);
        TextView tvMsg = contentView.findViewById(R.id.tv_toast_msg);
        toast = new Toast(context);
        toast.setView(contentView);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        tvMsg.setText(msg);
        return toast;
    }
}
