package com.example.sirius.codeforcesmobile.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sirius.codeforcesmobile.R;

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


        return inflater.inflate(R.layout.profile_fragment, null);
    }

    public void setProfile(String item) {

    }
}