package main.com.boole.jgmp.math;

public class JGMPFloatH {

    public static float min(float a, float b) { return Math.min(a, b); }
    public static float max(float a, float b) { return Math.max(a, b); }

    public static float clamp(float v, float min, float max) { return v > max ? max : max(v,min); }
    public static float lerp(float initial, float ending, float t) { return (ending - initial) * t + initial; }
    public static float inverseLerp(float initial, float ending, float v) { return (v - initial) / (ending - initial); }

    public static float remap(float fval, float fmin, float fmax, float tmin, float tmax) {
        float t = inverseLerp(fmin, fmax, fval);
        return lerp(tmin, tmax, t);
    }
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