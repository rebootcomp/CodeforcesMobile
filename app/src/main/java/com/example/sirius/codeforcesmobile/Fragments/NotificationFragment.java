package com.example.sirius.codeforcesmobile.Fragments;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sirius.codeforcesmobile.R;
import com.example.sirius.codeforcesmobile.RecycleViewAdapter.notificationRecyclerViewAdapter;

import java.util.ArrayList;

public class NotificationFragment extends Fragment implements notificationRecyclerViewAdapter.ItemClickListener {


    private SwipeRefreshLayout mSwipeRefreshLayout;
    notificationRecyclerViewAdapter adapter;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View myFragmentView = inflater.inflate(R.layout.notification_fragment, null);

        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Title ");


        // set up the RecyclerView
        RecyclerView recyclerView = myFragmentView.findViewById(R.id.recycleViewNotification);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new notificationRecyclerViewAdapter(getContext(), animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return myFragmentView;
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}