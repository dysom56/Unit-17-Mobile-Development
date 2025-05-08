package com.example.unit_17_mobile_dev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
    }

    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.WorkoutScreen) {
            Intent switchActivityIntent = new Intent(this, WorkoutsActivity.class);
            startActivity(switchActivityIntent);
        } else if (v.getId() == R.id.TimerScreen) {
            Intent switchActivityIntent = new Intent(this, TimerActivity.class);
            startActivity(switchActivityIntent);
        }
    }
}