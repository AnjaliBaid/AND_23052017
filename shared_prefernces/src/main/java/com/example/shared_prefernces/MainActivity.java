package com.example.shared_prefernces;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getName();

    private SharedPreferences Prefs ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Prefs = getSharedPreferences("My_Prefs",MODE_APPEND);
    }

    public void onWrite(View view){

        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean("itsBoolean",true);
        editor.putFloat("itsFloat",357.26f);
        editor.putString("itsString","codekul.com");
        editor.apply();
    }

    public void onRead(View view){
        boolean _boolean = Prefs.getBoolean("itsBoolean",false);
        float _float = Prefs.getFloat("itsFloat",587.36f);
        String _string = Prefs.getString("itsString",":(");
        Log.i(TAG,"Boolean -"+ _boolean +"Float -"+ _float +"Sting -"+ _string);
        ((TextView)findViewById(R.id.txtDisplay)).setText("Boolean -"+ _boolean +"Float -"+ _float +"Sting -"+ _string);
    }
}
