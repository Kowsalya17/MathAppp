package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class learnm extends AppCompatActivity {
    TextView months;
    TextView janu;
    ImageView jan;
    int month = 0;

    String[] mon = new String[]{
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December",
    };
    String[] mont = new String[]{
            "MONTH - JANUARY",
            "MONTH - FEBRUARY",
            "MONTH - MARCH",
            "MONTH - APRIL",
            "MONTH - MAY",
            "MONTH - JUNE",
            "MONTH - JULY",
            "MONTH - AUGUST",
            "MONTH - SEPTEMBER",
            "MONTH - OCTOBER",
            "MONTH - NOVEMBER",
            "MONTH - DECEMBER",
    };
    int[] monthss = new int[]{
            R.drawable.jan,
            R.drawable.feb,
            R.drawable.mar,
            R.drawable.apr,
            R.drawable.may,
            R.drawable.jun,
            R.drawable.july,
            R.drawable.aug,
            R.drawable.sept,
            R.drawable.oct,
            R.drawable.nov,
            R.drawable.dec,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learnm);

        months = (TextView)findViewById(R.id.months);
        janu = (TextView)findViewById(R.id.janu);
        jan = (ImageView)findViewById(R.id.jan);

        months.setText(mon[month]);
        janu.setText(mont[month]);
        jan.setImageResource(monthss[month]);
    }
    public void next(View view){
        if(month<11) {
            month++;
            months.setText(mon[month]);
            janu.setText(mont[month]);
            jan.setImageResource(monthss[month]);
        }
        else {
            Toast.makeText(this, "END OF MONTHS",Toast.LENGTH_SHORT).show();
        }
    }
    public void prev(View view){
        if(month>0) {
            month--;
            months.setText(mon[month]);
            janu.setText(mont[month]);
            jan.setImageResource(monthss[month]);
        }
        else {
            Toast.makeText(this, "MONTHS OF THE YEAR",Toast.LENGTH_SHORT).show();
        }
    }

}