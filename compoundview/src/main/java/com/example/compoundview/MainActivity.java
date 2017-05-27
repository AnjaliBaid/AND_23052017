package com.example.compoundview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LayoutInflater inflater ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inflater =(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        inflater = LayoutInflater.from(this);
    }

    public void Dynamic (View view){

        FrameLayout Frame1 = (FrameLayout) findViewById(R.id.frame1);
        Frame1.removeAllViews();
        FrameLayout Frame2 = (FrameLayout) findViewById(R.id.frame2);
        Frame2.removeAllViews();

        View viewinflated1 = inflater.inflate(R.layout.linear,Frame1,true);
        ((CheckBox)viewinflated1.findViewById(R.id.chk)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                ((TextView) findViewById(R.id.txtDisplay)).setText(Boolean.toString(isChecked));
            }
        });

        View viewinflated2 = inflater.inflate(R.layout.linear,Frame2,false);
        Frame2.addView(viewinflated2);
        ((CheckBox)viewinflated2.findViewById(R.id.chk)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                ((TextView) findViewById(R.id.txtDisplay)).setText(Boolean.toString(isChecked));
            }
        });

    }
}
