package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class daymonths extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daymonths);

        Button bt1=(Button)findViewById(R.id.button1);
        Button bt2=(Button)findViewById(R.id.button2);
        Button bt3=(Button)findViewById(R.id.button3);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1=new Intent(daymonths.this,learnd.class);
                startActivity(it1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it2=new Intent(daymonths.this,learnm.class);
                startActivity(it2);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it3=new Intent(daymonths.this,learns.class);
                startActivity(it3);
            }
        });
    }
}