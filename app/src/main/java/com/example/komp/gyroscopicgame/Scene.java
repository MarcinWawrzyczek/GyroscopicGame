package com.example.komp.gyroscopicgame;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Created by komp on 2018-06-22.
 */

public interface Scene {

    public void update();
    public void draw(Canvas canvas);
    public void terminate();
    public void recieveTouch(MotionEvent event);
}
