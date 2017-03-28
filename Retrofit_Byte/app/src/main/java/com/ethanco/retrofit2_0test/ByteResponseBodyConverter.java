package com.ethanco.retrofit2_0test;

import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import retrofit.Converter;

/**
 * Created by 耿 on 2016/9/6.
 */
public class ByteResponseBodyConverter implements Converter<ResponseBody, byte[]> {
    @Override
    public byte[] convert(ResponseBody value) throws IOException {
        try {
            return value.bytes();
        } finally {
            value.close();
        }
    }
}