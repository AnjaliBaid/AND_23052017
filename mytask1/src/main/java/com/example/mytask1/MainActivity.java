package com.example.mytask1;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgview = (ImageView) findViewById(R.id.img1);
        imgview.setImageResource(R.drawable.ic_bookmark_black_24dp);

        // Resources res = getResources();
        // Drawable drawable = res.getDrawable(R.drawable.ic_bookmark_black_24dp);

        findViewById(R.id.linear1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = ((EditText) findViewById(R.id.ettxt)).getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("KeyStr", username);
                bundle.putInt("KeyInt", 123);

                Intent intent = new Intent(MainActivity.this, secondactivity.class);
                intent.putExtras(bundle);


                startActivity(intent);
            }
        });

        Intent responsibleIntent = getIntent();
        Bundle bundle = responsibleIntent.getExtras();

        if (bundle != null) {

            String status = bundle.getString("Key");
            ((TextView) findViewById(R.id.txt2)).setText(status);


        }

    }
}
