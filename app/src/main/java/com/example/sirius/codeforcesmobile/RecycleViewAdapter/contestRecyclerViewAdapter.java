package com.example.sirius.codeforcesmobile.RecycleViewAdapter;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sirius.codeforcesmobile.Fragments.WebViewFragment;
import com.example.sirius.codeforcesmobile.LoginActivity;
import com.example.sirius.codeforcesmobile.R;
import com.example.sirius.codeforcesmobile.WebViewActivity;

import java.util.List;

public class contestRecyclerViewAdapter extends RecyclerView.Adapter<contestRecyclerViewAdapter.ViewHolder> {

    private List<String> mTitle;
    private List<String> mDate;
    private List<String> mDuration;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public contestRecyclerViewAdapter(Context context, List<String> titles, List<String> dates, List<String> durations) {
        this.mInflater = LayoutInflater.from(context);
        this.mTitle = titles;
        this.mDate = dates;
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
        String title = mTitle.get(position);
        String date = mDate.get(position);
        String duration = mDuration.get(position);
        holder.textViewTitle.setText(title);
        holder.textViewDate.setText(date);
        holder.textViewDuration.setText(duration);
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
        Button button;

        ViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewContest);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewDuration = itemView.findViewById(R.id.textViewDuration);
            button = itemView.findViewById(R.id.buttonRegist);
            //itemView.setOnClickListener(this);
            button.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.buttonRegist :

                    WebViewFragment fragment_webView;
                    FragmentTransaction transaction;
                    fragment_webView = new WebViewFragment();


//                    transaction = getFragmentManager().beginTransaction();
//                    transaction.replace(R.id.frameLayout, fragment_webView);
//                    transaction.commit();

                    Intent intent = new Intent(view.getContext(), WebViewActivity.class);
                    view.getContext().startActivity(intent);

                    break;
            }
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return mTitle.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
