package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("MATH APPLICATION");

        Button bt1=(Button)findViewById(R.id.button);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1=new Intent(MainActivity.this,learn.class);
                startActivity(int1);

            }
        });
        Button bt2=(Button)findViewById(R.id.button1);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2=new Intent(MainActivity.this,quiz.class);
                startActivity(int2);

            }
        });
        Button bt3=(Button)findViewById(R.id.button2);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3=new Intent(MainActivity.this,game.class);
                startActivity(int3);

            }
        });
    }

    }
