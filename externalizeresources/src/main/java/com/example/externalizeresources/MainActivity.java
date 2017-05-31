package com.example.externalizeresources;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] Cources = getResources().getStringArray(R.array.Cources);

        String  title = getResources().getString(R.string.title);

        int color= ContextCompat.getColor(this,R.color.colorAccent);

    }
}
