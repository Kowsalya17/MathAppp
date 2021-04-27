package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class learnd extends AppCompatActivity {
    TextView days;
    TextView su;
    ImageView sun;
    int day = 0;

    String[] day1 = new String[]{
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
    };
    String[] sund = new String[]{
            "DAY - SUNDAY",
            "DAY - MONDAY",
            "DAY - TUESDAY",
            "DAY - WEDNESDAY",
            "DAY - THURSDAY",
            "DAY - FRIDAY",
            "DAY - SATURDAY",
    };
    int[] sunday = new int[]{
            R.drawable.sun,
            R.drawable.mon,
            R.drawable.tue,
            R.drawable.wed,
            R.drawable.thurs,
            R.drawable.fri,
            R.drawable.sat,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learnd);

        days = (TextView)findViewById(R.id.days);
        su = (TextView)findViewById(R.id.su);
        sun = (ImageView)findViewById(R.id.sun);

        days.setText(day1[day]);
        su.setText(sund[day]);
        sun.setImageResource(sunday[day]);
    }
    public void next(View view){
        if(day<6) {
            day++;
            days.setText(day1[day]);
            su.setText(sund[day]);
            sun.setImageResource(sunday[day]);
        }
        else {
            Toast.makeText(this, "END OF DAYS",Toast.LENGTH_SHORT).show();
        }
    }
    public void prev(View view){
        if(day>0) {
            day--;
            days.setText(day1[day]);
            su.setText(sund[day]);
            sun.setImageResource(sunday[day]);
        }
        else {
            Toast.makeText(this, "DAYS OF THE WEEK",Toast.LENGTH_SHORT).show();
        }
    }

}