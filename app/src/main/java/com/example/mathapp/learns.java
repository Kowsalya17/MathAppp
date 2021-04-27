package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class learns extends AppCompatActivity {
    TextView seasons;
    TextView summ;
    ImageView sum;
    int season = 0;

    String[] sea = new String[]{
            "Summer",
            "Winter",
            "Autumn",
            "Spring",
    };
    String[] seas = new String[]{
            "SEASON - SUMMER",
            "SEASON - WINTER",
            "SEASON - AUTUMN",
            "SEASON - SPRING",
    };
    int[] seaso = new int[]{
            R.drawable.summer,
            R.drawable.winter,
            R.drawable.autumn,
            R.drawable.spring,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learns);

        seasons = (TextView)findViewById(R.id.months);
        summ = (TextView)findViewById(R.id.janu);
        sum = (ImageView)findViewById(R.id.jan);

        seasons.setText(sea[season]);
        summ.setText(seas[season]);
        sum.setImageResource(seaso[season]);
    }
    public void next(View view){
        if(season<3) {
            season++;
            seasons.setText(sea[season]);
            summ.setText(seas[season]);
            sum.setImageResource(seaso[season]);
        }
        else {
            Toast.makeText(this, "END OF SEASONS",Toast.LENGTH_SHORT).show();
        }
    }
    public void prev(View view){
        if(season>0) {
            season--;
            seasons.setText(sea[season]);
            summ.setText(seas[season]);
            sum.setImageResource(seaso[season]);
        }
        else {
            Toast.makeText(this, "SEASONS OF THE YEAR",Toast.LENGTH_SHORT).show();
        }
    }

}