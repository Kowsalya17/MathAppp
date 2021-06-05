package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class learnd extends AppCompatActivity {
    Handler hanlder = new Handler();
    Runnable runnable;
    int delay=5000;
    String buttonAction="button1";
    private static String button1="button1";
    private static String button2="button2";
    Button bt1,bt2;

    private static final String TAG = learnd.class.getSimpleName();
    ImageButton sound1;
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
    int[] soundd = new int[]{
            R.raw.sun,
            R.raw.mon,
            R.raw.tues,
            R.raw.wed,
            R.raw.thurs,
            R.raw.fri,
            R.raw.sat,
    };
    int currentShapeSound = soundd[0];

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learnd);
        bt1=(Button)findViewById(R.id.prev);
        bt2=(Button)findViewById(R.id.next);
        findViews();

        mediaPlayer = MediaPlayer.create(learnd.this, currentShapeSound);
        mediaPlayer.start();

        sound1.setOnClickListener(v -> {
            mediaPlayer = MediaPlayer.create(learnd.this, currentShapeSound);
            mediaPlayer.start();
        });
        uiSetup();
    }
    @Override
    protected void onResume() {
        hanlder.postDelayed(runnable=new Runnable() {
            @Override
            public void run() {
                hanlder.postDelayed(runnable,delay);
                setMovingAction();
            }
        },delay);
        super.onResume();
    }
    private void setMovingAction() {
        if (buttonAction.equals(button1)){
            bt2.setBackground(getResources().getDrawable(R.drawable.my_button_bg));
            bt1.setBackgroundColor(getResources().getColor(R.color.button));
            buttonAction=button2;
        }else if (buttonAction.equals(button2)){
            bt1.setBackground(getResources().getDrawable(R.drawable.my_button_bg));
            bt2.setBackgroundColor(getResources().getColor(R.color.button));
            buttonAction=button1;
        }
    }
        private void uiSetup() {
        days.setText(day1[day]);
        su.setText(sund[day]);
        sun.setImageResource(sunday[day]);
        }
        private void findViews() {
            sound1=(ImageButton)findViewById(R.id.sound1);
            days = (TextView) findViewById(R.id.days);
            su = (TextView) findViewById(R.id.su);
            sun = (ImageView) findViewById(R.id.sun);
        }


    public void next(View view){
        if(day<6) {
            day++;
            days.setText(day1[day]);
            su.setText(sund[day]);
            sun.setImageResource(sunday[day]);
            currentShapeSound = soundd[day];
            mediaPlayer = MediaPlayer.create(learnd.this,currentShapeSound);
            mediaPlayer.start();
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
            currentShapeSound = soundd[day];
            mediaPlayer = MediaPlayer.create(learnd.this,currentShapeSound);
            mediaPlayer.start();
        }
        else {
            Toast.makeText(this, "DAYS OF THE WEEK",Toast.LENGTH_SHORT).show();
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