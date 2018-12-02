package com.opus_bd.retrofitexample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitClientInstance {
    private static final String BASE_URL = "http://97bdf0bb.ngrok.io/jwt/public/";
    private static Retrofit retrofit;
    //private static final String BASE_URL = "http://7055e1b2.ngrok.io/kpb-web/public/";
    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();


    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
