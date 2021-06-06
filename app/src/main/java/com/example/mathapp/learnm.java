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

public class learnm extends AppCompatActivity {
    Handler hanlder = new Handler();
    Runnable runnable;
    int delay=2000;
    String buttonAction="button1";
    private static String button1="button1";
    private static String button2="button2";
    private static String button3="button3";
    Button bt1,bt2;
    ImageButton bt3;

    private static final String TAG = learnm.class.getSimpleName();
    ImageButton sound2;
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
    int[] soundm = new int[]{
            R.raw.jan,
            R.raw.feb,
            R.raw.mar,
            R.raw.apr,
            R.raw.may,
            R.raw.jun,
            R.raw.jul,
            R.raw.aug,
            R.raw.sept,
            R.raw.oct,
            R.raw.nov,
            R.raw.dec,
    };
    int currentShapeSound = soundm[0];

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learnm);
        bt1=(Button)findViewById(R.id.previous1);
        bt2=(Button)findViewById(R.id.next1);
        bt3=(ImageButton)findViewById(R.id.sound2);
        findViews();

        mediaPlayer = MediaPlayer.create(learnm.this, currentShapeSound);
        mediaPlayer.start();

        sound2.setOnClickListener(v -> {
            mediaPlayer = MediaPlayer.create(learnm.this, currentShapeSound);
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
            bt3.setBackgroundColor(getResources().getColor(R.color.button));
            bt1.setBackgroundColor(getResources().getColor(R.color.button));
            buttonAction=button2;
        }else if (buttonAction.equals(button2)){
            bt3.setBackground(getResources().getDrawable(R.drawable.my_button_bg));
            bt2.setBackgroundColor(getResources().getColor(R.color.button));
            bt1.setBackgroundColor(getResources().getColor(R.color.button));
            buttonAction=button3;
        }else if (buttonAction.equals(button3)){
            bt1.setBackground(getResources().getDrawable(R.drawable.my_button_bg));
            bt3.setBackgroundColor(getResources().getColor(R.color.button));
            bt2.setBackgroundColor(getResources().getColor(R.color.button));
            buttonAction=button1;
        }
    }
    private void uiSetup() {
        months.setText(mon[month]);
        janu.setText(mont[month]);
        jan.setImageResource(monthss[month]);
    }
    private void findViews() {
        sound2=(ImageButton)findViewById(R.id.sound2);
        months = (TextView) findViewById(R.id.months);
        janu = (TextView) findViewById(R.id.janu);
        jan = (ImageView) findViewById(R.id.jan);
    }

    public void next(View view){
        if(month<11) {
            month++;
            months.setText(mon[month]);
            janu.setText(mont[month]);
            jan.setImageResource(monthss[month]);
            currentShapeSound = soundm[month];
            mediaPlayer = MediaPlayer.create(learnm.this,currentShapeSound);
            mediaPlayer.start();
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
            currentShapeSound = soundm[month];
            mediaPlayer = MediaPlayer.create(learnm.this,currentShapeSound);
            mediaPlayer.start();
        }
        else {
            Toast.makeText(this, "MONTHS OF THE YEAR",Toast.LENGTH_SHORT).show();
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