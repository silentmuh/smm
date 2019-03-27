package com.hegg.springboot.common;

public class MyResponse <T>{
    private String code;
    private String msg;
    private String error;
    private T data;

    public MyResponse() {

    }
    public MyResponse(String code, String msg, String error, T data) {
        this.code = code;
        this.msg = msg;
        this.error = error;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
