package com.example.sirius.codeforcesmobile.RecycleViewAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sirius.codeforcesmobile.R;

import java.util.List;

public class notificationRecyclerViewAdapter extends RecyclerView.Adapter<notificationRecyclerViewAdapter.ViewHolder> {

    private List<String> mTitle;
    private List<String> mDate;
    private List<String> mContent;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public notificationRecyclerViewAdapter(Context context, List<String> title,List<String> content,  List<String> date ) {
        this.mInflater = LayoutInflater.from(context);
        this.mTitle = title;
        this.mContent = content;
        this.mDate = date;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.notification_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String title = mTitle.get(position);
        String content = mContent.get(position);
        String date = mDate.get(position);
        holder.round_nameTextView.setText(title);
        holder.text_new_tutorial.setText(content);
        holder.date_notification.setText(date);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mTitle.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView round_nameTextView;
        TextView text_new_tutorial;
        TextView date_notification;

        ViewHolder(View itemView) {
            super(itemView);
            round_nameTextView = itemView.findViewById(R.id.round_nameTextView);
            text_new_tutorial = itemView.findViewById(R.id.text_new_tutorial);
            date_notification = itemView.findViewById(R.id.date_notification);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
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
