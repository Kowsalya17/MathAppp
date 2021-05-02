package com.example.mathapp;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class learnshapes extends AppCompatActivity {

    private static final String TAG = learnshapes.class.getSimpleName();
    ImageButton ring;
    TextView shape;
    TextView is;
    ImageView tri;
    int shapes = 0;

    String[] shape2d = new String[]{
            "Circle",
            "Cone",
            "Cube",
            "Cuboid",
            "Cylinder",
            "Parallelogram",
            "Rectangle",
            "Rhombus",
            "Semi Circle",
            "Sphere",
            "Square",
            "Trapezium",
            "Triangle",
    };
    String[] isi = new String[]{
            "Circle Shape",
            "Cone Shape",
            "Cube Shape",
            "Cuboid Shape",
            "Cylinder Shape",
            "Parallelogram Shape",
            "Rectangle Shape",
            "Rhombus Shape",
            "Semi Circle Shape",
            "Sphere Shape",
            "Square Shape",
            "Trapezium Shape",
            "Triangle Shape",
    };
    int[] triangle = new int[]{
            R.drawable.circle,
            R.drawable.cone,
            R.drawable.cube,
            R.drawable.cuboid,
            R.drawable.cylinder,
            R.drawable.parallelogram,
            R.drawable.rectangle,
            R.drawable.rhombus,
            R.drawable.semi,
            R.drawable.sphere,
            R.drawable.square,
            R.drawable.trapezium,
            R.drawable.triangle
    };
    int[] sound = new int[]{
            R.raw.circlee,
            R.raw.cone,
            R.raw.cube,
            R.raw.cuboid,
            R.raw.cylinder,
            R.raw.parallelogram,
            R.raw.rectangle,
            R.raw.rhombus,
            R.raw.semi,
            R.raw.sphere,
            R.raw.square,
            R.raw.trapezium,
            R.raw.triangle,
    };
    int currentShapeSound = sound[0];

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learnshapes);
        findViews();

        mediaPlayer = MediaPlayer.create(learnshapes.this,currentShapeSound);
        mediaPlayer.start();

        ring.setOnClickListener(v -> {
            mediaPlayer = MediaPlayer.create(learnshapes.this,currentShapeSound);
            mediaPlayer.start();
        });
        uiSetup();
    }

    private void uiSetup() {
        shape.setText(shape2d[shapes]);
        is.setText(isi[shapes]);
        tri.setImageResource(triangle[shapes]);
    }

    private void findViews() {
        ring = findViewById(R.id.ring);
        shape = findViewById(R.id.shape);
        is = findViewById(R.id.is);
        tri = findViewById(R.id.tri);
    }

    public void next(View view){
        if(shapes<12) {
            shapes++;
            shape.setText(shape2d[shapes]);
            is.setText(isi[shapes]);
            tri.setImageResource(triangle[shapes]);
            currentShapeSound = sound[shapes];
            mediaPlayer = MediaPlayer.create(learnshapes.this,currentShapeSound);
            mediaPlayer.start();
        }
        else {
            Toast.makeText(this, "END OF SHAPES",Toast.LENGTH_SHORT).show();
        }
    }
    public void prev(View view){
        if(shapes>0) {
            shapes--;
            shape.setText(shape2d[shapes]);
            is.setText(isi[shapes]);
            tri.setImageResource(triangle[shapes]);
            currentShapeSound = sound[shapes];
            mediaPlayer = MediaPlayer.create(learnshapes.this,currentShapeSound);
            mediaPlayer.start();
        }
        else {
            Toast.makeText(this, "TYPES OF SHAPES",Toast.LENGTH_SHORT).show();
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