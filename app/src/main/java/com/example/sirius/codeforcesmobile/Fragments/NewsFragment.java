package com.example.sirius.codeforcesmobile.Fragments;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sirius.codeforcesmobile.R;
import com.example.sirius.codeforcesmobile.RecycleViewAdapter.newsRecyclerViewAdapter;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class NewsFragment extends Fragment implements newsRecyclerViewAdapter.ItemClickListener {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    newsRecyclerViewAdapter adapter;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View myFragmentView = inflater.inflate(R.layout.news_fragment, null);


        // data to populate the RecyclerView with
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<String> authors = new ArrayList<>();
        ArrayList<String> dates = new ArrayList<>();
        ArrayList<String> contents = new ArrayList<>();


        //get data from db
        SQLiteDatabase db = myFragmentView.getContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);

        Cursor query = db.rawQuery("SELECT * FROM blogs;", null);
        if(query.moveToFirst()){
            do{
                String title = query.getString(0);
                String author = query.getString(1);
                String date = query.getString(2);
                String content = query.getString(3);
                Toast.makeText(getContext(),query.getString(2), Toast.LENGTH_SHORT).show();
                titles.add(title);
                authors.add(author);
                dates.add(date);
                contents.add(content);
            }
            while(query.moveToNext());
        }
        //query.moveToFirst();
        //Toast.makeText(getContext(),query.getString(2),Toast.LENGTH_SHORT).show();
        query.close();
        db.close();


        // set up the RecyclerView
        RecyclerView recyclerView = myFragmentView.findViewById(R.id.recycleViewNews);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new newsRecyclerViewAdapter(getContext(),titles, authors, dates, contents);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return myFragmentView;
    }

    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(), "You clicked "+adapter.getItem(position), Toast.LENGTH_SHORT).show();
    }
}