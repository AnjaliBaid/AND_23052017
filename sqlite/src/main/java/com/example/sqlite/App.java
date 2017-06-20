package com.example.sqlite;

import android.app.Application;

/**
 * Created by anju on 20/6/17.
 */

public class App extends Application{

    private DbHelper helper;

    @Override
    public void onCreate() {
        super.onCreate();

        helper = new DbHelper(this,"code.sqlite",null,1);
    }

    public DbHelper helper(){
        return  helper;
    }
}
