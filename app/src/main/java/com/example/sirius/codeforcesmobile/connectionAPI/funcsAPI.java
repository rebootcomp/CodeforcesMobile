package com.example.sirius.codeforcesmobile.connectionAPI;

import android.util.Log;

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
    public List<UserResult> userResult = null;

    public static funcsAPI getInstance(){
        if(mfuncsAPI==null){
            mfuncsAPI = new funcsAPI();
        }
        return mfuncsAPI;
    }

    public void connect() {
       // HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder();
               // .addInterceptor(interceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://codeforces.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
        userInterface = retrofit.create(UserInterface.class);
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }

    public UserInterface getInterface() {
        return userInterface;
    }

     public User getUser(String handle){
//        Call<ApiListResponse<User>> call = getInterface().getUser(handle);
//        Log.d("RETROFIT", "BEFORE REQUEST");
//         final User[] newUser = {new User()};
//        call.enqueue(new Callback<ApiListResponse<User>>() {
//            @Override
//            public  void onResponse(Call<ApiListResponse<User>> call, Response<ApiListResponse<User>> response) {
//                 newUser[0] = response.body().getResult().get(0);
//                Log.d("RETROFIT", String.valueOf(response));
//                Log.d("RETROFIT", String.valueOf(newUser[0].handle));
//            }
//
//            @Override
//            public void onFailure(Call<ApiListResponse<User>> call, Throwable t) {
//
//            }
//        });
//        return  newUser[0];
         return null;
    }

    public void getUsers(String handles/*, UserResult testResult*/){

        String BASE_URL = "http://codeforces.com";

        Retrofit client = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        UserInterface service = client.create(UserInterface.class);

        //try {
        //} catch (Exception e) {
          //  Log.d("RETROFIT", Arrays.toString(e.getStackTrace()));
       // }
        Log.d("RETROFIT", "BEFORE REQUEST");


        funcsAPI.getInstance().getInterface().getUsers("rebootcomp").enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                userResult = response.body().getResult();
                /*testResult*/ //response.body().getResult();
                Log.d("RETROFIT", String.valueOf(response));
                Log.d("RETROFIT", String.valueOf(response.body().getResult().get(0).getMaxRating()));
               // Log.d("RETROFIT", String.valueOf(userResult.getRating()));

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }



        });

        //System.out.println("df");
       // return ((Callback<User>) testCreate);
//        return userResult;
    }

    public List<UserResult> getUserResult(){
        return userResult;
    }





    //public void getResponse() {
       /*user.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    System.out.println("response " + response.body());
                } else {
                    System.out.println("response code " + response.code());
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }






        });*/

    //}
}