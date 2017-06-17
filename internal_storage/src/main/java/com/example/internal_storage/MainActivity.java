package com.example.internal_storage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onWrite (View view) throws FileNotFoundException {

        File internalStorage = getFilesDir();
        Log.i(TAG,"Path -"+internalStorage.getAbsolutePath());

        try {
            FileOutputStream fos = openFileOutput("My.txt",MODE_APPEND);
            fos.write("this is codekul.com".getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onRead (View view){

        try {
            FileInputStream fis = openFileInput("My.txt");
            StringBuilder builder = new StringBuilder();
            while (true){
                    int ch = fis.read();
                    if (ch == -1) break;
                    else  builder.append((char)ch);
                }
                Log.i(TAG,builder.toString());
                ((TextView)findViewById(R.id.txtvw)).setText(builder.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}