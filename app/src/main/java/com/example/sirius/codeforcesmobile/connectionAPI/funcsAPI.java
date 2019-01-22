package com.example.sirius.codeforcesmobile.connectionAPI;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
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
                    if(response.body() != null) {
                        List<UserResult> userResult = response.body().getResult();
                        // Log.d("RETROFIT",response.body().getResult());
                        Log.d("RETROFIT", response.body().getStatus());
                        if (response.body().getResult() == null) {
                            Log.d("RETROFIT", "null pointer");
                        }

                        /*testResult*/ //response.body().getResult();
                        Log.d("RETROFIT", String.valueOf(response));

                        // Log.d("RETROFIT", String.valueOf(userResult.getRating()));
                        callback.call(userResult);
                    }else{
                        callback.call(null);
                        Log.d("RETROFIT","Wrong request");

                    }

                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.d("RETROFIT", t.getLocalizedMessage());
                }


            });
        } catch (Exception e) {
            Log.d("RETROFIT", Arrays.toString(e.getStackTrace()));
           // Toast.makeText(getApplicationContext(),"Пользователь введен не верно",Toast.LENGTH_SHORT);

        }

    }

    public void getBlog(ArrayList<String> blogEntryId, final com.example.sirius.codeforcesmobile.Callback callback){

        String BASE_URL = "http://codeforces.com";

        Retrofit client = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        BlogInterface service = client.create(BlogInterface.class);
        Call<Blog> call = null;
        for(int i=0;i<blogEntryId.size();i++) {
            try {
                call = service.getBlog(blogEntryId.get(i));
            } catch (Exception e) {
                Log.d("RETROFIT", Arrays.toString(e.getStackTrace()));
            }
            Log.d("RETROFIT", "BEFORE REQUEST");


           // try {
                call.enqueue(new Callback<Blog>() {
                    @Override
                    public void onResponse(Call<Blog> call, Response<Blog> response) {
                        if (response.body()!=null) {
                            BlogResult blogResult = response.body().getResult();
                            // Log.d("RETROFIT",response.body().getResult());

                            Log.d("RETROFIT", response.body().getStatus());


                            /*testResult*/ //response.body().getResult();
                            Log.d("RETROFIT", String.valueOf(response));

                            // Log.d("RETROFIT", String.valueOf(userResult.getRating()));
                            callback.call(blogResult);
                        }else{
                            Log.d("RETROFIT","Wrong blogRequest");
                        }
                    }

                    @Override
                    public void onFailure(Call<Blog> call, Throwable t) {
                        Log.d("RETROFIT", "blogWrongRequest");
                    }


                });
           // } catch (Exception e) {
           //     Log.d("RETROFIT", Arrays.toString(e.getStackTrace()));
            //}
        }

    }

    public void getContests(String gym, final com.example.sirius.codeforcesmobile.Callback callback){

        String BASE_URL = "http://codeforces.com";

        Retrofit client = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        ContestsInterface service = client.create(ContestsInterface.class);
        Call<Contests> call = null;

        try {
            call = ((ContestsInterface) service).getContests(gym);
        } catch (Exception e) {
            Log.d("RETROFIT", Arrays.toString(e.getStackTrace()));

        }
        Log.d("RETROFIT", "BEFORE REQUEST");


        try {
            call.enqueue(new Callback<Contests>() {
                @Override
                public void onResponse(Call<Contests> call, Response<Contests> response) {
                    if(response.body() != null) {
                        List<ContestResult> contestsResult = response.body().getResult();
                        // Log.d("RETROFIT",response.body().getResult());
                        Log.d("RETROFIT", response.body().getStatus());
                        if (response.body().getResult() == null) {
                            Log.d("RETROFIT", "null pointer");
                        }

                        /*testResult*/ //response.body().getResult();
                        Log.d("RETROFIT", String.valueOf(response));

                        // Log.d("RETROFIT", String.valueOf(userResult.getRating()));
                        callback.call(contestsResult);
                    }else{
                        callback.call(null);
                        Log.d("RETROFIT","Wrong request");

                    }

                }

                @Override
                public void onFailure(Call<Contests> call, Throwable t) {
                    Log.d("RETROFIT", t.getLocalizedMessage());
                }


            });
        } catch (Exception e) {
            Log.d("RETROFIT", Arrays.toString(e.getStackTrace()));
            // Toast.makeText(getApplicationContext(),"Пользователь введен не верно",Toast.LENGTH_SHORT);

        }

    }

}