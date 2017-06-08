package com.example.dialog_notification;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by anju on 5/6/17.
 */

public class AppDialog extends DialogFragment {

    public static final String TAG_INTERNET="noInternet";
    public static final String  TAG_DATE = "date";
    public static final String  TAG_TIME = "time";
    public static final String  TAG_PROGRESS ="progress";
    public static final String  TAG_CUSTOM ="custom";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = null;

        if (getTag().equals(TAG_INTERNET)) {
            dialog = noInternet();
        }
        else if (getTag().equals(TAG_DATE)){
            dialog = calender();
        }
        else  if (getTag().equals(TAG_TIME)){
            dialog = time();
        }
        else  if (getTag().equals(TAG_PROGRESS)){
            dialog = progress();
        }
        else
        {
            dialog = custom();
        }

        return dialog;
    }

    public Dialog  noInternet(){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //AlertDialog.Builder builder = new  AlertDialog.Builder(getActivity());
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Title");
        builder.setMessage("Message");
        builder.setPositiveButton("Positive", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mt("Positive");
            }
        });
        builder.setNegativeButton("Negative", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mt("Negative");
            }
        });

        AlertDialog dialog = builder.create();

        return  dialog;
    }

    public Dialog calender(){

        DatePickerDialog dialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                mt(""+(dayOfMonth)+"-"+(month+1)+"-"+(year));
            }
        },2017,6,5);

        return dialog;
    }

    public Dialog time(){

        TimePickerDialog dialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mt(""+(hourOfDay)+":"+(minute));
            }
        },4,25,false);

        return dialog;
    }

    public  Dialog progress(){

        ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.setMessage("message");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("title");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        return dialog;
    }

    public Dialog custom(){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        AlertDialog dialog = builder.create();

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view = inflater.inflate(R.layout.my_dialog,null,false);
        dialog.setView(view);

        return dialog;
    }

    private  void mt(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }

}


