package com.demo.open;

import android.content.Intent;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
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
