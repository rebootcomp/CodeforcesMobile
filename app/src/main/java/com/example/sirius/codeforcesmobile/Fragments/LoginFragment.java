package com.example.sirius.codeforcesmobile.Fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sirius.codeforcesmobile.LoginActivity;
import com.example.sirius.codeforcesmobile.MainActivity;
import com.example.sirius.codeforcesmobile.R;
import com.example.sirius.codeforcesmobile.connectionAPI.UserResult;
import com.example.sirius.codeforcesmobile.connectionAPI.funcsAPI;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class LoginFragment extends Fragment implements View.OnClickListener {
    View myFragmentView;
    EditText editText;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // TODO Auto-generated method stub
        myFragmentView = inflater.inflate(R.layout.login_fragment, container, false);
        Button enter = myFragmentView.findViewById(R.id.Enter);
        editText = myFragmentView.findViewById(R.id.editTextLogin);

        enter.setOnClickListener(this);


        return myFragmentView;

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        String login = String.valueOf(editText.getText());
        funcsAPI api = new funcsAPI();

        api.getUsers(login, users -> {
                if(users!=null) {
                SQLiteDatabase db = getContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
                List<UserResult> userResult = null;
                userResult = (List<UserResult>)users;
                /**доделать ввод в бд**/
                if(userResult.get(0).getRank()!=null){
                    db.execSQL("INSERT INTO users VALUES ('" + userResult.get(0).getRank() + "','" + userResult.get(0).getHandle() + "', '" + userResult.get(0).getFirstName() + "','" + userResult.get(0).getLastName() + "','" + userResult.get(0).getRating().toString() + "','" + userResult.get(0).getMaxRating().toString() + "','" + userResult.get(0).getMaxRank() + "','" + userResult.get(0).getContribution().toString() + "','" + userResult.get(0).getFriendOfCount().toString() + "');'");
                    Intent intent = new Intent(myFragmentView.getContext(), MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                    Log.d("RETROFIT", userResult.toString());
                }
                else{
                    Toast.makeText(getContext().getApplicationContext(),"Пользователь нерейтинговый",Toast.LENGTH_SHORT).show();

                }


                getContext().getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                        .putBoolean("isLogin", true).apply();

                //
            }else{
                getContext().getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                        .putBoolean("isLogin", false).apply();
                Toast.makeText(getContext().getApplicationContext(),"Пользователь введен неверно",Toast.LENGTH_SHORT).show();
            }
        });
    }
}