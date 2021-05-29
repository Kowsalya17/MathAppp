package com.example.mathapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class anagram extends AppCompatActivity {
    TextView tv_info,tv_word;
    EditText et_guess;
    Button b_check,b_new;
    Random r;
    String currentWord;
    ImageView img;

    String[] dictionary={
            "circle",
            "cone",
            "cube",
            "cuboid",
            "cylinder",
            "parallelogram",
            "rectangle",
            "rhombus",
            "semicircle",
            "sphere",
            "square",
            "trapezium",
            "triangle"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anagram);
        tv_info=(TextView)findViewById(R.id.tv_info);
        tv_word=(TextView)findViewById(R.id.tv_word);
        et_guess=(EditText)findViewById(R.id.et_guess);
        b_check=(Button)findViewById(R.id.b_check);
        b_new=(Button) findViewById(R.id.b_new);
        img=(ImageView)findViewById(R.id.imgView);

        r=new Random();
        newGame();


        b_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_guess.getText().toString().equalsIgnoreCase(currentWord)) {
                    if(et_guess.getText().toString().trim().equalsIgnoreCase(currentWord)){
                    tv_info.setText("Awesome!");
                    b_check.setEnabled(false);
                    b_new.setEnabled(true);
                    setImage(currentWord);
                    newGame();
                } else  {
                    tv_info.setText("Try Again!");
                }
            }
        });

        b_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
            }
        });
    }
            private void setImage(String currentWord){
            if(currentWord.equals("circle")){
                img.setBackgroundResource(R.drawable.circle);
                }else if(currentWord.equals("cone")){
                img.setBackgroundResource(R.drawable.cone);
                }else if(currentWord.equals("cube")){
                img.setBackgroundResource(R.drawable.cube);
                }else if(currentWord.equals("cuboid")){
                img.setBackgroundResource(R.drawable.cuboid);
                }else if(currentWord.equals("cylinder")){
                img.setBackgroundResource(R.drawable.cylinder);
                }else if(currentWord.equals("parallelogram")){
                img.setBackgroundResource(R.drawable.parallelogram);
                }else if(currentWord.equals("rectangle")){
                img.setBackgroundResource(R.drawable.rectangle);
                }else if(currentWord.equals("rhombus")){
                img.setBackgroundResource(R.drawable.rhombus);
                }else if(currentWord.equals("semicircle")){
                img.setBackgroundResource(R.drawable.semi);
                }else if(currentWord.equals("sphere")){
                img.setBackgroundResource(R.drawable.shapes);
                }else if(currentWord.equals("square")){
                img.setBackgroundResource(R.drawable.square);
                }else if(currentWord.equals("trapezium")){
                img.setBackgroundResource(R.drawable.trapezium);
                }else if(currentWord.equals("triangle")){
                img.setBackgroundResource(R.drawable.triangle);
                }
            }

    private String shuffledWord(String word) {
        List<String> letters = Arrays.asList(word.split(""));
        Collections.shuffle(letters);
        String shuffled ="";
        for (String letter : letters ){
            shuffled+=letter;
        }
        return shuffled;
    }
    private void  newGame(){
        currentWord = dictionary[r.nextInt(dictionary.length)];
        setImage(currentWord);
        tv_word.setText(shuffledWord(currentWord));
        et_guess.setText("");
        b_new.setEnabled(false);
        b_check.setEnabled(true);

    }

}