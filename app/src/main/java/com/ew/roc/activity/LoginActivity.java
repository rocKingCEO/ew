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

                doPostLogin();
                doGetLogin();
                break;

        }
    }


    private void doPostLogin() {

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.email = "roc@qq.com";
        EwHttpClient.post("http://123.57.218.159:8080/HelWeb/LoginServlet", loginRequest, new EwResponseHandler() {
            @Override
            public void onFailure(int statusCode, String response, Throwable var4) {
                Log.d("roc", "onFailure=" + statusCode + "  " + response);
            }

            @Override
            public void onSuccess(int statusCode, String response) {
                Log.d("roc", "" + response);
                Log.d("roc", "statusCode=" + statusCode);
            }

        });
    }

    private void doGetLogin() {

        EwRequestParams params = new EwRequestParams();
        params.put("email", "hez中国@163.com");

        EwHttpClient.get("http://123.57.218.159:8080/HelWeb/LoginServlet", params, new EwResponseHandler() {
            @Override
            public void onFailure(int statusCode, String response, Throwable var4) {
                Log.d("roc", "get onFailure=" + statusCode + "  " + response);
            }

            @Override
            public void onSuccess(int statusCode, String response) {
                Log.d("roc", "get " + response);
                Log.d("roc", "get statusCode=" + statusCode);
            }

            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                Log.d("rocvolley", "进度" + (bytesWritten * 0.1 / totalSize));
            }
        });
    }


}

