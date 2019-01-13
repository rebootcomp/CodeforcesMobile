package com.example.sirius.codeforcesmobile;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment_news = new NewsFragment();
        fragment_contest = new ContestFragment();
        fragment_notification = new NotificationFragment();
        fragment_profile = new ProfileFragment();
        fragment_search = new SearchFragment();

        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment_news);
        transaction.commit();
    }

    public void onContest(View view) {
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment_contest);
        transaction.commit();
    }

    public void onSearch(View view) {
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment_search);
        transaction.commit();
    }

    public void onNews(View view) {
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment_news);
        transaction.commit();
    }

    public void onNotification(View view) {
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment_notification);
        transaction.commit();
    }

    public void onProfile(View view) {
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment_profile);
        transaction.commit();
    }
}
