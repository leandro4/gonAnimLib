package com.gonanimationlib.animations;

import android.support.annotation.NonNull;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import com.gonanimationlib.interfaces.Listener;

abstract class AnimationCompBasic extends AnimationCompBase {

    protected long duration = Animate.DURATION_SHORT;
    protected int delay = 0;
    protected int repeat = 0;
    protected Interpolator interpolator = new LinearInterpolator();


    public AnimationCompBase duration(long during) {
        if (during > 0)
            this.duration = during;
        return this;
    }

    public AnimationCompBase startOffset(int delay) {
        if (delay > 0)
            this.delay = delay;
        return this;
    }

    public AnimationCompBase repeat(int repeat, Listener callback) {
        if (repeat > 0) {
            this.repeat = repeat;
            this.onRepeat = callback;
        }
        return this;
    }

    public AnimationCompBase interpolator(@NonNull Interpolator interpolator) {
        this.interpolator = interpolator;
        return this;
    }
}
