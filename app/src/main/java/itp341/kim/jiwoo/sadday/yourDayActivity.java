package itp341.kim.jiwoo.sadday;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class yourDayActivity extends Activity {

    int foodRate;
    TextView foodRateTextView;
    SeekBar foodSeekBar;

    int sleepRate;
    TextView sleepRateTextView;
    SeekBar sleepSeekBar;

    int funRate;
    TextView funRateTextView;
    SeekBar funSeekBar;

    int relationshipsRate;
    TextView relationshipsRateTextView;
    SeekBar relationshipsSeekBar;

    Button saveButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_day);

        foodRateTextView = (TextView) findViewById(R.id.foodRateTextView);
        foodSeekBar = (SeekBar) findViewById(R.id.foodSeekBar);

        sleepRateTextView = (TextView) findViewById(R.id.sleepRateTextView);
        sleepSeekBar = (SeekBar) findViewById(R.id.sleepSeekBar);

        funRateTextView = (TextView) findViewById(R.id.funRateTextView);
        funSeekBar = (SeekBar) findViewById(R.id.funSeekBar);

        relationshipsRateTextView = (TextView) findViewById(R.id.relationshipsRateTextView);
        relationshipsSeekBar = (SeekBar) findViewById(R.id.relationshipsSeekBar);

        saveButton = (Button) findViewById(R.id.saveButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        foodSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                foodRate = progress;
                foodRateTextView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sleepSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sleepRate = progress;
                sleepRateTextView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        funSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                funRate = progress;
                funRateTextView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        relationshipsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                relationshipsRate = progress;
                relationshipsRateTextView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), intro.class);
                i.putExtra("FOOD",foodRate);
                i.putExtra("SLEEP",sleepRate);
                i.putExtra("FUN",funRate);
                i.putExtra("RELATIONSHIPS",relationshipsRate);
                setResult(0,i);
                finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), intro.class);
                setResult(1,i);
                finish();
            }
        });
    }
}
