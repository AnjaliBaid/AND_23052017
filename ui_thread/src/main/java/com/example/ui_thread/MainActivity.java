package com.example.ui_thread;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int i =0;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(Looper.getMainLooper());
    }

    public void onbtnokay(View view){
        new MyTask().execute(0,100);

    }

    private void handler_Demo(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (i=0;i<100;i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ((TextView)findViewById(R.id.txt)).setText(""+i);
                        }
                    });
                }
            }
        }).start();

    }

    private void workerThread(){
        new Thread( new Runnable(){

            @Override
            public void run() {
                for (int i=0 ; i<100 ; i++) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // ((TextView)findViewById(R.id.txt)).setText(""+i);
                }
            }
        }).start();
    }

    private class MyTask extends AsyncTask<Integer,Integer,Boolean>{

        private ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //pd=ProgressDialog.show(MainActivity.this,"Title","message");
            pd = new ProgressDialog(MainActivity.this);
            pd.setMax(100);
            pd.setTitle("Title");
            pd.setMessage("message");
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.show();
        }

        @Override
        protected Boolean doInBackground(Integer... params) {

            for (int i=params[0];i<params[1];i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(i);
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            ((TextView)findViewById(R.id.txt)).setText(String.valueOf(values[0]));
            pd.setProgress(values[i]);
        }
    }
}

