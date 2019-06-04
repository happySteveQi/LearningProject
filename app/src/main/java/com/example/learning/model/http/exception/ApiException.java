package com.example.learning.model.http.exception;

/**
 * Time:2019/5/30
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public class ApiException extends Exception {

    private int code;

    public ApiException(String msg){
        super(msg);
    }
    public ApiException(String msg,int code){
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
