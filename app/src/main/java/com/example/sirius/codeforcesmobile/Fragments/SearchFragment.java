package com.example.sirius.codeforcesmobile.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sirius.codeforcesmobile.MainActivity;
import com.example.sirius.codeforcesmobile.R;
import com.example.sirius.codeforcesmobile.connectionAPI.UserResult;
import com.example.sirius.codeforcesmobile.connectionAPI.funcsAPI;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class SearchFragment extends Fragment implements TextView.OnEditorActionListener {

    EditText editText;
    View myFragmentView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragmentView= inflater.inflate(R.layout.search_fragment, null);

        editText = (EditText) myFragmentView.findViewById(R.id.editText);
        editText.setOnEditorActionListener(this);


        return myFragmentView;
    }

    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            /*String handle = String.valueOf(editText.getText());
            funcsAPI api = new funcsAPI();

            api.getUsers(handle, users -> {
                if(users!=null) {
                    List<UserResult> userResult = null;
                    userResult = (List<UserResult>) users;
                    userResult.get();
                }else{
                    Toast.makeText(myFragmentView.getContext(),"Пользователь введен не верно",Toast.LENGTH_SHORT).show();
                }
            });

            String rankString = usgetString(0);
            String handleString = query.getString(1);
            String nameString = query.getString(2) + " "+ query.getString(3);
            String ratingString = query.getString(4);
            String maxratingString = query.getString(5);
            String maxrankString = query.getString(6);
            String contributionString = query.getString(7);
            String friendOfCountString = query.getString(8);

            first_name.setText(nameString);
            if(query.getString(2).equals("null") && query.getString(3).equals("null")){
                first_name.setVisibility(View.GONE);
            }
            if(query.getString(2).equals("null") && !query.getString(3).equals("null")){
                first_name.setText(query.getString(3));
            }
            if(!query.getString(2).equals("null") && query.getString(3).equals("null")){
                first_name.setText(query.getString(2));
            }

            rank.setText(rankString);
            handle.setText(handleString);

            nowRatingView.setText(ratingString);
            maxRatingView.setText(maxratingString);
            maxRankView.setText(maxrankString);
            contributionView.setText(contributionString);
            frinedsView.setText(friendOfCountString);
            rankString = rankString.replace(" ", "_");
            maxrankString = maxrankString.replace(" ", "_");
            int resourceIdNow = getContext().getResources().
                    getIdentifier(rankString, "color", getContext().getPackageName());
            int resourceIdBest = getContext().getResources().
                    getIdentifier(maxrankString, "color", getContext().getPackageName());

            rank.setTextColor(getResources().getColor(resourceIdNow));
            handle.setTextColor(getResources().getColor(resourceIdNow));
            nowRatingView.setTextColor(getResources().getColor(resourceIdNow));
            maxRankView.setTextColor(getResources().getColor(resourceIdBest));
            maxRatingView.setTextColor(getResources().getColor(resourceIdBest));
            query.close();
            db.close();
            return true;*/
        }
        return false;
    }
}