package com.example.android.localweatherwithfragment;

import static com.example.android.localweatherwithfragment.Util.GsonUtil.createGson;
import static com.example.android.localweatherwithfragment.Util.OkhttpClientUtil.buildOkHttpClient;
import com.example.android.localweatherwithfragment.DataModel.ParameterClass;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetRetrofitObj {
    static WeatherService retrofitService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ParameterClass.baseUrl)
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(buildOkHttpClient())
                .build();
        return retrofit.create(WeatherService.class);
    }
}
