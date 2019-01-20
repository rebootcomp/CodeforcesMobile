package com.example.sirius.codeforcesmobile.connectionAPI;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class funcsAPI {
    private static funcsAPI mfuncsAPI;
    private Retrofit retrofit;
    private UserInterface userInterface;


    public void getUsers(String handles, final com.example.sirius.codeforcesmobile.Callback callback){

        String BASE_URL = "http://codeforces.com";

        Retrofit client = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        UserInterface service = client.create(UserInterface.class);
        Call<User> call = null;

        try {
            call = service.getUsers(handles);
        } catch (Exception e) {
            Log.d("RETROFIT", Arrays.toString(e.getStackTrace()));
        }
        Log.d("RETROFIT", "BEFORE REQUEST");


        try {
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    List<UserResult> userResult = response.body().getResult();
                    /*testResult*/ //response.body().getResult();
                    Log.d("RETROFIT", String.valueOf(response));

                    // Log.d("RETROFIT", String.valueOf(userResult.getRating()));
                    callback.call(userResult);
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.d("RETROFIT", t.getLocalizedMessage());
                }


            });
        } catch (Exception e) {
            Log.d("RETROFIT", Arrays.toString(e.getStackTrace()));
        }

    }

}