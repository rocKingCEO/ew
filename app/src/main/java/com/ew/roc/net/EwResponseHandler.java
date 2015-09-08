package com.ew.roc.net;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.UnsupportedEncodingException;

import org.apache.http.Header;

/**
 * 请求后服务器回应回调
 * Created by WangYuPeng on 9/8/15.
 */
public abstract class EwResponseHandler extends AsyncHttpResponseHandler {
    private static final String LOG_TAG = "StringHttpRH";

    public EwResponseHandler() {
        this("UTF-8");
    }

    public EwResponseHandler(String encoding) {
        this.setCharset(encoding);
    }

    public abstract void onFailure(int statusCode, String response, Throwable var4);

    public abstract void onSuccess(int statusCode, String response);

    public void onSuccess(int statusCode, Header[] headers, byte[] responseBytes) {
        this.onSuccess(statusCode, getResponseString(responseBytes, this.getCharset()));
    }

    public void onFailure(int statusCode, Header[] headers, byte[] responseBytes, Throwable throwable) {
        this.onFailure(statusCode, getResponseString(responseBytes, this.getCharset()), throwable);
    }

    public static String getResponseString(byte[] stringBytes, String charset) {
        try {
            String e = stringBytes == null ? null : new String(stringBytes, charset);
            return e != null && e.startsWith("\ufeff") ? e.substring(1) : e;
        } catch (UnsupportedEncodingException var3) {
            AsyncHttpClient.log.e("TextHttpRH", "Encoding response into string failed", var3);
            return null;
        }
    }

}
