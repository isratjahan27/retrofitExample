package com.opus_bd.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RetrofitService {

    @POST("api/register")
    Call<UserResponse> registerMember(@Body UserModel userModel);

    @POST("api/login")
    Call<UserResponse> login(@Body UserModel userModel);

    @GET("api/getAlluser")
    Call<List<UserInfo>> getUser(@Header("Authorization") String token);
}
