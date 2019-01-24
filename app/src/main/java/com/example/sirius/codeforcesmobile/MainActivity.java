
package com.example.sirius.codeforcesmobile;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spannable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.sirius.codeforcesmobile.Fragments.ContestFragment;
import com.example.sirius.codeforcesmobile.Fragments.LoginFragment;
import com.example.sirius.codeforcesmobile.Fragments.NewsFragment;
import com.example.sirius.codeforcesmobile.Fragments.NotificationFragment;
import com.example.sirius.codeforcesmobile.Fragments.ProfileFragment;
import com.example.sirius.codeforcesmobile.Fragments.SearchFragment;
import com.example.sirius.codeforcesmobile.Fragments.WebViewFragment;
import com.example.sirius.codeforcesmobile.RecycleViewAdapter.contestRecyclerViewAdapter;
import com.example.sirius.codeforcesmobile.connectionAPI.BlogResult;
import com.example.sirius.codeforcesmobile.connectionAPI.ContestResult;
import com.example.sirius.codeforcesmobile.connectionAPI.UserResult;
import com.example.sirius.codeforcesmobile.connectionAPI.funcsAPI;
import com.google.firebase.FirebaseApp;

import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private FirebaseApp fbapp;
    private List<UserResult> userResult = null;

    NewsFragment fragment_news;
    ContestFragment fragment_contest;
    NotificationFragment fragment_notification;
    ProfileFragment fragment_profile;
    LoginFragment fragment_login;
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
                    Boolean isLogin = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                            .getBoolean("isLogin", false);
                    transaction = getFragmentManager().beginTransaction();
                    if (!isLogin) {
                        transaction.replace(R.id.frameLayout, fragment_login);
                    } else {
                        transaction.replace(R.id.frameLayout, fragment_profile);

                    }
                    transaction.commit();
                    return true;
            }
            return false;
        }
    };


    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint({"RestrictedApi", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstStartActivity();

        //инициализация
        fragment_news = new NewsFragment();
        fragment_contest = new ContestFragment();
        fragment_notification = new NotificationFragment();
        fragment_profile = new ProfileFragment();
        fragment_search = new SearchFragment();
        fragment_login = new LoginFragment();

        //начальный переход на вкладку новостей
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment_news);
        transaction.commit();

        //запись блогов в бд
        funcsAPI api = new funcsAPI();
        ArrayList<String> newsList = new ArrayList<>();
        newsList.add("64708");
        newsList.add("64685");
        newsList.add("64613");


        api.getBlog(newsList, blog -> {
            BlogResult blogResult = (BlogResult) blog;

            SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
            //db.delete("blogs", null, null);
            String title = Jsoup.parse(blogResult.getTitle()).text();
            String content = Jsoup.parse(blogResult.getContent()).text();
            String author = blogResult.getAuthorHandle();
            Spannable formatedText = (Spannable) Html.fromHtml(blogResult.getContent());
            long millis = blogResult.getCreationTimeSeconds().longValue() * 1000;
            Date date = new Date(millis);
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE,MMMM d,yyyy h:mm,a", Locale.ENGLISH);
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            String dateString = sdf.format(date);
            ContentValues values = new ContentValues();

            if (db.rawQuery("SELECT * FROM blogs WHERE title ='"+title+"' AND author='"+author+"';", null).getCount() == 0){
                values.put("title", title);
                values.put("author", author);
                values.put("date", dateString);
                values.put("content", formatedText.toString());
                values.put("date_id", (millis / 1000));
                db.insert("blogs", null, values);
            }
            db.close();
        });

        api.getContests("false", contests -> {
            if (contests != null) {
                SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
                List<ContestResult> contestResults = (List<ContestResult>) contests;
                Date currentDate = new Date(System.currentTimeMillis() / 1000); //получение времени в системе
                long currentTime = currentDate.getTime();
                Toast.makeText(getApplicationContext(), String.valueOf(currentTime), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), String.valueOf(currentDate)+ " "+ contestResults.get(0).getStartTimeSeconds(), Toast.LENGTH_SHORT).show();
                for (int i = 0; i < 10; i++) {
                    if (contestResults.get(i).getStartTimeSeconds() > currentTime) {
                        String url = "codeforces.com/contestRegistration/" + contestResults.get(i).getId().toString();
                        ContentValues values = new ContentValues();
                        values.put("id", contestResults.get(i).getId());
                        values.put("name", contestResults.get(i).getName());
                        values.put("startTimeSeconds", contestResults.get(i).getStartTimeSeconds());
                        values.put("duration", (contestResults.get(i).getDurationSeconds()/60));
                        values.put("url", url);
                        db.insert("contests", null, values);
                    }
                }

            }
        });


        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.getMenu().getItem(0).setChecked(false);
        navigation.getMenu().getItem(2).setChecked(true);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


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
        WebViewFragment fragment_webView;
        FragmentTransaction transaction;
        fragment_webView = new WebViewFragment();
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment_webView);
        transaction.commit();
    }

    public void editProfile(View view) {
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isLogin", false).apply();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }


}

