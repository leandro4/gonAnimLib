package com.gonanimationlib.animations;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public final class CompSlide extends AnimationCompBasic {

    public enum FROM {

        LEFT_UP(-1, -1), UP(0, -1), RIGHT_UP(1, -1),
        LEFT_BOTTOM(-1, 1), BOTTOM(0, 1), RIGHT_BOTTOM(1, 1),
        RIGHT(1, 0), LEFT(-1, 0);

        public float xFrom;
        public float xTo = 0;
        public float yFrom;
        public float yTo = 0;

        FROM(float xFrom, float yFrom) {
            this.xFrom = xFrom;
            this.yFrom = yFrom;
        }
    }

    public enum RELATIVE_TO {
        PARENT(Animation.RELATIVE_TO_PARENT), SELF(Animation.RELATIVE_TO_SELF);

        public int relative;

        RELATIVE_TO(int relative) {
            this.relative = relative;
        }
    }

    private FROM from;
    private RELATIVE_TO relativeTo = RELATIVE_TO.PARENT;

    @Override
    public void startAnimation(View view) {

        Animation translate = new TranslateAnimation(relativeTo.relative, from.xFrom, Animation.RELATIVE_TO_SELF, from.xTo,
                relativeTo.relative, from.yFrom, Animation.RELATIVE_TO_SELF, from.yTo);
        translate.setStartOffset(delay);
        translate.setDuration(duration);
        translate.setRepeatCount(repeat);
        translate.setInterpolator(interpolator);
        translate.setAnimationListener(buildAnimationListener());
        view.startAnimation(translate);

    }

    CompSlide(FROM from) {
        this.from = from;
    }

    public CompSlide relative(RELATIVE_TO relative) {
        this.relativeTo = relative;
        return this;
    }
}
