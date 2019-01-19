package com.example.sirius.codeforcesmobile;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sirius.codeforcesmobile.Fragments.ContestFragment;
import com.example.sirius.codeforcesmobile.Fragments.NewsFragment;
import com.example.sirius.codeforcesmobile.Fragments.NotificationFragment;
import com.example.sirius.codeforcesmobile.Fragments.ProfileFragment;
import com.example.sirius.codeforcesmobile.Fragments.SearchFragment;
import com.example.sirius.codeforcesmobile.connectionAPI.ApiListResponse;
import com.example.sirius.codeforcesmobile.connectionAPI.UserResult;
import com.example.sirius.codeforcesmobile.connectionAPI.User;
import com.example.sirius.codeforcesmobile.connectionAPI.UserInterface;
import com.example.sirius.codeforcesmobile.connectionAPI.UserResult;
import com.example.sirius.codeforcesmobile.connectionAPI.funcsAPI;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    NewsFragment fragment_news;
    ContestFragment fragment_contest;
    NotificationFragment fragment_notification;
    ProfileFragment fragment_profile;
    SearchFragment fragment_search;
    FragmentTransaction transaction;

    ImageButton imageButtonContest;
    ImageButton imageButtonSearch;
    ImageButton imageButtonNews;
    ImageButton imageButtonNotification;
    ImageButton imageButtonProfile;

    @SuppressLint("ShowToast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("TEST", "onCreate");

        fragment_news = new NewsFragment();
        fragment_contest = new ContestFragment();
        fragment_notification = new NotificationFragment();
        fragment_profile = new ProfileFragment();
        fragment_search = new SearchFragment();

        imageButtonContest = findViewById(R.id.imageButtonContest);
        imageButtonSearch = findViewById(R.id.imageButtonSearch);
        imageButtonNews = findViewById(R.id.imageButtonNews);
        imageButtonNotification = findViewById(R.id.imageButtonNotification);
        imageButtonProfile = findViewById(R.id.imageButtonProfile);

        imageButtonNews.setImageDrawable(getDrawable(R.drawable.ic_news_touch));
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment_news);
        transaction.commit();



      //  Thread thr = new Thread();
            funcsAPI api = new funcsAPI();
            api.connect();
            api.getUsers("rebootcomp");
            UserResult user = api.getUserResult().get(0);
            Log.d("RETROFIT",user.getHandle());
            //String text = user.getHandle();
           // Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();

        /*String BASE_URL = "http://codeforces.com";

        Retrofit client = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        UserInterface service = client.create(UserInterface.class);
        Call<User> call = null;
        try {
            call = service.getUser("rebootcomp");
        } catch (Exception e) {
            Log.d("RETROFIT", Arrays.toString(e.getStackTrace()));
        }
        Log.d("RETROFIT", "BEFORE REQUEST");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
//
//
              UserResult newUser = response.body().getResult().get(0);
              Toast.makeText(getApplicationContext() , newUser.getRating().toString(), Toast.LENGTH_SHORT).show();
             // Toast
                Log.d("RETROFIT", String.valueOf(response));
                Log.d("RETROFIT", String.valueOf(newUser.getHandle()));
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });*/
      /* funcsAPI api = new funcsAPI();
       api.connect();
    Retrofit retrofit  = new Retrofit.Builder()
            .baseUrl("http://codeforces.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
            UserInterface usInt = retrofit.create(UserInterface.class);
        Call<ApiListResponse<User>> call = null;
            try {
            call = usInt.getUser("rebootcomp");
        } catch (Exception e) {
            Log.d("RETROFIT", Arrays.toString(e.getStackTrace()));
        }
        Log.d("RETROFIT", "BEFORE REQUEST");
        final User[] newUser = {new User()};
        call.enqueue(new Callback<ApiListResponse<User>>() {
            @Override
            public  void onResponse(Call<ApiListResponse<User>> call, Response<ApiListResponse<User>> response) {
                newUser[0] = response.body().getResults().get(0);
                Log.d("RETROFIT", String.valueOf(response));
                Log.d("RETROFIT", String.valueOf(newUser[0].handle));
            }

            @Override
            public void onFailure(Call<ApiListResponse<User>> call, Throwable t) {

            }
        });*/
     /* User user =  api.getUser("rebootcomp");
        Log.d("outputt",user.getFirstName());
        List<User> users = api.getUsers("rebootcomp;tourist");
       Log.d("outputt",users.get(1).getFirstName());*/

    }

    public void onContest(View view) {
        resetButton();
        imageButtonContest.setImageDrawable(getDrawable(R.drawable.ic_contest_touch));
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment_contest);
        transaction.commit();
    }

    public void onSearch(View view) {
        resetButton();
        imageButtonSearch.setImageDrawable(getDrawable(R.drawable.ic_search_touch));
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment_search);
        transaction.commit();
    }

    public void onNews(View view) {
        resetButton();
        imageButtonNews.setImageDrawable(getDrawable(R.drawable.ic_news_touch));
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment_news);
        transaction.commit();
    }

    public void onNotification(View view) {
        resetButton();
        imageButtonNotification.setImageDrawable(getDrawable(R.drawable.ic_notification_touch));
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment_notification);
        transaction.commit();
    }

    public void onProfile(View view) {
        resetButton();
        imageButtonProfile.setImageDrawable(getDrawable(R.drawable.ic_profile_touch));
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment_profile);
        transaction.commit();
    }

    private void resetButton(){
        imageButtonContest.setImageDrawable(getDrawable(R.drawable.ic_contest));
        imageButtonSearch.setImageDrawable(getDrawable(R.drawable.ic_search));
        imageButtonNews.setImageDrawable(getDrawable(R.drawable.ic_news));
        imageButtonNotification.setImageDrawable(getDrawable(R.drawable.ic_notification));
        imageButtonProfile.setImageDrawable(getDrawable(R.drawable.ic_profile));

    }
}
