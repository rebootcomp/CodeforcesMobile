package com.example.sirius.codeforcesmobile.Fragments;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sirius.codeforcesmobile.R;
import com.example.sirius.codeforcesmobile.RecycleViewAdapter.contestRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Date;

public class ContestFragment extends Fragment implements contestRecyclerViewAdapter.ItemClickListener {


    contestRecyclerViewAdapter adapter;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View myFragmentView = inflater.inflate(R.layout.contest_fragment, null);

        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Title");

        Date currentDate = new Date(System.currentTimeMillis());
        long millis = currentDate.getTime();    //текущее время

        // set up the RecyclerView
        RecyclerView recyclerView = myFragmentView.findViewById(R.id.recycleViewContest);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new contestRecyclerViewAdapter(getContext(), animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        return myFragmentView;
    }

    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(), "You clicked "+adapter.getItem(position), Toast.LENGTH_SHORT).show();
    }
}
