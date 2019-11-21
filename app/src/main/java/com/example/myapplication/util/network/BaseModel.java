package com.example.myapplication.util.network;

import com.blankj.utilcode.utils.StringUtils;

import java.io.Serializable;


public class BaseModel<T> implements Serializable {
    public String errorCode;
    public String errorMsg;
    public T result;
    public boolean success;

    private static String SUCCEED_CODE = "00000";

    public boolean isSucceed() {
        return StringUtils.equals(errorCode, "000000") ? true : false;
    }
    @Override
    public String toString() {
        return "BaseModel{" +
                "errorCode='" + errorCode + '\'' +
                ",errorMsg='" + errorMsg + '\'' +
                ",result=" + result +'\'' +
                ",success" + success +
                '}';
    }
}
