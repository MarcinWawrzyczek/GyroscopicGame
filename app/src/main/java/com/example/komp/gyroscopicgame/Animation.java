package com.example.komp.gyroscopicgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by komp on 2018-06-22.
 */

public class Animation {
    private Bitmap [] frames;
    private int frameIndex;
    private boolean isPlaing = false;
    public boolean isPlaing(){
        return isPlaing;
    }

        public void play(){
        isPlaing=true;
        frameIndex=0;
        lastFrame = System.currentTimeMillis();
        }
        public void stop(){
            isPlaing=false;
            frameIndex=0;
        }
        private float frameTime;

        private long lastFrame;

        public Animation(Bitmap[] frames, float animeTime){
            this.frames = frames;
            frameIndex=0;
            frameTime = animeTime/frames.length;
            lastFrame = System.currentTimeMillis();
        }

        public void draw(Canvas canvas, Rect destination){
            if (!isPlaing)
                return;
            scaleRect(destination);

            canvas.drawBitmap(frames[frameIndex],null,destination, new Paint());

        }

        private void scaleRect(Rect rect){

            float whRatio= (float)(frames[frameIndex].getWidth())/(frames[frameIndex].getHeight());
            if (rect.width()>rect.height()){
                rect.right=rect.left - (int)(rect.height()*whRatio);
            } else
                rect.top=rect.bottom - (int)(rect.width()*(1/whRatio));
        }

        public void update(){

            if (!isPlaing)
                return;

            if (System.currentTimeMillis()- lastFrame> frameTime*1000){
                frameIndex++;
                frameIndex=frameIndex>=frames.length ? 0 : frameIndex;
                lastFrame=System.currentTimeMillis();
            }

        }
}
