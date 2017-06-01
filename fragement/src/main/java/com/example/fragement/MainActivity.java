package com.example.fragement;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LoadFragement(FirstFragment.getInstance(R.mipmap.ic_launcher));
    }
    public void LoadFragement(Fragment frag){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction txn = manager.beginTransaction();
        txn.setCustomAnimations(R.anim.animation,R.anim.animation_exit);
        txn.replace(R.id.framesecond,frag);
        txn.commit();

    }
}
