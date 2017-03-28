package com.ethanco.retrofit2_0test;

import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;


import okio.Buffer;
import retrofit.Converter;


/**
 * Created by 耿 on 2016/9/6.
 */
public class ByteRequestBodyConverter  implements Converter<byte[], RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/octet-stream'; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    ByteRequestBodyConverter() {
    }

    @Override public RequestBody convert(byte[] value) throws IOException {
        Buffer buffer = new Buffer();
        Writer writer = new OutputStreamWriter(buffer.outputStream(), UTF_8);
        buffer.write(value);

        Log.e("aa",new String(value));
        writer.close();
        return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
    }
}