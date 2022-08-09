package com.boole.jgmp.math.helpers;

import com.boole.jgmp.math.vectors.JGMPVector2;

public class JGMPFloatH {

    private static float epsilon = 0.0001f;

    /**
     * Minimum between 2 floats
     * @param a float
     * @param b float
     * @return minimum of the 2 floats
     */
    public static float min(float a, float b) { return Math.min(a, b); }

    /**
     * Maximum between 2 floats
     * @param a float
     * @param b float
     * @return maximum of the 2 floats
     */
    public static float max(float a, float b) { return Math.max(a, b); }

    /**
     * Clamps a float between the min and max
     * @param v float value
     * @param min min float capacity
     * @param max max float capacity
     * @return clamped float value
     */
    public static float clamp(float v, float min, float max) { return v > max ? max : max(v,min); }

    /**
     * Lerping floats given start and end
     * @param initial starting point float
     * @param ending ending point float
     * @param t float t
     * @return lerped float value
     */
    public static float lerp(float initial, float ending, float t) { return (ending - initial) * t + initial; }

    /**
     * Inverse Lerping floats given start and end
     * @param initial starting point float
     * @param ending ending point float
     * @param t float t
     * @return inversely lerped float value
     */
    public static float inverseLerp(float initial, float ending, float t) { return (t - initial) / (ending - initial); }

    /**
     * 1D Cubic Bezier Curve Interpolation
     * @param initial starting point
     * @param ending ending point
     * @param r ratio float
     * @return interp float value
     */
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

    /**
     * 2D Cubic Bezier Curve Interpolation
     * @param points array of points
     * @param r ratio float
     * @return interp float value
     */
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

    /**
     * Remapping float values
     * @param fval float value
     * @param fmin min float capacity
     * @param fmax max float capacity
     * @param tmin t min float capacity
     * @param tmax t max float capacity
     * @return
     */
    public static float remap(float fval, float fmin, float fmax, float tmin, float tmax) {
        float t = inverseLerp(fmin, fmax, fval);
        return lerp(tmin, tmax, t);
    }

    /**
     * Checks whether 2 floats are approximately equal with a relative error of the epsilon.
     * @param a first float value to compare
     * @param b second float value to compare
     * @return boolean indicating if the 2 floats are approximately equal.
     */
    public static boolean approxEqual(float a, float b) { return Math.abs(a-b) <= epsilon; }

    /**
     * Sign of the given float
     * @param v float value
     * @return sign float value of <b>v</b>
     */
    public static float sign(float v) { return Float.compare(v, 0); }

    /**
     * Rounds the given float value to a near multiple. <br>
     * This is not entirely accurate, but the algorithm works accurate enough.
     * @param v float value
     * @param mult float multiple
     * @return rounded multiple
     */
    public static float roundToMultiple(float v, float mult) {
        v += mult/2f;
        float r = v%mult;
        if(v > 0f) return v+mult-r;
        return v-r;
    }

    /**
     * Rounds the given float value up to a near multiple. <br>
     * This is not entirely accurate, but the algorithm works accurate enough.
     * @param v float value
     * @param mult float multiple
     * @return rounded up multiple
     */
    public static float roundUpToMultiple(float v, float mult) {
        float r = v%mult;
        if(r == 0f) return v;
        if(v > 0f) return v+mult-r;
        return v-r;
    }

    /**
     * Rounds the given float value down to a near multiple. <br>
     * This is not entirely accurate, but the algorithm works accurate enough.
     * @param v float value
     * @param mult float multiple
     * @return rounded down multiple
     */
    public static float roundDownToMultiple(float v, float mult) {
        float r = v%mult;
        if(r == 0f) return v;
        if(v > 0f) return v-r;
        return v-r-mult;
    }

}