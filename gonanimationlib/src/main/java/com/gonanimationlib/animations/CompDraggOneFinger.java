package com.gonanimationlib.animations;

import android.view.MotionEvent;
import android.view.View;

import static android.view.MotionEvent.INVALID_POINTER_ID;

public final class CompDraggOneFinger extends AnimationCompBase {

    private int mActivePointerId = INVALID_POINTER_ID;

    @Override
    public void startAnimation(View view) {
        view.setOnTouchListener((v, ev) -> {

            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mActivePointerId = ev.getPointerId(0);
                    break;
                case MotionEvent.ACTION_MOVE:

                    if (mActivePointerId == INVALID_POINTER_ID) return false;

                    int pointerIndexMove = ev.findPointerIndex(mActivePointerId);
                    float x = ev.getX(pointerIndexMove);
                    float y = ev.getY(pointerIndexMove);

                    view.setX(v.getX() - v.getWidth()/2 + x);
                    view.setY(v.getY() - v.getHeight()/2 + y);
                    break;
                case MotionEvent.ACTION_POINTER_UP:

                    final int pointerIndexUp = ev.getActionIndex();
                    final int pointerId = ev.getPointerId(pointerIndexUp);

                    if (pointerId == mActivePointerId) {
                        mActivePointerId = INVALID_POINTER_ID;
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    mActivePointerId = INVALID_POINTER_ID;
                    break;
                case MotionEvent.ACTION_CANCEL:
                    mActivePointerId = INVALID_POINTER_ID;
                    break;
            }
            v.performClick();
            return true;
        });
    }
}
