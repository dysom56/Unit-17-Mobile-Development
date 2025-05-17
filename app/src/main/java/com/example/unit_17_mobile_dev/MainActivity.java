package com.example.unit_17_mobile_dev;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.se.omapi.Session;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int increment;
    Button workout_screen;
    Button water_screen;
    Button timer_screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        workout_screen = findViewById(R.id.WorkoutScreen4);
        water_screen = findViewById(R.id.WaterScreen4);
        timer_screen = findViewById(R.id.TimerScreen4);

        water_screen.setOnClickListener(this);
        workout_screen.setOnClickListener(this);
        timer_screen.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.WorkoutScreen4) {
            Intent switchActivityIntent = new Intent(this, WorkoutsActivity.class);
            startActivity(switchActivityIntent);
        } else if (v.getId() == R.id.TimerScreen4) {
            Intent switchActivityIntent = new Intent(this, TimerActivity.class);
            startActivity(switchActivityIntent);
        } else if (v.getId() == R.id.WaterScreen4) {
            Intent switchActivityIntent = new Intent(this, WaterActivity.class);
            startActivity(switchActivityIntent);
        }
    }
}