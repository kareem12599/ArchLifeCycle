package com.example.kareem.archlifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;

/**
 * Created by USER on 11/13/2017.
 */

public class DataListener implements LifecycleObserver {
    Context context;
    boolean enabled ;
    Lifecycle lifecycle;

   public DataListener(Context context, Lifecycle lifecycle){
       this.lifecycle = lifecycle;
       lifecycle.addObserver(this);


   }
   public void enable(){
       enabled = true ;
       if(lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)){
           //connect if it's not connected
       }
   }
   @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
   void stop(){

   }
}
