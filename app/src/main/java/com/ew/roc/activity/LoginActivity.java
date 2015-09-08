package com.ew.roc.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ew.roc.R;
import com.ew.roc.model.LoginRequest;
import com.ew.roc.net.EwHttpClient;
import com.ew.roc.net.EwRequestParams;
import com.ew.roc.net.EwResponseHandler;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.btn_login).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {

            case R.id.btn_login:

                doEwLogin();
                break;

        }
    }




    private void doEwLogin() {

        EwHttpClient.post("http://123.57.218.159:8080/HelWeb/LoginServlet", new LoginRequest(), new EwResponseHandler() {
            @Override
            public void onFailure(int statusCode, String response, Throwable var4) {
                Log.d("roc", "onFailure=" + statusCode + "  " + response);
            }

            @Override
            public void onSuccess(int statusCode, String response) {
                Log.d("roc", "" + response);
                Log.d("roc", "statusCode=" + statusCode);
            }

            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                Log.d("rocvolley", "正在上传-" + (bytesWritten * 0.1 / totalSize));
            }
        });
    }

    private void doBaidu() {

        EwRequestParams params = new EwRequestParams();
        params.put("wd","天天向上");

        EwHttpClient.post("https://www.baidu.com/s?", params, new EwResponseHandler() {
            @Override
            public void onFailure(int statusCode, String response, Throwable var4) {
                Log.d("roc", "onFailure=" + statusCode + "  " + response);
            }

            @Override
            public void onSuccess(int statusCode, String response) {
                Log.d("roc", "" + response);
                Log.d("roc", "statusCode=" + statusCode);
            }

            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                Log.d("rocvolley", "正在上传-" + (bytesWritten * 0.1 / totalSize));
            }
        });
    }


}

