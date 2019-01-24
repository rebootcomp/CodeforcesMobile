package com.example.sirius.codeforcesmobile.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;
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
    CardView cardView;
    RelativeLayout relativeLayout;
    public TextView rank;
    public TextView handle;
    public TextView first_name;
    public TextView nowRatingView;
    public TextView maxRatingView;
    public TextView maxRankView;
    public TextView contributionView;
    public TextView frinedsView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragmentView= inflater.inflate(R.layout.search_fragment,container, false);
        editText = myFragmentView.findViewById(R.id.editText);
        editText.setOnEditorActionListener(this);
        cardView = myFragmentView.findViewById(R.id.cardView);
        relativeLayout = myFragmentView.findViewById(R.id.relativeLayout);
        cardView.setVisibility(View.INVISIBLE);


        //инициализаиция view элементов
        rank = myFragmentView.findViewById(R.id.rank);
        handle = myFragmentView.findViewById(R.id.handle);
        first_name = myFragmentView.findViewById(R.id.first_name);
        nowRatingView = myFragmentView.findViewById(R.id.nowRatingView);
        maxRatingView = myFragmentView.findViewById(R.id.maxRatingView);
        maxRankView = myFragmentView.findViewById(R.id.maxRankView);
        contributionView = myFragmentView.findViewById(R.id.contributionView);
        frinedsView = myFragmentView.findViewById(R.id.frinedsView);
        return myFragmentView;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            String handleUser = String.valueOf(editText.getText());
            funcsAPI api = new funcsAPI();
            api.getUsers(handleUser, users -> {
                if(users!=null) {
                    List<UserResult> userResult = null;
                    userResult = (List<UserResult>) users;
                    String handleString = userResult.get(0).getHandle();
                    String nameString = userResult.get(0).getFirstName() + " " + userResult.get(0).getLastName();
                    String contributionString = userResult.get(0).getContribution().toString();
                    String friendOfCountString = userResult.get(0).getFriendOfCount().toString();
                    if(userResult.get(0).getFirstName()==null &&  userResult.get(0).getLastName()==null){
                        first_name.setVisibility(View.GONE);
                    }
                    if(userResult.get(0).getFirstName()==null &&  userResult.get(0).getLastName()!=null){
                        first_name.setText(userResult.get(0).getLastName());
                    }
                    if(userResult.get(0).getFirstName()!=null &&  userResult.get(0).getLastName()==null){
                        first_name.setText(userResult.get(0).getFirstName());
                    }
                    handle.setText(handleString);
                    contributionView.setText(contributionString);
                    frinedsView.setText(friendOfCountString);
                    if(userResult.get(0).getRank()!=null){
                        rank.setVisibility(View.VISIBLE);
                        nowRatingView.setVisibility(View.VISIBLE);
                        maxRankView.setVisibility(View.VISIBLE);
                        maxRatingView.setVisibility(View.VISIBLE);
                        String rankString = userResult.get(0).getRank();
                        String ratingString = userResult.get(0).getRating().toString();
                        String maxratingString = userResult.get(0).getMaxRating().toString();
                        String maxrankString = userResult.get(0).getMaxRank();
                        //вывод статистики
                        rank.setText(rankString);
                        nowRatingView.setText(ratingString);
                        maxRatingView.setText(maxratingString);
                        maxRankView.setText(maxrankString);
                        //закрашивание текста в зависимости от ранга
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
                        //обработка null
                        first_name.setText(nameString);

                    }else {
                        handle.setTextColor(getResources().getColor(R.color.colorText));
                        rank.setVisibility(View.GONE);
                        nowRatingView.setVisibility(View.GONE);
                        maxRankView.setVisibility(View.GONE);
                        maxRatingView.setVisibility(View.GONE);
                    }

                    cardView.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(myFragmentView.getContext(),"Пользователь введен не верно",Toast.LENGTH_SHORT).show();
                }
            });
            return true;
        }
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        return false;

    }
}