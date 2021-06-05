package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class dice extends AppCompatActivity {
    Handler hanlder = new Handler();
    Runnable runnable;
    int delay=5000;
    String buttonAction="button1";
    private static String button1="button1";
    private static String button2="button2";
    private static String button3="button3";
    Button bt1,bt2,bt3;

    Button b_roll,b_even,b_odd;
    TextView tv_cpu,tv_you,tv_status;
    ImageView iv_dice1,iv_dice2;
    int cpuPoints = 0, youPoints = 0;
    String currentPick = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        bt1=(Button)findViewById(R.id.b_even);
        bt2=(Button)findViewById(R.id.b_roll);
        bt3=(Button)findViewById(R.id.b_odd);

        b_roll=(Button)findViewById(R.id.b_roll);
        b_even=(Button)findViewById(R.id.b_even);
        b_odd=(Button)findViewById(R.id.b_odd);
        tv_cpu=(TextView)findViewById(R.id.tv_cpu);
        tv_you=(TextView)findViewById(R.id.tv_you);
        tv_status=(TextView)findViewById(R.id.tv_status);
        iv_dice1=(ImageView)findViewById(R.id.iv_dice1);
        iv_dice2=(ImageView)findViewById(R.id.iv_dice2);
        b_roll.setVisibility(View.INVISIBLE);

        b_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int firstDice =random.nextInt(6) + 1;
                int secondDice =random.nextInt(6) + 1;
                setImages(firstDice,secondDice);
                int sum=firstDice + secondDice;
                int left= sum % 2;
                if (currentPick.equals("even")){
                    if (left == 0){
                        youPoints++;
                    }
                    if (left != 0){
                        cpuPoints++;
                    }
                }
                if (currentPick.equals("odd")){
                    if (left == 0){
                        cpuPoints++;
                    }
                    if (left != 0){
                        youPoints++;
                    }
                }
                //display points
                tv_cpu.setText("CPU: " + cpuPoints);
                tv_you.setText("YOU: " + youPoints);
                b_roll.setVisibility(View.INVISIBLE);
                b_even.setVisibility(View.VISIBLE);
                b_odd.setVisibility(View.VISIBLE);
                //Animation
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                iv_dice1.startAnimation(animation);
                iv_dice2.startAnimation(animation);
            }
        });
        b_even.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPick = "even";
                tv_status.setText(currentPick);
                b_roll.setVisibility(View.VISIBLE);
                b_even.setVisibility(View.INVISIBLE);
                b_odd.setVisibility(View.INVISIBLE);
            }
        });
        b_odd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPick = "odd";
                tv_status.setText(currentPick);
                b_roll.setVisibility(View.VISIBLE);
                b_even.setVisibility(View.INVISIBLE);
                b_odd.setVisibility(View.INVISIBLE);
            }
        });
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

    private void setImages(int dice1Number, int dice2Number){
        switch (dice1Number){
            case 1:
                iv_dice1.setImageResource(R.drawable.dice1);
                break;
            case 2:
                iv_dice1.setImageResource(R.drawable.dice2);
                break;
            case 3:
                iv_dice1.setImageResource(R.drawable.dice3);
                break;
            case 4:
                iv_dice1.setImageResource(R.drawable.dice4);
                break;
            case 5:
                iv_dice1.setImageResource(R.drawable.dice5);
                break;
            case 6:
                iv_dice1.setImageResource(R.drawable.dice6);
                break;
        }
        switch (dice2Number){
            case 1:
                iv_dice2.setImageResource(R.drawable.dice1);
                break;
            case 2:
                iv_dice2.setImageResource(R.drawable.dice2);
                break;
            case 3:
                iv_dice2.setImageResource(R.drawable.dice3);
                break;
            case 4:
                iv_dice2.setImageResource(R.drawable.dice4);
                break;
            case 5:
                iv_dice2.setImageResource(R.drawable.dice5);
                break;
            case 6:
                iv_dice2.setImageResource(R.drawable.dice6);
                break;
        }
    }
}