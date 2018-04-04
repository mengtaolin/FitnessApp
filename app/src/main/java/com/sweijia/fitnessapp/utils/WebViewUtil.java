package com.sweijia.fitnessapp.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.webkit.JsResult;

import com.sweijia.fitnessapp.MainActivity;

/**
 * Created by Administrator on 2018/4/4.
 */

public class WebViewUtil {

    public static void doAlert(Context context, String msg, final JsResult result){
        AlertDialog.Builder b = new AlertDialog.Builder(context);
        b.setTitle("Alert");
        b.setMessage(msg);
        b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                result.confirm();
            }
        });
        b.setCancelable(false);
        b.create().show();
    }
}
