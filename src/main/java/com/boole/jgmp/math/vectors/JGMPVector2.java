package com.boole.jgmp.math.vectors;

import main.com.boole.jgmp.math.helpers.JGMPFloatH;

public class JGMPVector2 {

    // Vector Key and Value
    public float x;
    public float y;

    public JGMPVector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public JGMPVector2 copy() { return new JGMPVector2(this.x, this.y); }
    public boolean equals(JGMPVector2 v) { return this.x == v.x && this.y == v.y; }
    public int compareTo(JGMPVector2 v) {
        if(this.x == v.x) return Float.compare(this.y, v.y);
        return Float.compare(this.x, v.x);
    }

    public static JGMPVector2 ZERO = new JGMPVector2(0f, 0f);
    public static JGMPVector2 ONE = new JGMPVector2(1f, 1f);
    public static JGMPVector2 INF = new JGMPVector2(Float.MAX_VALUE, Float.MAX_VALUE);
    public static JGMPVector2 NEG_INF = new JGMPVector2(Float.MIN_VALUE, Float.MIN_VALUE);

    public static JGMPVector2 UP = new JGMPVector2(0f, 1f);
    public static JGMPVector2 RIGHT = new JGMPVector2(1f, 0f);
    public static JGMPVector2 DOWN = new JGMPVector2(0f, -1f);
    public static JGMPVector2 LEFT = new JGMPVector2(-1f, 0f);

    public void add(JGMPVector2 v) {
        this.x += v.x;
        this.y += v.y;
    }
    public void subtract(JGMPVector2 v) {
        this.x -= v.x;
        this.y -= v.y;
    }
    public void multiply(JGMPVector2 v) {
        this.x *= v.x;
        this.y *= v.y;
    }
    public void divide(JGMPVector2 v) {
        this.x += v.x;
        this.y += v.y;
    }

    public void addScalar(float v) {
        this.x += v;
        this.y += v;
    }
    public void subtractScalar(float v) {
        this.x -= v;
        this.y -= v;
    }
    public void multiplyScalar(float v) {
        this.x *= v;
        this.y *= v;
    }
    public void divideScalar(float v) {
        this.x /= v;
        this.y /= v;
    }

    public void negative(JGMPVector2 v) { multiplyScalar(-1); }
    public float length() { return (float)Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)); }
    public JGMPVector2 normal() {
        if(this.x == 0 && this.y == 0) return this;
        float k = 1f / (float)Math.sqrt((this.x * this.x) + (this.y * this.y));
        JGMPVector2 r = this.copy(); r.multiplyScalar(k);
        return r;
    }

    public float distanceFrom(JGMPVector2 v) { return (float)Math.sqrt(Math.pow(v.x-this.x, 2) + Math.pow(v.y-this.y, 2)); }
    public float dot(JGMPVector2 v) { return (this.x * v.x) + (this.y * v.y); }
    public float cross(JGMPVector2 v) { return (this.x * v.y) - (this.y * v.x); }
    public float angle() { return (float)Math.atan2(-this.y, this.x); }

    public void reflect() {
        JGMPVector2 v = this.copy();
        JGMPVector2 normal = this.normal();
        normal.multiplyScalar(2f * this.dot(normal));
        this.subtract(normal);
    }
    public void absorb(JGMPVector2 v) {
        JGMPVector2 normal = this.normal();
        normal.multiplyScalar(this.dot(normal));
        this.subtract(normal);
    }
    public void rotate(float angle) {
        float cos = (float)Math.cos(angle);
        float sin = (float)Math.sin(angle);
        float cross = this.cross(new JGMPVector2(cos, sin));
        float dot = this.dot(new JGMPVector2(cos, sin));
        this.x = cross;
        this.y = dot;
    }

    public void perpendicularLeft() {
        float temp = this.x;
        this.x = this.y;
        this.y = -temp;
    }
    public void perpendicularRight() {
        float temp = this.y;
        this.y = this.x;
        this.x = -temp;
    }

    public static JGMPVector2 min(JGMPVector2 a, JGMPVector2 b) {
        return new JGMPVector2(Math.min(a.x, b.x), Math.min(a.y, b.y));
    }
    public static JGMPVector2 max(JGMPVector2 a, JGMPVector2 b) {
        return new JGMPVector2(Math.max(a.x, b.x), Math.max(a.y, b.y));
    }
    public static JGMPVector2 clamp(JGMPVector2 v, JGMPVector2 min, JGMPVector2 max) {
        return new JGMPVector2(JGMPFloatH.clamp(v.x, min.x, max.x), JGMPFloatH.clamp(v.y, min.y, max.y));
    }
    public static JGMPVector2 lerp(JGMPVector2 initial, JGMPVector2 ending, JGMPVector2 t) {
        return new JGMPVector2(JGMPFloatH.lerp(initial.x, ending.x, t.x), JGMPFloatH.lerp(initial.x, ending.x, t.x));
    }
    public static JGMPVector2 roundToMultiple(JGMPVector2 v, JGMPVector2 mult) {
        return new JGMPVector2(JGMPFloatH.roundToMultiple(v.x, mult.x), JGMPFloatH.roundToMultiple(v.y, mult.y));
    }
    public static JGMPVector2 roundUpToMultiple(JGMPVector2 v, JGMPVector2 mult) {
        return new JGMPVector2(JGMPFloatH.roundUpToMultiple(v.x, mult.x), JGMPFloatH.roundUpToMultiple(v.y, mult.y));
    }
    public static JGMPVector2 roundDownToMultiple(JGMPVector2 v, JGMPVector2 mult) {
        return new JGMPVector2(JGMPFloatH.roundDownToMultiple(v.x, mult.x), JGMPFloatH.roundDownToMultiple(v.y, mult.y));
    }

    public JGMPVector2 sign() { return new JGMPVector2(JGMPFloatH.sign(this.x), JGMPFloatH.sign(this.y)); }
    public JGMPVector2 abs() { return new JGMPVector2(Math.abs(this.x), Math.abs(this.y)); }
    public JGMPVector2 floor() { return new JGMPVector2((float)Math.floor(this.x), (float)Math.floor(this.y)); }
    public JGMPVector2 ceil() { return new JGMPVector2((float)Math.ceil(this.x), (float)Math.ceil(this.y)); }
    public JGMPVector2 round() { return new JGMPVector2(Math.round(this.x), Math.round(this.y)); }
    public boolean approxEqual(JGMPVector2 v) { return JGMPFloatH.approxEqual(this.x, v.x) && JGMPFloatH.approxEqual(this.y, v.y); }

}
