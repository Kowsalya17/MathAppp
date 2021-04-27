package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class quiz extends AppCompatActivity {
    TextView textv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Button startbutton=(Button)findViewById(R.id.button);
        final EditText nametext=(EditText)findViewById(R.id.editName);
        textv=(TextView)findViewById(R.id.text);

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nametext.getText().toString();
                Intent intent=new Intent(getApplicationContext(),quiz_questions.class);
                intent.putExtra("myname",name);
                startActivity(intent);
            }
            public void timer(View view) {
                CountDownTimer countDownTimer = new CountDownTimer(60*1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        textv.setText("Countdown :"+millisUntilFinished/1000);
                    }

                    @Override
                    public void onFinish() {
                        textv.setText("Countdown End");

                    }
                }.start();
            }

        });
    }

}
