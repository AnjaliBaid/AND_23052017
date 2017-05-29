package com.example.mytask1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class secondactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        Intent responsibleIntent = getIntent();
        Bundle bundle = responsibleIntent.getExtras();

        if (bundle!=null){

            String username = bundle.getString("KeyStr");
            ((TextView)findViewById(R.id.txt)).setText(username);


            findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String status = ((EditText)findViewById(R.id.ettxt1)).getText().toString();

                    Bundle bundle = new Bundle();
                    bundle.putString("Key",status);
                    bundle.putInt("KeyInt",123);

                    Intent intent=new Intent(secondactivity.this,MainActivity.class);
                    intent.putExtras(bundle);

                    startActivity(intent);
                }
            });

        }
    }
}
