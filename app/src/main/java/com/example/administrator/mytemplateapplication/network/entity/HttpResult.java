package com.example.administrator.mytemplateapplication.network.entity;

import com.google.gson.annotations.SerializedName;

import java.security.PrivateKey;

/**
 * Author: TinhoXu
 * E-mail: xth@erongdu.com
 * Date: 2016/4/5 15:23
 * <p/>
 * Description: 网络返回消息，最外层解析实体
 */
@SuppressWarnings("unused")
public class HttpResult<T> {
    /**
     * 升级URL
     */
    @SerializedName(Params.RES_URL)
    private String url;
    /**
     * 错误码
     */
    @SerializedName(Params.RES_CODE)
    private int code;
    /**
     * 错误信息
     */
    @SerializedName(Params.RES_MSG)
    private String msg;
    /**
     * 消息响应的主体
     */
    @SerializedName(Params.RES_DATA)
    private T data;
    //    @SerializedName(Params.RES_PAGE)
    private PageMo page;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public PageMo getPage() {
        return page;
    }

    public void setPage(PageMo page) {
        this.page = page;
    }
}
