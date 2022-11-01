package com.demo.open;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean isPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.image).setOnClickListener(v -> {
            ((ImageView)v).setImageResource(!isPause ?R.drawable.media_pause_animate:R.drawable.media_play_animate);
            AnimatedVectorDrawable drawable = (AnimatedVectorDrawable) ((ImageView)v).getDrawable();
            drawable.start();
            isPause = !isPause;

        });
    }
}