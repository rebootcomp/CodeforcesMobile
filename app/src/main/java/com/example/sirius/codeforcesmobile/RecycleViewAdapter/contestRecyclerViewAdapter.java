package com.example.sirius.codeforcesmobile.RecycleViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sirius.codeforcesmobile.R;
import com.example.sirius.codeforcesmobile.WebViewActivity;

import java.util.List;

public class contestRecyclerViewAdapter extends RecyclerView.Adapter<contestRecyclerViewAdapter.ViewHolder>  {

    private List<String> mTitle;
    private List<String> mDate;
    private List<String> mTime;
    private List<String> mDuration;
    private List<String> mURL;
    private LayoutInflater mInflater;
    private String title;
    private String duration;
    private String date;
    private String time;
    private String url;

    // data is passed into the constructor
    public contestRecyclerViewAdapter(Context context, List<String> titles, List<String> dates, List<String> durations, List<String> urls, List<String> times) {
        this.mInflater = LayoutInflater.from(context);
        this.mTitle = titles;
        this.mDate = dates;
        this.mTime = times;
        this.mURL = urls;
        this.mDuration = durations;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.contest_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        title = mTitle.get(position);
        date = mDate.get(position);
        time = mTime.get(position);
        duration = mDuration.get(position);
        url = mURL.get(position);
        holder.textViewTitle.setText(title);
        holder.textViewDate.setText(date);
        holder.textViewToStart.setText(time);
        //Log.d("DATE", date);
        holder.textViewDuration.setText(duration+" часа");
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mTitle.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewTitle;
        TextView textViewDate;
        TextView textViewDuration;
        TextView textViewToStart;
        Button button;

        ViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewContest);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewDuration = itemView.findViewById(R.id.textViewDuration);
            textViewToStart = itemView.findViewById(R.id.textViewToStart);
            button = itemView.findViewById(R.id.buttonRegist);
            //itemView.setOnClickListener(this);
            button.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            switch(view.getId()) {
                case R.id.buttonRegist :
                    Log.d("URL", getItemURL(position));
                    Intent intent = new Intent(view.getContext(), WebViewActivity.class);
                    intent.putExtra("URL", getItemURL(position));
                    view.getContext().startActivity(intent);
                    break;
            }
        }
    }
    // convenience method for getting data at click position
    public String getItemTitle(int id) {
        return mTitle.get(id);
    }
    public String getItemURL(int id) {
        return mURL.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        ItemClickListener mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}