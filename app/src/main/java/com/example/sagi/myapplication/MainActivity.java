package com.example.sagi.myapplication;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.opengl.EGLExt;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    int x=1;
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//    ButtonChange change;
    boolean loop=false;
    CustomView customView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customView = (CustomView)findViewById(R.id.paint_surface);

//        customView.setOnTouchListener(customView);

//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.FILL);
//        btn = (Button)findViewById(R.id.button);
//
//        findViewById(android.R.id.content).setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN)
//
//                    return true;
//            }
//        });
//        btn.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN)
//                {
//                    loop = true;
//                    change = new ButtonChange();
//                    change.execute(btn);
//                }
//                else if (event.getAction() == MotionEvent.ACTION_UP)
//                {
//                    loop = false;
//                    x *= -1;
//                }
////                    btn.setBackgroundColor(Color.LTGRAY);
//                return true;
//            }
//        });

    }
//    private class ButtonChange extends AsyncTask<Button, Button, Void> {
//
//        @Override
//        protected Void doInBackground(Button... params) {
//            while(loop) {
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                publishProgress(params);
//            }
//            return null;
//        }
//
//        @Override
//        protected void onProgressUpdate(Button... values) {
////            Display display = getWindowManager().getDefaultDisplay();
////            Point size = new Point();
////            display.getSize(size);
////            int width = size.x;
////            int height = size.y;
//            ViewGroup.LayoutParams par = values[0].getLayoutParams();
//            values[0].setRotation(values[0].getRotation() + 10);
//            if((par.width < 1500 && x > 0 ) ||  (par.width > 100 && x < 0))
//            par.width += 10 * x;
//            if((par.height < 1500 && x > 0) || (x < 0 && par.height > 100))
//            par.height += 10 * x;
//            btn.setLayoutParams(par);
//
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
