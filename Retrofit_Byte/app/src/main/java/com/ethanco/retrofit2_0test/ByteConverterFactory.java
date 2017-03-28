package com.ethanco.retrofit2_0test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;


import retrofit.Converter;
import retrofit.Retrofit;

import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

/**
 *byte factory
 *@author:juanqiang
 *created at:2017/3/28 上午8:29
 *
 */
public class ByteConverterFactory extends Converter.Factory{

    public static ByteConverterFactory create() {
        return new ByteConverterFactory();
    }

    private ByteConverterFactory() {

    }


    @Override
    public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
       // return super.fromResponseBody(type, annotations);
        return (Converter<ResponseBody, ?>) new ByteResponseBodyConverter();
    }

    @Override
    public Converter<?, RequestBody> toRequestBody(Type type, Annotation[] annotations) {
        return new ByteRequestBodyConverter();
    }
}