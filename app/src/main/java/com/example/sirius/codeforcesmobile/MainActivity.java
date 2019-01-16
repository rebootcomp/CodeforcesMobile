package com.example.sirius.codeforcesmobile;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    ImageButton imageButtonContest;
    ImageButton imageButtonSearch;
    ImageButton imageButtonNews;
    ImageButton imageButtonNotification;
    ImageButton imageButtonProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
