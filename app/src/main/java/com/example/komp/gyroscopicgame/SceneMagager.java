package com.example.komp.gyroscopicgame;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

/**
 * Created by komp on 2018-06-22.
 */

public class SceneMagager {
    private ArrayList<Scene> scenes = new ArrayList<>();
    public static int ACTIVE_SCENE;

    public SceneMagager(){

        ACTIVE_SCENE =0;

        scenes.add(new GameplayScene());
    }

        public void recieveTouch(MotionEvent event){
            scenes.get(ACTIVE_SCENE).recieveTouch(event);
        }



    public void setScenes(int activeScene){
        this.ACTIVE_SCENE = activeScene;

    }

    public void update(){
        scenes.get(ACTIVE_SCENE).update();
    }
    public void draw(Canvas canvas){
        scenes.get(ACTIVE_SCENE).draw(canvas);
    }

}
