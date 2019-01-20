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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // TODO Auto-generated method stub
        View myFragmentView = inflater.inflate(R.layout.profile_fragment, null);

        TextView rank = (TextView)myFragmentView.findViewById(R.id.rank);
        TextView handle = (TextView)myFragmentView.findViewById(R.id.handle);
        TextView first_name = (TextView)myFragmentView.findViewById(R.id.first_name);
        TextView nowRatingView = (TextView)myFragmentView.findViewById(R.id.nowRatingView);
        TextView maxRatingView = (TextView)myFragmentView.findViewById(R.id.maxRatingView);
        TextView maxRankView = (TextView)myFragmentView.findViewById(R.id.maxRankView);
        TextView contributionView = (TextView)myFragmentView.findViewById(R.id.contributionView);
        TextView frinedsView = (TextView)myFragmentView.findViewById(R.id.frinedsView);
        TextView lastVisitWebView = (TextView)myFragmentView.findViewById(R.id.lastVisitWebView);
        TextView regTimeView = (TextView)myFragmentView.findViewById(R.id.regTimeView);

        return inflater.inflate(R.layout.profile_fragment, null);
    }
}