package com.example.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnlogin = (Button) findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etUsername = (EditText) findViewById(R.id.etUsername);
                String txtUsername = etUsername.getText().toString();

                EditText etPassword = (EditText) findViewById(R.id.etPassword);
                String txtPassword = etPassword.getText().toString();

                TextView textView = (TextView) findViewById(R.id.txtDisplay);

                if(txtUsername.equalsIgnoreCase("anjali") && txtPassword.equalsIgnoreCase("1234"))
                    textView.setText("login sucessfully");
                else
                    textView.setText("login failed");
            }
        }
        );
    }
}
