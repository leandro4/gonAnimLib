package com.gonanimationlib.animations;

import android.content.Context;
import android.support.v4.content.ContextCompat;

/**
 * Created by leandro on 6/4/18.
 */

public final class Animate {

    public static CompAlpha ALPHA (float alpha) {
        return new CompAlpha(alpha);
    }

    public static CompColor COLOR (int color) {
        return new CompColor(color);
    }

    public static CompZumb ZUMB () {
        return new CompZumb();
    }

    public static CompSlide SLIDE (CompSlide.FROM from) {
        return new CompSlide(from);
    }

    public static CompMove MOVE (float x, float y) {
        return new CompMove(x, y);
    }

    public static CompRotate ROTATE (int degrees) {
        return new CompRotate(degrees);
    }

    public static CompResize RESIZE_WIDTH (int width) {
        return new CompResize(width, CompResize.ATTR.WIDTH);
    }

    public static CompResize RESIZE_HEIGHT (int height) {
        return new CompResize(height, CompResize.ATTR.HEIGHT);
    }

    public static CompZoom ZOOM (CompZoom.KIND kind) {
        return new CompZoom(kind);
    }

    public static CompDraggOneFinger DRAGG() {
        return new CompDraggOneFinger();
    }

    public static CompSretch STRETCH() {
        return new CompSretch();
    }

    // durations
    public static final int DURATION_V_SHORT = 150;
    public static final int DURATION_SHORT = 300;
    public static final int DURATION_MEDIUM = 500;
    public static final int DURATION_LARGE = 700;
    public static final int DURATION_V_LARGE = 900;

    public static class Util {

        public static int DpToPx (Context context, int dp) {
            return (int) (dp * context.getResources().getDisplayMetrics().density);
        }

        public static int GetColor(Context context, int color) {
            try {
                return ContextCompat.getColor(context, color);
            } catch (Exception ex) {
                return -1;
            }
        }
    }
}
