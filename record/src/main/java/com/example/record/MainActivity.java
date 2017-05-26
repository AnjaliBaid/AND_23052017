package com.example.record;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void left(View view){
        populateImage(R.drawable.ic_arrow_back_black_24dp);
    }

    public void up (View view){
        populateImage(R.drawable.ic_arrow_upward_black_24dp);
    }

    public void Right(View view){
        populateImage(R.drawable.ic_arrow_forward_black_24dp);
    }

    private void  populateImage(int image){
        ImageView img = (ImageView) findViewById(R.id.imgDirect);
        img.setImageResource(image);
    }
}
