package com.demo.open;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.open.databinding.ActivityCircleLoadingBinding;
import com.demo.open.databinding.ActivityMainBinding;

/**
 * @purpose Created by Runt (qingingrunt2010@qq.com) on 2022/10/26.
 */
public class CircleLoadingActivity extends AppCompatActivity {

    ActivityCircleLoadingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCircleLoadingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imgClose.setOnClickListener(v->{finish();});
        AudioManager manager = (AudioManager) getSystemService(AUDIO_SERVICE);
        if(manager != null){
            manager.requestAudioFocus(new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {

                }
            },AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        }
        //AnimationScaleListDrawable
        AnimatedVectorDrawable loadingDrawable = (AnimatedVectorDrawable) binding.loading.getIndeterminateDrawable();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            loadingDrawable.registerAnimationCallback(new Animatable2.AnimationCallback() {
                @Override
                public void onAnimationStart(Drawable drawable) {
                    super.onAnimationStart(drawable);
                }

                @Override
                public void onAnimationEnd(Drawable drawable) {
                    super.onAnimationEnd(drawable);
                    loadingDrawable.start();
                }
            });
        }
    }
}
