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
                   // Log.d("RETROFIT",response.body().getResult());
                    if(response.body().getStatus()==null){
                        Log.d("RETROFIT",response.body().getStatus());
                    }

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

    public void getBlog(String blogEntryId, final com.example.sirius.codeforcesmobile.Callback callback){

        String BASE_URL = "http://codeforces.com";

        Retrofit client = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        BlogInterface service = client.create(BlogInterface.class);
        Call<Blog> call = null;

        try {
            call = service.getBlog(blogEntryId);
        } catch (Exception e) {
            Log.d("RETROFIT", Arrays.toString(e.getStackTrace()));
        }
        Log.d("RETROFIT", "BEFORE REQUEST");


        try {
            call.enqueue(new Callback<Blog>() {
                @Override
                public void onResponse(Call<Blog> call, Response<Blog> response) {
                    BlogResult blogResult = response.body().getResult();
                    // Log.d("RETROFIT",response.body().getResult());
                    if(response.body().getStatus()==null){
                        Log.d("RETROFIT",response.body().getStatus());
                    }

                    /*testResult*/ //response.body().getResult();
                    Log.d("RETROFIT", String.valueOf(response));

                    // Log.d("RETROFIT", String.valueOf(userResult.getRating()));
                    callback.call(blogResult);

                }

                @Override
                public void onFailure(Call<Blog> call, Throwable t) {

                }




            });
        } catch (Exception e) {
            Log.d("RETROFIT", Arrays.toString(e.getStackTrace()));
        }

    }

}