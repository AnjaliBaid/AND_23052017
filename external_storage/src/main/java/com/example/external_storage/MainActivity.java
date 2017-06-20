package com.example.external_storage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appPrivateWrite();
        populateList();

    }

    private void appPrivateRead(){

        File file = new File(getExternalFilesDir(Environment.DIRECTORY_DCIM),"my.txt");
        StringBuilder builder = new StringBuilder();

        try {
            FileInputStream fis = new FileInputStream(file);

            while (true){
                int ch = fis.read();
                if (ch == -1) break;
                else builder.append((char) ch);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "Reading - " + builder.toString());
    }



    private void appPrivateWrite() {

        File file = new File(getExternalFilesDir(""),"My.txt");
        Log.i(TAG,"App Private Path -"+ file.getAbsolutePath());

        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("This is my day".getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void publicSharedRead(){

        if (isMediaAvailable()) {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"my.txt");
            StringBuilder builder = new StringBuilder();

            try {
                FileInputStream fis = new FileInputStream(file);

                while (true){
                    int ch = fis.read();
                    if (ch == -1) break;
                    else builder.append((char) ch);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.i(TAG, "Reading Public - " + builder.toString());
        }else
            Log.i(TAG,"Bad Media file .");
    }


    private void publicSharedWrite(){
        if (isMediaAvailable()){
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"my.txt");
            Log.i(TAG,"App Private Path -"+ file.getAbsolutePath());

            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write("This is my day".getBytes());
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else
            Log.i(TAG,"Bad Media File");

    }

    private void newPublicFolder(){
        File file = new File(Environment.getExternalStoragePublicDirectory("My app"),"my-day");
        file.mkdir();

        File myDay = new File(file, "hello.txt");
        try {
            myDay.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Boolean isMediaAvailable(){
        return Environment.getExternalStorageState()
                 .equals(Environment.MEDIA_MOUNTED);
    }

    private void populateList(){
        File file = getExternalFilesDir("");

        List<File_item> fileItems = new ArrayList<>();
        File[] files = file.listFiles();

        for (File fl : files) {
            fileItems.add(new File_item(fl.isDirectory() ? R.drawable.ic_folder_black_24dp : R.drawable.ic_insert_drive_file_black_24dp, fl.getName(), "" + fl.lastModified(), "" + fl.length()));
            }
            ((ListView) findViewById(R.id.listvw)).setAdapter(new File_Adapter(this, fileItems));
    }
}
