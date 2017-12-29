package com.example.administrator.mytemplateapplication.network.exception;


import com.example.administrator.mytemplateapplication.network.entity.HttpResult;

public class ApiException extends RuntimeException {
    private HttpResult result;

    public ApiException(HttpResult result) {
        this.result = result;
    }

    public HttpResult getResult() {
        return result;
    }

    public void setResult(HttpResult result) {
        this.result = result;
    }
}
