package com.example.handleruntimechanges;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            ((ImageView)findViewById(R.id.img)).setImageResource(R.drawable.ic_sentiment_satisfied_black_24dp);
        }
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            ((ImageView)findViewById(R.id.img)).setImageResource(R.drawable.ic_insert_emoticon_black_24dp);
        }
        else
            ((ImageView)findViewById(R.id.img)).setImageResource(R.drawable.ic_sentiment_very_satisfied_black_24dp);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show();
    }


}
