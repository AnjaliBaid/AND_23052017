package com.example.interactivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username=((EditText)findViewById(R.id.etUsername)).getText().toString();
                String password=((EditText)findViewById(R.id.etPassword)).getText().toString();

                if (username.equalsIgnoreCase("anjali") && password.equalsIgnoreCase("1234"))
                {

                    Bundle bundle = new Bundle();
                    bundle.putString("KeyStr",username);
                    bundle.putInt("KeyInt",123);

                    Intent intent=new Intent(MainActivity.this,profileactivity.class);
                    intent.putExtras(bundle);

                    //startActivity(intent);
                    startActivityForResult(intent,4567);



                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==4567 && resultCode==RESULT_OK && data!=null){
            Bundle bundle = data.getExtras();
            String res = bundle.getString("key");
            ((EditText)findViewById(R.id.etUsername)).setText(res);

        }
    }
}
