package com.example.unit_17_mobile_dev;

import android.content.Intent;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class WorkoutsActivity extends AppCompatActivity implements View.OnClickListener {
    Button water_screen;
    Button timer_screen;
    Button add_pushup;
    Button minus_pushup;
    Button add_situp;
    Button minus_situp;
    Button add_squat;
    Button minus_squat;
    Button add_dist;
    Button minus_dist;
    TextView pushup_text;
    TextView situp_text;
    TextView squat_text;
    TextView dist_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_workouts);

        water_screen = findViewById(R.id.WaterScreen2);
        timer_screen = findViewById(R.id.TimerScreen2);
        add_pushup = findViewById(R.id.AddPushup);
        minus_pushup = findViewById(R.id.MinusPushup);
        add_situp = findViewById(R.id.AddSitup);
        minus_situp = findViewById(R.id.MinusSitup);
        add_squat = findViewById(R.id.AddSquat);
        minus_squat = findViewById(R.id.MinusSquat);
        add_dist = findViewById(R.id.AddDist);
        minus_dist = findViewById(R.id.MinusDist);

        pushup_text = findViewById(R.id.PushupText);
        situp_text = findViewById(R.id.SitupText);
        squat_text = findViewById(R.id.SquatText);
        dist_text = findViewById(R.id.RunText);

        water_screen.setOnClickListener(this);
        timer_screen.setOnClickListener(this);
        add_pushup.setOnClickListener(this);
        minus_pushup.setOnClickListener(this);
        add_situp.setOnClickListener(this);
        minus_situp.setOnClickListener(this);
        add_squat.setOnClickListener(this);
        minus_squat.setOnClickListener(this);
        add_dist.setOnClickListener(this);
        minus_dist.setOnClickListener(this);

        // Set the text to variable saved in other class "SessionSaved"
        pushup_text.setText("Pushups: " + SessionSaved.pushups);
        situp_text.setText("Situps: " + SessionSaved.situps);
        squat_text.setText("Squats: " + SessionSaved.squats);
        dist_text.setText("Distance Ran: " + SessionSaved.dist + " m");
    }

    @Override
    public void onClick(View v) {
        // Pushup Buttons
        if (v.getId() == R.id.AddPushup) {
            String fullString = pushup_text.getText().toString();
            String num = fullString.replace("Pushups: ", "");
            SessionSaved.pushups = (Integer.parseInt(num)) + 1;

            String value = "Pushups: " + SessionSaved.pushups;

            pushup_text.setText(value);
        } else if (v.getId() == R.id.MinusPushup) {
            String fullString = pushup_text.getText().toString();
            String num = fullString.replace("Pushups: ", "");
            SessionSaved.pushups = (Integer.parseInt(num)) - 1;

            String value = "Pushups: " + SessionSaved.pushups;

            pushup_text.setText(value);
        }

        // Situp Buttons
        if (v.getId() == R.id.AddSitup) {
            String fullString = situp_text.getText().toString();
            String num = fullString.replace("Situps: ", "");
            SessionSaved.situps = (Integer.parseInt(num)) + 1;

            String value = "Situps: " + SessionSaved.situps;

            situp_text.setText(value);
        } else if (v.getId() == R.id.MinusSitup) {
            String fullString = situp_text.getText().toString();
            String num = fullString.replace("Situps: ", "");
            SessionSaved.situps = (Integer.parseInt(num)) - 1;

            String value = "Situps: " + SessionSaved.situps;

            situp_text.setText(value);
        }

        // Squat Buttons
        if (v.getId() == R.id.AddSquat) {
            String fullString = squat_text.getText().toString();
            String num = fullString.replace("Squats: ", "");
            SessionSaved.squats = (Integer.parseInt(num)) + 1;

            String value = "Squats: " + SessionSaved.squats;

            squat_text.setText(value);
        } else if (v.getId() == R.id.MinusSquat) {
            String fullString = squat_text.getText().toString();
            String num = fullString.replace("Squats: ", "");
            SessionSaved.squats = (Integer.parseInt(num)) - 1;

            String value = "Squats: " + SessionSaved.squats;

            squat_text.setText(value);
        }

        // Distance Buttons
        if (v.getId() == R.id.AddDist) {
            String fullString = dist_text.getText().toString();
            String num = fullString.replace("Distance Ran: ", "");
            num = num.replace(" m", "");
            SessionSaved.dist = (Integer.parseInt(num)) + 100;

            String value = "Distance Ran: " + SessionSaved.dist + " m";

            dist_text.setText(value);
        } else if (v.getId() == R.id.MinusDist) {
            String fullString = dist_text.getText().toString();
            String num = fullString.replace("Distance Ran: ", "");
            num = num.replace(" m", "");
            SessionSaved.dist = (Integer.parseInt(num)) - 100;

            String value = "Distance Ran: " + SessionSaved.dist + " m";

            dist_text.setText(value);
        }

        // Screen Swap Buttons
        if (v.getId() == R.id.WaterScreen2) {
            Intent switchActivityIntent = new Intent(this, MainActivity.class);
            startActivity(switchActivityIntent);
        } else if (v.getId() == R.id.TimerScreen2) {
            Intent switchActivityIntent = new Intent(this, TimerActivity.class);
            startActivity(switchActivityIntent);
        }
    }
}