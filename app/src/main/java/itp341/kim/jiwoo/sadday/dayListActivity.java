package itp341.kim.jiwoo.sadday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class dayListActivity extends AppCompatActivity {

    Button backButton;

    String jsonData;

    // List<Day> dayList = new ArrayList<Day>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_list);

        Intent i = getIntent();
        jsonData = i.getStringExtra("DAYLIST");

        /* i don't think i need this...

        Gson gson = new Gson();
        Type type = new TypeToken<List<Day>>(){}.getType();
        dayList = gson.fromJson(jsonDayList, type);
        Log.d("In dayListActivity", "In dayListActivity; just parsed list. size: " + dayList.size());

        */
        backButton = (Button) findViewById(R.id.backToMenuButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), intro.class);
                setResult(2,i);
                finish();
            }
        });
        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.frameLayout2);
        f = new dayListFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout2, f);
        ft.commit();
    }

    public String getJsonData() {
        return jsonData;
    }
}
