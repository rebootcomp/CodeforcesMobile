package com.example.sirius.codeforcesmobile;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.sirius.codeforcesmobile.Fragments.ContestFragment;
import com.example.sirius.codeforcesmobile.Fragments.NewsFragment;
import com.example.sirius.codeforcesmobile.Fragments.NotificationFragment;
import com.example.sirius.codeforcesmobile.Fragments.ProfileFragment;
import com.example.sirius.codeforcesmobile.Fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {

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

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.getMenu().getItem(0).setChecked(false);
        navigation.getMenu().getItem(2).setChecked(true);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    private void firstStartActivity(){
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            //show start activity

            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }

        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).apply();
    }

}
