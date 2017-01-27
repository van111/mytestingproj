package com.example.fortydegreescelsius.textbased.Handler;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import java.lang.ref.WeakReference;

/**
 * Created by FORTYDEGREESCELSIUS on 1/26/2017.
 */
public class StoryBaseHandler {

    public View v;
    public Fragment f;

    public class StoryHandler extends Handler {
        private final WeakReference<StoryBaseHandler> StoryWeakReference;

        public StoryHandler(StoryBaseHandler StoryInstance) {
            StoryWeakReference = new WeakReference<StoryBaseHandler>(StoryInstance);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            StoryBaseHandler storyBaseHandler  = StoryWeakReference.get();
            if (storyBaseHandler != null) {

            }
        }

        /**
         * Setter and Getter here
         */
        public void setViewFragment(View view, Fragment fragment) {
            v = view;
            f = fragment;
        }

        public void changeFragment(){
            if (v != null && f != null) {

            }
        }
    }

}
