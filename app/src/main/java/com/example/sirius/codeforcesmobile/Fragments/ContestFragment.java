package com.example.sirius.codeforcesmobile.Fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sirius.codeforcesmobile.R;
import com.example.sirius.codeforcesmobile.RecycleViewAdapter.contestRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;

public class ContestFragment extends Fragment implements contestRecyclerViewAdapter.ItemClickListener {


    contestRecyclerViewAdapter adapter;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View myFragmentView = inflater.inflate(R.layout.contest_fragment, null);

        // data to populate the RecyclerView with
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> dates = new ArrayList<>();
        ArrayList<String> durations = new ArrayList<>();


        //get data from db
        SQLiteDatabase db = myFragmentView.getContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        Cursor query = db.rawQuery("SELECT * FROM contests ORDER BY startTimeSeconds ASC", null);
        if(query.moveToFirst()){
            do{
                String title = query.getString(1);
                Date currentDate = new Date(query.getLong(2));
                String duration = query.getString(3);
                //Toast.makeText(getContext(),query.getString(1), Toast.LENGTH_SHORT).show();
                names.add(title);
                dates.add(String.valueOf(currentDate));
                durations.add(duration);
            }
            while(query.moveToNext());
        }
        query.close();
        db.close();

        // set up the RecyclerView
        RecyclerView recyclerView = myFragmentView.findViewById(R.id.recycleViewContest);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new contestRecyclerViewAdapter(getContext(), names, dates, durations);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return myFragmentView;
    }
    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(), "You clicked "+adapter.getItem(position), Toast.LENGTH_SHORT).show();
    }

}
