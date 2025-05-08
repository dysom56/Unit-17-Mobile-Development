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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int increment;
    Button workout_screen;
    Button water_screen;
    Button timer_screen;
    Button add_water;
    Button minus_water;
    TextView water_drunk;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        workout_screen = findViewById(R.id.WorkoutScreen);
        water_screen = findViewById(R.id.WaterScreen);
        timer_screen = findViewById(R.id.TimerScreen);
        add_water = findViewById(R.id.AddWater);
        minus_water = findViewById(R.id.MinusWater);
        water_drunk = findViewById(R.id.WaterDrunk);
        radioGroup = findViewById(R.id.WaterRadioGroup);

        add_water.setOnClickListener(this);
        minus_water.setOnClickListener(this);
        workout_screen.setOnClickListener(this);
        timer_screen.setOnClickListener(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                Toast.makeText(getApplicationContext(), "Selected: " + rb.getText(), Toast.LENGTH_SHORT).show();

                String getIncrement = String.valueOf(rb.getText());
                getIncrement = getIncrement.replace("ml", "");

                increment = Integer.parseInt(getIncrement);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.AddWater) {
            String water = (water_drunk.getText().toString());
            water = water.replace(" ml", "");

            int realWater = Integer.parseInt(water) + increment;
            water = (Integer.toString(realWater)) + " ml";

            water_drunk.setText(water);
        } else if (v.getId() == R.id.MinusWater) {
            String water = (water_drunk.getText().toString());
            water = water.replace(" ml", "");

            int realWater = Integer.parseInt(water) - increment;
            water = (Integer.toString(realWater)) + " ml";

            water_drunk.setText(water);
        }

        if (v.getId() == R.id.WorkoutScreen) {
            Intent switchActivityIntent = new Intent(this, WorkoutsActivity.class);
            startActivity(switchActivityIntent);
        } else if (v.getId() == R.id.TimerScreen) {
            Intent switchActivityIntent = new Intent(this, TimerActivity.class);
            startActivity(switchActivityIntent);
        }
    }
}