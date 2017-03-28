package com.ethanco.retrofit2_0test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    ///////////////////////////////////////////////////此API接口会过期，请在http://www.haoservice.com/docs/6中重新申请一次
    String apiKey = "9b1e877ce7634787b7a12aa0379cc81a";
    String baseUrl = "http://10.2.8.208:8001/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getByRxJava();
    }

    private void getByRxJava() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(ByteConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        byte[] aa =null;
        try {
            aa = "我是jjj".getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Observable<byte[]> observable = service.byteTest(aa);

        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<byte[]>() {
                    @Override
                    public void onCompleted() {
                        Log.e("aa","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("aa",e.toString());
                    }

                    @Override
                    public void onNext(byte[] weather) {
                        Log.e("aa",new String(weather));
                    }

                });
    }

    
}
