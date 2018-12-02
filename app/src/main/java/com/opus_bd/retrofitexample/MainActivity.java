package com.opus_bd.retrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public String token;

    public ArrayList<UserModel> items = new ArrayList<>();
    //public ContactsAdapter contactsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getAllMembers();
        // initializeVariables();
    }

    private void getAllMembers() {
        //  progressBar.setVisibility(View.VISIBLE);
        UserModel userModel = new UserModel("qwassfsqw", "qwassfsqw@jsgd.com", "1234567", "1234567");

        RetrofitService retrofitService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitService.class);
        Call<UserResponse> registrationRequest = retrofitService.registerMember(userModel);
        registrationRequest.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Log.d("user", "" + response.body().getToken());
                Log.d("user", "" + response.body().getUser());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d("user", "Fail to connect ");

            }
        });
    }


    private void login() {
        //  progressBar.setVisibility(View.VISIBLE);
        UserModel userModel = new UserModel("avb@jjhdj.com", "12345567");

        RetrofitService retrofitService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitService.class);
        Call<UserResponse> registrationRequest = retrofitService.login(userModel);
        registrationRequest.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                //  Log.d("user",""+response.body().getToken());
                //  Log.d("user",""+response.body().getUser());
                token = response.body().getToken();
                Log.d("user", token);
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.d("user", "Fail to connect " + t.toString());

            }
        });
    }

    private void showalluser() {
        //  progressBar.setVisibility(View.VISIBLE);
        // final UserInfo userInfo=new UserInfo();

        RetrofitService retrofitService = RetrofitClientInstance.getRetrofitInstance().create(RetrofitService.class);
        Call<List<UserInfo>> registrationRequest = retrofitService.getUser("Bearer " + token);
        registrationRequest.enqueue(new Callback<List<UserInfo>>() {
            @Override
            public void onResponse(Call<List<UserInfo>> call, Response<List<UserInfo>> response) {
                //  Log.d("user",""+response.body().getToken());
                //  Log.d("user",""+response.body().getUser());
                //  token=response.body().getToken();
                Log.d("user", "user" + response.body().size());
            }

            @Override
            public void onFailure(Call<List<UserInfo>> call, Throwable t) {
                Log.d("user", "Fail to connect " + t.toString());

            }
        });
    }

    public void submit(View view) {
        login();
    }

    public void showuser(View view) {
        showalluser();
    }


   /* private void initializeVariables() {
        contactsAdapter = new ContactsAdapter(items, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(contactsAdapter);
        et_search.addTextChangedListener(textWatcher);
    }*/
}
