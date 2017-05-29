package com.example.interactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class profileactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileactivity);


        Intent responsibleIntent = getIntent();
        Bundle bundle = responsibleIntent.getExtras();

        if (bundle!=null){

            String username = bundle.getString("KeyStr");
            ((TextView)findViewById(R.id.txtDisplay)).setText(username);

        }

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle=new Bundle();
                bundle.putString("key",getDevices());

                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
    private String getDevices(){
        return ((RadioGroup)findViewById(R.id.rgrp)).getCheckedRadioButtonId()== R.id.rbAndroid
                ? "Android"
                : "JAVA";
    }
}
