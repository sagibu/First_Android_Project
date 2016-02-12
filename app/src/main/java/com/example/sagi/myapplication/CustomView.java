package com.example.sagi.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomView extends SurfaceView {
    private SurfaceHolder mHolder;
    private Paint paint;
    private List<MyPoint> ps;
    boolean run=true;
    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHolder = getHolder();
        ps = new ArrayList<>();
        // create the Paint and set its color
        //added line blabla
        paint = new Paint();
        paint.setColor(Color.GRAY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Random rnd = new Random();
            if (ps.size() > 100)
                ps.remove(0);

            ps.add(new MyPoint((int) event.getX(), (int) event.getY(), 255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            run = true;
            Render renderer = new Render();
            renderer.execute(ps);
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            run = false;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            return true;
    }


    private class MyPoint
    {
        public MyPoint(int x, int y, int a, int r, int g, int b)
        {
            this.x = x;
            this.y = y;
            this.a = a;
            this.r = r;
            this.g = g;
            this.b = b;
            radius = 20;
        }

        public int x, y, a, r ,g ,b, radius;
    }

    private class Render extends AsyncTask<List<MyPoint>, Void, Void> {

        @Override
        protected Void doInBackground(List<MyPoint>... params) {
            while(run) {
            Canvas c = mHolder.lockCanvas();
            c.drawColor(Color.BLACK);
                for(int i = 0; i < params[0].size() - 1 ; ++i) {
                    MyPoint obj = params[0].get(i);
                    paint.setARGB(obj.a, obj.r, obj.b, obj.g);
                    c.drawCircle(obj.x, obj.y, obj.radius, paint);
                }
                MyPoint last = params[0].get(params[0].size() - 1);
                last.radius += 2;
                paint.setARGB(last.a, last.r, last.b, last.g);
                c.drawCircle(last.x, last.y, last.radius, paint);
                mHolder.unlockCanvasAndPost(c);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
//        @Override
//        protected void onProgressUpdate(MyPoint... values) {
//            MyPoint obj = values[0];
//        }
    }
    //    @Override
//    protected void onDraw(Canvas canvas) {
//        canvas.drawColor(Color.WHITE);
//        canvas.drawCircle(200, 200, 100, paint);
//    }

}