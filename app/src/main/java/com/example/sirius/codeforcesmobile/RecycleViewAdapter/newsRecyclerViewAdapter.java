package com.example.sirius.codeforcesmobile.RecycleViewAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sirius.codeforcesmobile.R;

import java.util.List;

public class newsRecyclerViewAdapter extends RecyclerView.Adapter<newsRecyclerViewAdapter.ViewHolder> {

    private List<String> mTitle;
    private List<String> mAuthor;
    private List<String> mDate;
    private List<String> mContent;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public newsRecyclerViewAdapter(Context context, List<String> title, List<String> author, List<String> date, List<String> content) {
        this.mInflater = LayoutInflater.from(context);
        this.mTitle = title;
        this.mAuthor = author;
        this.mDate = date;
        this.mContent = content;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.news_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String title = mTitle.get(position);
        String author = mAuthor.get(position);
        String date = mDate.get(position);
        String content = mContent.get(position);
        holder.textViewTitle.setText(title);
        holder.textViewAuthor.setText(author);
        holder.textViewDate.setText(date);
        holder.textViewContent.setText(content);

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mTitle.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewTitle;
        TextView textViewAuthor;
        TextView textViewDate;
        TextView textViewContent;

        ViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewContent = itemView.findViewById(R.id.textViewContent);
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
