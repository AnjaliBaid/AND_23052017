package com.example.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.Gravity;

/**
 * Created by anju on 26/5/17.
 */

public class Ourview extends AppCompatEditText {

     private Paint paint;
    public Ourview(Context context) {
        super(context);
        initpaint();
    }

    public Ourview(Context context, AttributeSet attrs) {
        super(context, attrs);
        initpaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

       paint.setColor(Color.BLACK);
       canvas.drawRect(100,100,350,300,paint);
        paint.setColor(Color.BLUE);
       canvas.drawCircle(200,200,50,paint);
       paint.setColor(Color.BLACK);
        canvas.drawLine(250,200,350,350,paint);
    }

    private void initpaint()
    {
        paint=new Paint();
        paint.setStrokeWidth(2f);
        paint.setColor(Color.BLACK);
        setGravity(Gravity.LEFT|Gravity.BOTTOM);
    }

}
