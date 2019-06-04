package com.example.learning.model.http.response;

/**
 * Time:2019/5/30
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public class WXHttpResponse<T>{
    private int code;
    private String msg;
    private T newslist;

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

    public T getNewslist() {
        return newslist;
    }

    public void setNewslist(T newslist) {
        this.newslist = newslist;
    }
}
