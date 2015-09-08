package com.ew.roc.net;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * 请求Client
 * Created by WangYuPeng on 9/8/15.
 */
public class EwHttpClient {


    private static AsyncHttpClient client = new AsyncHttpClient();


    /**
     * Get方法
     * <p/>
     * RequestParams params = new RequestParams();
     * params.put("username", "yanbober");
     * params.put("file_pic", new File("test.jpg"));
     * params.put("file_inputStream", inputStream);
     * params.put("file_bytes", new ByteArrayInputStream(bytes));
     *
     * @param url             请求地址
     * @param params          请求参数
     * @param responseHandler 请求结果处理回调
     */
    public static void get(String url, EwRequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(url, params, responseHandler);
    }

    public static void get(String url, Object objParams, AsyncHttpResponseHandler responseHandler) {
        client.get(url, new EwRequestParams(objParams), responseHandler);
    }

    /**
     * Post方法
     * <p/>
     * RequestParams params = new RequestParams();
     * params.put("username", "yanbober");
     * params.put("file_pic", new File("test.jpg"));
     * params.put("file_inputStream", inputStream);
     * params.put("file_bytes", new ByteArrayInputStream(bytes));
     *  @param url             请求地址
     * @param params          请求参数
     * @param responseHandler 请求结果处理回调
     */
    public static void post(String url, EwRequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(url, params, responseHandler);
    }

    public static void post(String url, Object objParams, AsyncHttpResponseHandler responseHandler) {
        client.post(url, new EwRequestParams(objParams), responseHandler);
    }


}
