package com.example.mathapp;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class quiz extends AppCompatActivity {
    Button btn_start,btn_answer0,btn_answer1,btn_answer2,btn_answer3;
    TextView tv_score,tv_questions,tv_timer,tv_bottommessage;
    ProgressBar prog_timer;
    Gaming g = new Gaming();
    int secondsRemaining=45;

    CountDownTimer timer = new CountDownTimer(45000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            secondsRemaining--;
            tv_timer.setText(Integer.toString(secondsRemaining) + "sec");
            prog_timer.setProgress(45 - secondsRemaining);
        }
        @Override
        public void onFinish() {
            btn_answer0.setEnabled(false);
            btn_answer1.setEnabled(false);
            btn_answer2.setEnabled(false);
            btn_answer3.setEnabled(false);
            tv_bottommessage.setText("TIME UP! " + g.getNumberCorrect() + "/" + (g.getTotalQuestions() - 1));

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                   btn_start.setVisibility(View.VISIBLE);
                }
            }, 4000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        btn_start=findViewById(R.id.btn_start);
        btn_answer0=findViewById(R.id.btn_answer0);
        btn_answer1=findViewById(R.id.btn_answer1);
        btn_answer2=findViewById(R.id.btn_answer2);
        btn_answer3=findViewById(R.id.btn_answer3);

        tv_score=findViewById(R.id.tv_score);
        tv_questions=findViewById(R.id.tv_questions);
        tv_timer=findViewById(R.id.tv_timer);
        tv_bottommessage=findViewById(R.id.tv_bottommessage);
        prog_timer=findViewById(R.id.prog_timer);

        tv_timer.setText("0Sec");
        tv_questions.setText("");
        tv_bottommessage.setText("Press GO");
        tv_score.setText("0Pts");
        prog_timer.setProgress(0);

        btn_answer0.setEnabled(false);
        btn_answer1.setEnabled(false);
        btn_answer2.setEnabled(false);
        btn_answer3.setEnabled(false);

        View.OnClickListener startButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button start_button =  (Button) v;
                start_button.setVisibility(View.INVISIBLE);
                secondsRemaining = 45;
                g = new Gaming();
                nextTurn();
                timer.start();
            }
        };

        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonClicked =  (Button) v;
                int answerSelected=Integer.parseInt(buttonClicked.getText().toString());
                g.checkAnswer(answerSelected);
                if(g.checkAnswer(answerSelected)){
                    buttonClicked.setBackgroundColor(getResources().getColor(R.color.success));
                    }else{
                    buttonClicked.setBackgroundColor(getResources().getColor(R.color.error));
                    }
                tv_score.setText(Integer.toString(g.getScore()));

                final Handler handler=new Handler();
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run(){
                        nextTurn();
                        }
                    },500);
            }
        };
        btn_start.setOnClickListener(startButtonClickListener);
        btn_answer0.setOnClickListener(answerButtonClickListener);
        btn_answer1.setOnClickListener(answerButtonClickListener);
        btn_answer2.setOnClickListener(answerButtonClickListener);
        btn_answer3.setOnClickListener(answerButtonClickListener);
    }
    private void nextTurn() {
        g.makeNewQuestion();
        int [] answer = g.getCurrentQuestion().getAnswerArray();
        btn_answer0.setBackgroundColor(getResources().getColor(R.color.b1));
        btn_answer1.setBackgroundColor(getResources().getColor(R.color.b2));
        btn_answer2.setBackgroundColor(getResources().getColor(R.color.b3));
        btn_answer3.setBackgroundColor(getResources().getColor(R.color.b4));

        btn_answer0.setText(Integer.toString(answer[0]));
        btn_answer1.setText(Integer.toString(answer[1]));
        btn_answer2.setText(Integer.toString(answer[2]));
        btn_answer3.setText(Integer.toString(answer[3]));

        btn_answer0.setEnabled(true);
        btn_answer1.setEnabled(true);
        btn_answer2.setEnabled(true);
        btn_answer3.setEnabled(true);
        tv_questions.setText(g.getCurrentQuestion().getQuestionPhase());
        tv_bottommessage.setText(g.getNumberCorrect() + "/" + ( g.getTotalQuestions() - 1 ));
    }
}