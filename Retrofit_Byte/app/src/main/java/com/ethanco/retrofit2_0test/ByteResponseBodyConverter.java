package com.ethanco.retrofit2_0test;

import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import retrofit.Converter;

/**
 *byte factory
 *@author:juanqiang
 *created at:2017/3/28 上午8:29
 *
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