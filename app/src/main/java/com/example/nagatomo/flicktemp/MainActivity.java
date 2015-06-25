package com.example.nagatomo.flicktemp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class MainActivity extends Activity {
    private final int MP = ViewGroup.LayoutParams.MATCH_PARENT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = new View( this );
        view.setOnTouchListener(new FlickTouchListener());

        LinearLayout linear_layout = new LinearLayout( this );
        setContentView(linear_layout);
        linear_layout.addView(view, new LinearLayout.LayoutParams(MP, MP));
    }


    public void onStart()
    {
        super.onStart();
    }

    private float lastTouchX;
    private float currentX;
    private float adjust = 200;
    private class FlickTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            //   Log.v( "motionEvent", "--touch_count = "+event.getPointerCount() );
            //   Log.v( "Y", ""+event.getY() );
            //   Log.v( "X", ""+event.getX() );
            //   System.out.println(event.getX());
            switch (event.getAction()) {

                case MotionEvent.ACTION_DOWN:// タッチ
                    //            Log.v( "motionEvent", "--ACTION_DOWN" );
                    lastTouchX = event.getX();
                    break;

                case MotionEvent.ACTION_UP: // タッチが離れた
                    //            Log.v( "motionEvent", "--ACTION_UP" );
                    currentX = event.getX();

                    if (lastTouchX + adjust < currentX) {
                        Log.v("Flick", "--右");
                    }
                    if (lastTouchX > currentX+ adjust ) {
                        Log.v( "Flick", "--左" );
                    }
                    break;

             /*   case MotionEvent.ACTION_CANCEL:
                    currentX = event.getX();
                    if (lastTouchX < currentX) {
                        //前に戻る動作
                    }
                    if (lastTouchX > currentX) {
                        //次に移動する動作
                    }
                    break;*/
            }
            return true;
        }
    }



}
