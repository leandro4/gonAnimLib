package com.gonanimationlib.animations;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.gonanimationlib.interpolators.SpringInterpolator;

public final class CompZoom extends AnimationCompBasic {

    private KIND kind;
    private float pivote = 0.5f;

    @Override
    public void startAnimation(View view) {

        Animation scale = new ScaleAnimation(kind.from, kind.to, kind.from, kind.to, Animation.RELATIVE_TO_SELF, pivote,
                Animation.RELATIVE_TO_SELF, pivote);

        scale.setInterpolator(interpolator);
        scale.setDuration(duration);
        scale.setAnimationListener(buildAnimationListener());
        view.startAnimation(scale);

    }

    CompZoom(KIND kind) {
        interpolator = new SpringInterpolator();
        this.kind = kind;
    }


    public enum KIND {
        IN(0.1f, 1), OUT(1, 0.1f);

        public float from;
        public float to;

        KIND(float from, float to) {
            this.from = from;
            this.to = to;
        }
    }
}
