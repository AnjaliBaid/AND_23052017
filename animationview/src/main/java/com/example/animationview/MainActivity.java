package com.example.animationview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.mixed);
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
                findViewById(R.id.img).startAnimation(animation);
            }
        });
    }
}
