package com.employrewars.ersmobile.utils;

import static android.content.ContentValues.TAG;

import android.util.Log;

import com.google.android.material.appbar.AppBarLayout;

public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {

    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    private State mCurrentState = State.IDLE;

    @Override
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        Log.d(TAG, "onOffsetChanged: "+i);
        if (i >=-324) {
            if (mCurrentState != State.EXPANDED) {
                onStateChanged(appBarLayout, State.EXPANDED);
            }
            mCurrentState = State.EXPANDED;
        }
//        else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
//            if (mCurrentState != State.COLLAPSED) {
//                onStateChanged(appBarLayout, State.COLLAPSED);
//            }
//            mCurrentState = State.COLLAPSED;
//        }
        else {
            if (mCurrentState != State.IDLE) {
                onStateChanged(appBarLayout, State.IDLE);
            }
            mCurrentState = State.IDLE;
        }
    }

    public abstract void onStateChanged(AppBarLayout appBarLayout, State state);
}
