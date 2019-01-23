package com.example.sirius.codeforcesmobile.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sirius.codeforcesmobile.LoginActivity;
import com.example.sirius.codeforcesmobile.R;

import java.util.HashMap;

import static android.content.Context.MODE_PRIVATE;

public class ProfileFragment extends Fragment {
    public TextView rank;
    public TextView handle;
    public TextView first_name;
    public TextView nowRatingView;
    public TextView maxRatingView;
    public TextView maxRankView;
    public TextView contributionView;
    public TextView frinedsView;
    View myFragmentView;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView = inflater.inflate(R.layout.profile_fragment, container, false);
        //инициализаиция view элементов
        rank = (TextView)myFragmentView.findViewById(R.id.rank);
        handle = (TextView)myFragmentView.findViewById(R.id.handle);
        first_name = (TextView)myFragmentView.findViewById(R.id.first_name);
        nowRatingView = (TextView)myFragmentView.findViewById(R.id.nowRatingView);
        maxRatingView = (TextView)myFragmentView.findViewById(R.id.maxRatingView);
        maxRankView = (TextView)myFragmentView.findViewById(R.id.maxRankView);
        contributionView = (TextView)myFragmentView.findViewById(R.id.contributionView);
        frinedsView = (TextView)myFragmentView.findViewById(R.id.frinedsView);

        //проверка на то, что пользователь залогинился
        Boolean isLogin = getContext().getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isLogin", false);
        if (isLogin){
            setTextAndColour();
        }
        else{
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
        return myFragmentView;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setTextAndColour(){
        //получение данных из бд
        SQLiteDatabase db = myFragmentView.getContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        Cursor query = db.rawQuery("SELECT * FROM users;", null);
        query.moveToLast();
        String rankString = query.getString(0);
        String handleString = query.getString(1);
        String nameString = query.getString(2) + " "+ query.getString(3);
        String ratingString = query.getString(4);
        String maxratingString = query.getString(5);
        String maxrankString = query.getString(6);
        String contributionString = query.getString(7);
        String friendOfCountString = query.getString(8);


        //обработка null
        first_name.setText(nameString);
        if(query.getString(2).equals("null") && query.getString(3).equals("null")){
            first_name.setVisibility(View.GONE);
        }
        if(query.getString(2).equals("null") && !query.getString(3).equals("null")){
            first_name.setText(query.getString(3));
        }
        if(!query.getString(2).equals("null") && query.getString(3).equals("null")){
            first_name.setText(query.getString(2));
        }

        //вывод статистики
        rank.setText(rankString);
        handle.setText(handleString);
        nowRatingView.setText(ratingString);
        maxRatingView.setText(maxratingString);
        maxRankView.setText(maxrankString);
        contributionView.setText(contributionString);
        frinedsView.setText(friendOfCountString);

        //закрашивание текста в зависимости от ранга
        rankString = rankString.replace(" ", "_");
        maxrankString = maxrankString.replace(" ", "_");
        int resourceIdNow = getContext().getResources().
                getIdentifier(rankString, "color", getContext().getPackageName());
        int resourceIdBest = getContext().getResources().
                getIdentifier(maxrankString, "color", getContext().getPackageName());
        rank.setTextColor(getResources().getColor(resourceIdNow));
        handle.setTextColor(getResources().getColor(resourceIdNow));
        nowRatingView.setTextColor(getResources().getColor(resourceIdNow));
        maxRankView.setTextColor(getResources().getColor(resourceIdBest));
        maxRatingView.setTextColor(getResources().getColor(resourceIdBest));
        query.close();
        db.close();
    }


}