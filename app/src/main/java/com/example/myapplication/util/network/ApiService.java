package com.example.myapplication.util.network;

import com.example.myapplication.model.entity.res.QuerybankRes;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

public interface ApiService {

    /**
     * 根据银行名称查询银行信息
     */
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST(UrlUtil.QUERY_BANK_INFORMATION)
    Observable<BaseModel<List<QuerybankRes>>> getBankcardinformation(@Body RequestBody body);

    /**
     * 申请平台商商户进件
     */
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST(UrlUtil.APPLICATIONFORMERCHANTENTRY)
    Observable<BaseModel<String>> getMerchantentry(@Body RequestBody body);

}
