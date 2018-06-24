package com.example.komp.gyroscopicgame;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by komp on 2018-06-23.
 */

public class AnimationManager {

    private Animation[] animations;
    private int animationIndex = 0;

    public AnimationManager(Animation[] animations) {
        this.animations = animations;
    }

    public void playAnim(int index) {
        for(int i = 0; i < animations.length; i++) {
            if(i == index) {
                if(!animations[index].isPlaing())
                    animations[i].play();
            } else
                animations[i].stop();
        }
        animationIndex = index;
    }

    public void draw(Canvas canvas, Rect rect) {
        if(animations[animationIndex].isPlaing())
            animations[animationIndex].draw(canvas, rect);
    }

    public void update() {
        if(animations[animationIndex].isPlaing())
            animations[animationIndex].update();
    }
}
