package com.example.sirius.codeforcesmobile;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sirius.codeforcesmobile.connectionAPI.UserResult;
import com.example.sirius.codeforcesmobile.connectionAPI.funcsAPI;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText editTextLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextLogin = findViewById(R.id.editTextLogin);
    }

    public void onEnter(View view) {

        String login = String.valueOf(editTextLogin.getText());
        funcsAPI api = new funcsAPI();

        api.getUsers(login, users -> {
            if(users!=null) {
                SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
                List<UserResult> userResult = null;
                userResult = (List<UserResult>) users;
                /**доделать ввод в бд**/
                db.execSQL("INSERT INTO users VALUES ('" + userResult.get(0).getRank() + "','" + userResult.get(0).getHandle() + "', '" + userResult.get(0).getFirstName() + "','" + userResult.get(0).getLastName() + "','" + userResult.get(0).getRating().toString() + "','" + userResult.get(0).getMaxRating().toString() + "','" + userResult.get(0).getMaxRank() + "','" + userResult.get(0).getContribution().toString() + "','" + userResult.get(0).getFriendOfCount().toString() + "');");
                Log.d("RETROFIT", userResult.toString());
                // insert into LOCAL DB (variant1)
                // insert into fragment in bundle(variant2)
                // insert into sherperf (variant3)

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(getApplicationContext(),"Пользователь введен не верно",Toast.LENGTH_SHORT).show();
            }
        });



    }

    public void onEnterWithout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
