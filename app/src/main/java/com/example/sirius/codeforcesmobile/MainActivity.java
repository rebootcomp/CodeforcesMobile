
package com.example.sirius.codeforcesmobile;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.view.MenuItem;
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

    private List<UserResult> userResult = null;

    NewsFragment fragment_news;
    ContestFragment fragment_contest;
    NotificationFragment fragment_notification;
    ProfileFragment fragment_profile;
    SearchFragment fragment_search;
    FragmentTransaction transaction;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_contest:
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayout, fragment_contest);
                    transaction.commit();
                    return true;
                case R.id.action_search:
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayout, fragment_search);
                    transaction.commit();
                    return true;
                case R.id.action_news:
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayout, fragment_news);
                    transaction.commit();
                    return true;
                case R.id.action_notification:
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayout, fragment_notification);
                    transaction.commit();
                    return true;
                case R.id.action_profile:
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayout, fragment_profile);
                    transaction.commit();
                    return true;
            }
            return false;
        }
    };


    @SuppressLint({"RestrictedApi", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstStartActivity();

        fragment_news = new NewsFragment();
        fragment_contest = new ContestFragment();
        fragment_notification = new NotificationFragment();
        fragment_profile = new ProfileFragment();
        fragment_search = new SearchFragment();


        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment_news);
        transaction.commit();


        //
        funcsAPI api = new funcsAPI();

        api.getUsers("rebootcomp", users -> {
            SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
            List<UserResult> userResult = null;
            userResult = (List<UserResult>) users;

            db.execSQL("INSERT INTO users VALUES ('"+userResult.get(0).getRank()+"','" + userResult.get(0).getHandle() + "', '" + userResult.get(0).getFirstName().toString() + "','" + userResult.get(0).getLastName().toString() + "','" + userResult.get(0).getRating().toString() + "','" + userResult.get(0).getMaxRating().toString() + "','" + userResult.get(0).getMaxRank().toString() + "','"+userResult.get(0).getContribution().toString()+"','"+userResult.get(0).getFriendOfCount().toString()+"');");
            Log.d("RETROFIT", userResult.toString());
            // insert into LOCAL DB (variant1)
            // insert into fragment in bundle(variant2)
            // insert into sherperf (variant3)
            if (userResult != null) {
                Toast.makeText(getApplicationContext(), userResult.get(0).getHandle(), Toast.LENGTH_SHORT).show();

            }
        });


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.getMenu().getItem(0).setChecked(false);
        navigation.getMenu().getItem(2).setChecked(true);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    private void callAfterRetro() {

    }


    private void firstStartActivity() {
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            //show start activity

            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }

        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).apply();
    }

    public void onContent(View view) {
        Toast.makeText(getApplicationContext(), "овово ", Toast.LENGTH_SHORT).show();
    }
}

