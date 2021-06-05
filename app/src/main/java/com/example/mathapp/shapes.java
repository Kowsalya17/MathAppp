package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class shapes extends AppCompatActivity {
    Handler hanlder = new Handler();
    Runnable runnable;
    int delay=5000;
    String buttonAction="button1";
    private static String button1="button1";
    private static String button2="button2";
    Button bt1,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes);

        bt1=(Button)findViewById(R.id.button8);
        bt2=(Button)findViewById(R.id.button10);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1=new Intent(shapes.this,learnshapes.class);
                startActivity(it1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it2=new Intent(shapes.this,video.class);
                startActivity(it2);
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
            bt1.setBackgroundColor(getResources().getColor(R.color.button));
            buttonAction=button2;
        }else if (buttonAction.equals(button2)){
            bt1.setBackground(getResources().getDrawable(R.drawable.my_button_bg));
            bt2.setBackgroundColor(getResources().getColor(R.color.button));
            buttonAction=button1;
        }
    }
}
