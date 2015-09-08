# ew
一个致力于提高android开发效率的框架，简单好使是目标，一个方法完成get或post请求


//Post请求例子


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

//Get请求例子


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
