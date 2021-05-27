package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class learn extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        Button bt1=(Button)findViewById(R.id.button2);
        Button bt2=(Button)findViewById(R.id.button3);
        Button bt5=(Button)findViewById(R.id.button6);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1=new Intent(learn.this,measurements.class);
                startActivity(it1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it2=new Intent(learn.this,shapes.class);
                startActivity(it2);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it5=new Intent(learn.this,daymonths.class);
                startActivity(it5);
            }
        });

    }
}