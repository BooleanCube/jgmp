package com.boole.jgmp.math.helpers;

import com.boole.jgmp.math.vectors.JGMPVector2;

public class JGMPFloatH {

    private static float epsilon = 0.0001f;

    public static float min(float a, float b) { return Math.min(a, b); }
    public static float max(float a, float b) { return Math.max(a, b); }

    public static float clamp(float v, float min, float max) { return v > max ? max : max(v,min); }
    public static float lerp(float initial, float ending, float t) { return (ending - initial) * t + initial; }
    public static float inverseLerp(float initial, float ending, float v) { return (v - initial) / (ending - initial); }

    // Cubic Bezier Curve Interpolation
    public static float bezierInterp1D(JGMPVector2 initial, JGMPVector2 ending, float r) {
        JGMPVector2[] points = new JGMPVector2[]{
                JGMPVector2.ZERO,
                initial,
                ending,
                JGMPVector2.ONE
        };
        JGMPVector2 point = bezierInterp2D(points, r);

        return point.dot(JGMPVector2.UP);
    }
    public static JGMPVector2 bezierInterp2D(JGMPVector2[] points, float r) {
        final int nump = 4;

        JGMPVector2[] tempbuf = new JGMPVector2[nump];
        for(int i=0; i<nump; i++) tempbuf[i] = points[i].copy();

        for(int x=0; x<nump; ++x) {
            for(int i=0; i<nump-1; ++i) {
                tempbuf[i].x = lerp(tempbuf[i].x, tempbuf[i+1].x, r);
                tempbuf[i].y = lerp(tempbuf[i].y, tempbuf[i+1].y, r);
            }
        }

        return tempbuf[0];
    }

    public static float remap(float fval, float fmin, float fmax, float tmin, float tmax) {
        float t = inverseLerp(fmin, fmax, fval);
        return lerp(tmin, tmax, t);
    }
    public static boolean approxEqual(float a, float b) { return Math.abs(a-b) <= epsilon; }

    public static float sign(float v) { return Float.compare(v, 0); }

    public static float roundToMultiple(float v, float mult) {
        v += mult/2f;
        float r = v%mult;
        if(v > 0f) return v+mult-r;
        return v-r;
    }
    public static float roundUpToMultiple(float v, float mult) {
        float r = v%mult;
        if(r == 0f) return v;
        if(v > 0f) return v+mult-r;
        return v-r;
    }
    public static float roundDownToMultiple(float v, float mult) {
        float r = v%mult;
        if(r == 0f) return v;
        if(v > 0f) return v-r;
        return v-r-mult;
    }

}