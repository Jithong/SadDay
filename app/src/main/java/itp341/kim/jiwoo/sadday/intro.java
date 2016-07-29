package itp341.kim.jiwoo.sadday;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

public class intro extends AppCompatActivity {

    private ImageView openingImageView;

    Button resetButton; // tester; reset all data

    boolean start = false;

    private static final String PREF = "PREF";
    private static final String PREF_DAYLIST = "PREF_DAYLIST";
    private static final String PREF_START = "PREF_START";

    List<Day> dayList = new ArrayList<Day>();

    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getWindow().getDecorView().setBackgroundColor(Color.BLACK);

/*
        SharedPreferences prefs = getSharedPreferences(PREF,MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();
*/


        resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setVisibility(View.INVISIBLE);

        SharedPreferences prefs = getSharedPreferences(PREF, MODE_PRIVATE);
        start = prefs.getBoolean(PREF_START,false);
        if (start) {
            String jsonDayList = prefs.getString(PREF_DAYLIST, "");
            Log.d("READ JSON", "jsonDayList: " + jsonDayList);
            gson = new Gson();
            Type type = new TypeToken<List<Day>>(){}.getType();
            dayList = gson.fromJson(jsonDayList, type);
            Log.d("BOOTED", "OnCreate, dayList size: " + dayList.size());
        }

        openingImageView = (ImageView) findViewById(R.id.openingImageView);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences(PREF,MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.clear();
                editor.commit();

            }
        });


        // start the open fragment
        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.frameLayout);
        f = new existingUserFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, f);
        ft.commit();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // a day was saved. making a day instance
        if (resultCode == 0) {
            int food = data.getIntExtra("FOOD", 0);
            int sleep = data.getIntExtra("SLEEP", 0);
            int fun = data.getIntExtra("FUN", 0);
            int relationships = data.getIntExtra("RELATIONSHIPS", 0);
            Day day = new Day(food, sleep, fun, relationships);
            Log.d("I just clicked save", "DATA: " + food + " " + sleep + " " + fun + " " + relationships
                    + " " + day.getDate());
            dayList.add(day);
            gson = new Gson();
            String jsonDayList = gson.toJson(dayList);
            Log.d("I just converted json", "jsonDays: " + jsonDayList);

            SharedPreferences prefs = getSharedPreferences(PREF, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(PREF_DAYLIST,jsonDayList);
            editor.putBoolean(PREF_START,true);
            editor.commit();

        }
        if (resultCode == 1) {
            // you canceled the day. nothing happens
        }

        if (resultCode == 2) {
            // you pressed back from history; nothing happened
        }
    }

    public String getListData() {
        gson = new Gson();
        String jsonDayList = gson.toJson(dayList);
        return jsonDayList;
    }
}
