package com.example.sirius.codeforcesmobile.Fragments;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sirius.codeforcesmobile.R;

import static android.content.Context.MODE_PRIVATE;

public class ProfileFragment extends Fragment {
    TextView rank;
    TextView handle;
    TextView first_name;
    TextView nowRatingView;
    TextView maxRatingView;
    TextView maxRankView;
    TextView contributionView;
    TextView frinedsView;
    TextView lastVisitWebView;
    TextView regTimeView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // TODO Auto-generated method stub
        View myFragmentView = inflater.inflate(R.layout.profile_fragment, null);

        rank = (TextView)myFragmentView.findViewById(R.id.rank);
        handle = (TextView)myFragmentView.findViewById(R.id.handle);
        first_name = (TextView)myFragmentView.findViewById(R.id.first_name);
        nowRatingView = (TextView)myFragmentView.findViewById(R.id.nowRatingView);
        maxRatingView = (TextView)myFragmentView.findViewById(R.id.maxRatingView);
        maxRankView = (TextView)myFragmentView.findViewById(R.id.maxRankView);
        contributionView = (TextView)myFragmentView.findViewById(R.id.contributionView);
        frinedsView = (TextView)myFragmentView.findViewById(R.id.frinedsView);
        lastVisitWebView = (TextView)myFragmentView.findViewById(R.id.lastVisitWebView);
        regTimeView = (TextView)myFragmentView.findViewById(R.id.regTimeView);
        //get data from db
        SQLiteDatabase db = inflater.getContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);


        Cursor query = db.rawQuery("SELECT * FROM users;", null);
        if(query.moveToFirst()){
            do{
                String name = query.getString(0);
                int age = query.getInt(1);
                handle.setText(name);

                Toast.makeText(inflater.getContext(), "Name: " + name + " Age: " + age, Toast.LENGTH_SHORT).show();
            }
            while(query.moveToNext());
        }
        query.close();
        db.close();
        return inflater.inflate(R.layout.profile_fragment, null);

    }


}