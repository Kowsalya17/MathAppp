package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class learns extends AppCompatActivity {
    private static final String TAG = learns.class.getSimpleName();
    ImageButton sound3;
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
    int[] sounds = new int[]{
            R.raw.summ,
            R.raw.wint,
            R.raw.aut,
            R.raw.spr,
    };
    int currentShapeSound = sounds[0];

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learns);
        findViews();

        mediaPlayer = MediaPlayer.create(learns.this, currentShapeSound);
        mediaPlayer.start();

        sound3.setOnClickListener(v -> {
            mediaPlayer = MediaPlayer.create(learns.this, currentShapeSound);
            mediaPlayer.start();
        });
        uiSetup();
    }
    private void uiSetup() {
        seasons.setText(sea[season]);
        summ.setText(seas[season]);
        sum.setImageResource(seaso[season]);
    }
    private void findViews() {
        seasons = (TextView) findViewById(R.id.months);
        summ = (TextView) findViewById(R.id.janu);
        sum = (ImageView) findViewById(R.id.jan);
    }

    public void next(View view){
        if(season<3) {
            season++;
            seasons.setText(sea[season]);
            summ.setText(seas[season]);
            sum.setImageResource(seaso[season]);
            currentShapeSound = sounds[season];
            mediaPlayer = MediaPlayer.create(learns.this,currentShapeSound);
            mediaPlayer.start();
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
            currentShapeSound = sounds[season];
            mediaPlayer = MediaPlayer.create(learns.this,currentShapeSound);
            mediaPlayer.start();
        }
        else {
            Toast.makeText(this, "SEASONS OF THE YEAR",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}