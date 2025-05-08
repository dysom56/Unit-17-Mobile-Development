package com.example.unit_17_mobile_dev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WorkoutsActivity extends AppCompatActivity implements View.OnClickListener {
    Button water_screen;
    Button timer_screen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_workouts);

        water_screen = findViewById(R.id.WaterScreen2);
        timer_screen = findViewById(R.id.TimerScreen2);

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