package com.example.unit_17_mobile_dev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class TimerActivity extends AppCompatActivity implements View.OnClickListener {
    Button water_screen;
    Button workout_screen;
    Button add_time;
    Button minus_time;
    Button play_timer;
    Button pause_timer;
    Button reset_timer;
    TextView time_amount;
    Boolean pause = true;
    RadioGroup radioGroup;
    RadioButton set_timer;
    RadioButton set_stopwatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_timer);

        water_screen = findViewById(R.id.WaterScreen3);
        workout_screen = findViewById(R.id.WorkoutScreen3);
        add_time = findViewById(R.id.AddTime);
        minus_time = findViewById(R.id.MinusTime);
        play_timer = findViewById(R.id.PlayTimer);
        pause_timer = findViewById(R.id.PauseTimer);
        reset_timer = findViewById(R.id.ResetTimer);

        radioGroup = findViewById(R.id.TimeMeasure);
        set_timer = findViewById(R.id.SetAsTimer);
        set_stopwatch = findViewById(R.id.SetAsStopwatch);

        time_amount = findViewById(R.id.TimeAmount);

        water_screen.setOnClickListener(this);
        workout_screen.setOnClickListener(this);
        add_time.setOnClickListener(this);
        minus_time.setOnClickListener(this);
        play_timer.setOnClickListener(this);
        pause_timer.setOnClickListener(this);
        reset_timer.setOnClickListener(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);

                if (String.valueOf(rb.getText()).equals("Timer")) {
                    SessionSaved.isTimerChecked = true;
                    //isTimer = true;
                    add_time.setVisibility(View.VISIBLE);
                    minus_time.setVisibility(View.VISIBLE);
                    set0Time();
                } else if (String.valueOf(rb.getText()).equals("Stopwatch")) {
                    SessionSaved.isTimerChecked = false;
                    //isTimer = false;
                    add_time.setVisibility(View.GONE);
                    minus_time.setVisibility(View.GONE);
                    set0Time();
                }
            }
        });

        if (SessionSaved.isTimerChecked) {
            add_time.setVisibility(View.VISIBLE);
            minus_time.setVisibility(View.VISIBLE);
            set_timer.setChecked(true);
            set_stopwatch.setChecked(false);
            set0Time();
        } else if (SessionSaved.isTimerChecked == false) {
            add_time.setVisibility(View.GONE);
            minus_time.setVisibility(View.GONE);
            set_stopwatch.setChecked(true);
            set_timer.setChecked(false);
            set0Time();
        }

        set_up_timer();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.PlayTimer) {
            pause = false;
        } else if (v.getId() == R.id.PauseTimer) {
            pause = true;
        } else if (v.getId() == R.id.ResetTimer) {
            set0Time();
        }

        if (v.getId() == R.id.AddTime) {
            SessionSaved.time += 10;
            time_amount.setText(Integer.toString(SessionSaved.time));
        } else if (v.getId() == R.id.MinusTime) {
            if (SessionSaved.time >= 10) {
                SessionSaved.time -= 10;
                time_amount.setText(Integer.toString(SessionSaved.time));
            }
        }

        if (v.getId() == R.id.WorkoutScreen3) {
            Intent switchActivityIntent = new Intent(this, WorkoutsActivity.class);
            startActivity(switchActivityIntent);
        } else if (v.getId() == R.id.WaterScreen3) {
            Intent switchActivityIntent = new Intent(this, WaterActivity.class);
            startActivity(switchActivityIntent);
        }
    }

    public void set_up_timer() {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (!pause) {
                            if (SessionSaved.isTimerChecked) {
                                if (SessionSaved.time >= 1) {
                                    SessionSaved.time = SessionSaved.time - 1;
                                    time_amount.setText(Integer.toString(SessionSaved.time));
                                }
                            } else if (!SessionSaved.isTimerChecked) {
                                SessionSaved.time = SessionSaved.time + 1;
                                time_amount.setText(Integer.toString(SessionSaved.time));
                            }
                        }
                    }
                });
            }
        }, 0, 1000);
    }

    public void set0Time() {
        pause = true;
        SessionSaved.time = 0;
        time_amount.setText("0");
    }
}