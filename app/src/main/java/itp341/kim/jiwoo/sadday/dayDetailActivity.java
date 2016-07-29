package itp341.kim.jiwoo.sadday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class dayDetailActivity extends Activity {

    BarChart barChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_detail);

        Intent intent = getIntent();
        float food = intent.getIntExtra("FOOD", 0);
        float sleep = intent.getIntExtra("SLEEP", 0);
        float fun = intent.getIntExtra("FUN",0);
        float relationships = intent.getIntExtra("RELATIONSHIPS", 0);
        String date = intent.getStringExtra("DATE");

        barChart = (BarChart) findViewById(R.id.barChart);

        // usability report - scaling of y axis

        barChart.getAxisLeft().setAxisMaxValue(10f);
        barChart.getAxisLeft().setAxisMinValue(0f);
        barChart.getAxisLeft().setStartAtZero(true);
        barChart.getAxisRight().setDrawGridLines(false);
        barChart.getAxisRight().setDrawLabels(false);


        // vertical axis
        ArrayList<BarEntry> ratings = new ArrayList<>();
        ratings.add(new BarEntry(food, 0));
        ratings.add(new BarEntry(sleep, 1));
        ratings.add(new BarEntry(fun, 2));
        ratings.add(new BarEntry(relationships, 3));

        BarDataSet barDataSet = new BarDataSet(ratings, "rating");


        //horizontal axis
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Food");
        labels.add("Sleep");
        labels.add("Fun");
        labels.add("Relationships");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData data = new BarData(labels, barDataSet);
        barChart.setData(data);

        barChart.setDescription("Your rating of each category on this day");
    }
}
