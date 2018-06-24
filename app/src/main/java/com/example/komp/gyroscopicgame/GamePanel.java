package com.example.komp.gyroscopicgame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


/**
 * Created by komp on 2018-06-21.
 */

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;

    private SceneMagager meneger;

    public  GamePanel(Context context){
        super(context);

        getHolder().addCallback(this);
        Constants.CURRENT_CONTEXT = context;

        thread = new MainThread(getHolder(),this);
        meneger = new SceneMagager();
        setFocusable(true);
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(getHolder(), this);
        Constants.INIT_TIME = System.currentTimeMillis();
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch(Exception e) {e.printStackTrace();}
            retry = false;
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        meneger.recieveTouch(event);
        return true;
}
    public void update() {
        meneger.update();;
    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        meneger.draw(canvas);
    }

}