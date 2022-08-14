package com.boole.jgmp.math.vectors;

import com.boole.jgmp.math.helpers.JGMPFloatH;

/**
 * 2D Vector Mathematics Model for the JGMP Library. <br>
 * Includes Linear Algebra types and functions for 2 Dimensional Mathematics. <br>
 * {@link JGMPVector2} can be used as the equivalent of the c++ pair.
 */
public class JGMPVector2 {

    /**
     * First element in the {@link JGMPVector2}
     */
    public float x;

    /**
     * Second element in the {@link JGMPVector2}
     */
    public float y;

    /**
     * Initialize {@link JGMPVector2} object given the first and second element.
     * @param x first element in the {@link JGMPVector2}
     * @param y second element in the {@link JGMPVector2}
     */
    public JGMPVector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns a copied version of the {@link JGMPVector2}
     * @return copied {@link JGMPVector2} object
     */
    public JGMPVector2 copy() { return new JGMPVector2(this.x, this.y); }

    /**
     * Checks if 2 {@link JGMPVector2} are equal
     * @param v second {@link JGMPVector2} to compare
     * @return boolean indicating whether the vectors are equal.
     */
    public boolean equals(JGMPVector2 v) { return this.compareTo(v) == 0; }

    /**
     * Comparing 2 {@link JGMPVector2}s
     * @param v second {@link JGMPVector2} to compare
     * @return 1 if <b>current vector</b> is larger, -1 if <b>v</b> is larger, 0 if the 2 vectors are <b>equal</b>.
     */
    public int compareTo(JGMPVector2 v) {
        if(this.x == v.x) return Float.compare(this.y, v.y);
        return Float.compare(this.x, v.x);
    }

    /**
     * Static ZERO {@link JGMPVector2} (0,0)
     */
    public static JGMPVector2 ZERO = new JGMPVector2(0f, 0f);

    /**
     * Static ONE {@link JGMPVector2} (1,1)
     */
    public static JGMPVector2 ONE = new JGMPVector2(1f, 1f);

    /**
     * Static INFINITY {@link JGMPVector2} (3.4028235E38,3.4028235E38)
     */
    public static JGMPVector2 INF = new JGMPVector2(Float.MAX_VALUE, Float.MAX_VALUE);

    /**
     * Static NEGATIVE INFINITY {@link JGMPVector2} (1.4E-45,1.4E-45)
     */
    public static JGMPVector2 NEG_INF = new JGMPVector2(Float.MIN_VALUE, Float.MIN_VALUE);

    /**
     * Static UP Direction {@link JGMPVector2} (0,1)
     */
    public static JGMPVector2 UP = new JGMPVector2(0f, 1f);

    /**
     * Static RIGHT Direction {@link JGMPVector2} (1,0)
     */
    public static JGMPVector2 RIGHT = new JGMPVector2(1f, 0f);

    /**
     * Static DOWN Direction {@link JGMPVector2} (0,-1)
     */
    public static JGMPVector2 DOWN = new JGMPVector2(0f, -1f);

    /**
     * Static LEFT Direction {@link JGMPVector2} (-1,0)
     */
    public static JGMPVector2 LEFT = new JGMPVector2(-1f, 0f);

    /**
     * Vector addition for 2 {@link JGMPVector2}
     * @param v second {@link JGMPVector2} to add
     * @return {@link JGMPVector2} sum
     */
    public JGMPVector2 add(JGMPVector2 v) {
        this.x += v.x;
        this.y += v.y;
        return this;
    }

    /**
     * Vector subtraction for 2 {@link JGMPVector2}
     * @param v second {@link JGMPVector2} to subtract
     * @return {@link JGMPVector2} difference
     */
    public JGMPVector2 subtract(JGMPVector2 v) {
        this.x -= v.x;
        this.y -= v.y;
        return this;
    }

    /**
     * Vector multiplication for 2 {@link JGMPVector2}
     * @param v second {@link JGMPVector2} to multiply
     * @return {@link JGMPVector2} product
     */
    public JGMPVector2 multiply(JGMPVector2 v) {
        this.x *= v.x;
        this.y *= v.y;
        return this;
    }

    /**
     * Vector division for 2 {@link JGMPVector2}
     * @param v second {@link JGMPVector2} to divide
     * @return {@link JGMPVector2} quotient
     */
    public JGMPVector2 divide(JGMPVector2 v) {
        this.x += v.x;
        this.y += v.y;
        return this;
    }

    /**
     * Scalar addition for a {@link JGMPVector2} and a float value
     * @param v float value to add to the {@link JGMPVector2}
     * @return resulting {@link JGMPVector2}
     */
    public JGMPVector2 addScalar(float v) {
        this.x += v;
        this.y += v;
        return this;
    }

    /**
     * Scalar subtraction for a {@link JGMPVector2} and a float value
     * @param v float value to subtract from the {@link JGMPVector2}
     * @return resulting {@link JGMPVector2}
     */
    public JGMPVector2 subtractScalar(float v) {
        this.x -= v;
        this.y -= v;
        return this;
    }

    /**
     * Scalar multiplication for a {@link JGMPVector2} and a float value
     * @param v float value to multiply to the {@link JGMPVector2}
     * @return resulting {@link JGMPVector2}
     */
    public JGMPVector2 multiplyScalar(float v) {
        this.x *= v;
        this.y *= v;
        return this;
    }

    /**
     * Scalar division for a {@link JGMPVector2} and a float value
     * @param v float value to divide from the {@link JGMPVector2}
     * @return resulting {@link JGMPVector2}
     */
    public JGMPVector2 divideScalar(float v) {
        this.x /= v;
        this.y /= v;
        return this;
    }

    /**
     * {@link JGMPVector2} with the opposite sign in the elements
     * @return opposite signed {@link JGMPVector2}
     */
    public JGMPVector2 negative() { return this.copy().multiplyScalar(-1); }

    /**
     * Length of the {@link JGMPVector2} from the origin (0,0)
     * @return length float value
     */
    public float length() { return (float)Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)); }

    /**
     * Normal {@link JGMPVector2} of the current {@link JGMPVector2}
     * @return normal {@link JGMPVector2}
     */
    public JGMPVector2 normal() {
        if(this.x == 0 && this.y == 0) return this;
        float k = 1f / (float)Math.sqrt((this.x * this.x) + (this.y * this.y));
        return this.copy().multiplyScalar(k);
    }

    /**
     * Distance from this {@link JGMPVector2} to a second {@link JGMPVector2} in the xy-grid. <br>
     * Treats the {@link JGMPVector2} as points on the xy-grid. <br>
     * @param v second {@link JGMPVector2} to calculate distance from.
     * @return distance float value
     */
    public float distanceFrom(JGMPVector2 v) { return (float)Math.sqrt(Math.pow(v.x-this.x, 2) + Math.pow(v.y-this.y, 2)); }

    /**
     * Calculates the dot product of 2 {@link JGMPVector2}
     * @param v second {@link JGMPVector2}
     * @return dot product float value
     */
    public float dot(JGMPVector2 v) { return (this.x * v.x) + (this.y * v.y); }

    /**
     * Calculates the cross product of 2 {@link JGMPVector2}
     * @param v second {@link JGMPVector2}
     * @return cross product float value
     */
    public float cross(JGMPVector2 v) { return (this.x * v.y) - (this.y * v.x); }

    /**
     * Angle of the {@link JGMPVector2} from the origin.
     * @return angle float value
     */
    public float angle() {
        float radians = -(float)Math.atan2(-this.y, this.x);
        if(radians < 0f) radians += 2f*JGMPVector2.LEFT.angle();
        return radians;
    }

    /**
     * Reflects the current {@link JGMPVector2}
     */
    public void reflect() {
        JGMPVector2 normal = this.normal();
        normal.multiplyScalar(2f * this.dot(normal));
        this.subtract(normal);
    }

    /**
     * Absorbing another {@link JGMPVector2}
     * @param v {@link JGMPVector2} to absorb
     */
    public void absorb(JGMPVector2 v) {
        JGMPVector2 normal = this.normal();
        normal.multiplyScalar(this.dot(normal));
        this.subtract(normal);
    }

    /**
     * Rotating the current {@link JGMPVector2} by the given angle. <br>
     * <i>This functions assumes the center of rotation is the origin (0, 0).</i> <br>
     * Rotates the point by using the dot and cross products of the sine and cosine values of the angle.
     * @param angle angle float value
     */
    public void rotate(float angle) {
        float cos = (float)Math.cos(angle);
        float sin = (float)Math.sin(angle);
        float cross = this.cross(new JGMPVector2(cos, sin));
        float dot = this.dot(new JGMPVector2(cos, sin));
        this.x = cross;
        this.y = dot;
    }

    /**
     * Converts the current {@link JGMPVector2} to the perpendicular left
     */
    public void perpendicularLeft() {
        float temp = this.x;
        this.x = this.y;
        this.y = -temp;
    }

    /**
     * Converts the current {@link JGMPVector2} to the perpendicular right
     */
    public void perpendicularRight() {
        float temp = this.y;
        this.y = this.x;
        this.x = -temp;
    }

    /**
     * Gets the smallest of the 2 {@link JGMPVector2}
     * @param a first {@link JGMPVector2}
     * @param b second {@link JGMPVector2}
     * @return smallest {@link JGMPVector2} between the first and second {@link JGMPVector2}
     */
    public static JGMPVector2 min(JGMPVector2 a, JGMPVector2 b) {
        return new JGMPVector2(Math.min(a.x, b.x), Math.min(a.y, b.y));
    }

    /**
     * Gets the biggest of the 2 {@link JGMPVector2}
     * @param a first {@link JGMPVector2}
     * @param b second {@link JGMPVector2}
     * @return biggest {@link JGMPVector2} between the first and second {@link JGMPVector2}
     */
    public static JGMPVector2 max(JGMPVector2 a, JGMPVector2 b) {
        return new JGMPVector2(Math.max(a.x, b.x), Math.max(a.y, b.y));
    }

    /**
     * Static function to clamp elements inside a vector
     * @param v {@link JGMPVector2} to clamp elements
     * @param min min float value
     * @param max max float value
     * @return {@link JGMPVector2} with clamped elements
     */
    public static JGMPVector2 clamp(JGMPVector2 v, JGMPVector2 min, JGMPVector2 max) {
        return new JGMPVector2(JGMPFloatH.clamp(v.x, min.x, max.x), JGMPFloatH.clamp(v.y, min.y, max.y));
    }

    /**
     * Static function to lerp the elements inside a {@link JGMPVector2}
     * @param initial initial {@link JGMPVector2}
     * @param ending ending {@link JGMPVector2}
     * @param t t float value
     * @return {@link JGMPVector2} with lerped elements
     */
    public static JGMPVector2 lerp(JGMPVector2 initial, JGMPVector2 ending, JGMPVector2 t) {
        return new JGMPVector2(JGMPFloatH.lerp(initial.x, ending.x, t.x), JGMPFloatH.lerp(initial.x, ending.x, t.x));
    }

    /**
     * Static function to project a {@link JGMPVector2} onto another {@link JGMPVector2}
     * @param a first {@link JGMPVector2}
     * @param b second {@link JGMPVector2}
     * @return projected {@link JGMPVector2}
     */
    public static JGMPVector2 project(JGMPVector2 a, JGMPVector2 b) {
        float v = a.dot(b) / b.dot(b);
        return b.multiplyScalar(v);
    }

    /**
     * Static function to round all the elements to a near multiple
     * @param v initial {@link JGMPVector2}
     * @param mult multiple {@link JGMPVector2}
     * @return {@link JGMPVector2} with elements rounded to a near multiple
     */
    public static JGMPVector2 roundToMultiple(JGMPVector2 v, JGMPVector2 mult) {
        return new JGMPVector2(JGMPFloatH.roundToMultiple(v.x, mult.x), JGMPFloatH.roundToMultiple(v.y, mult.y));
    }

    /**
     * Static function to round up all the elements to a near multiple
     * @param v initial {@link JGMPVector2}
     * @param mult multiple {@link JGMPVector2}
     * @return {@link JGMPVector2} with elements rounded up to a near multiple
     */
    public static JGMPVector2 roundUpToMultiple(JGMPVector2 v, JGMPVector2 mult) {
        return new JGMPVector2(JGMPFloatH.roundUpToMultiple(v.x, mult.x), JGMPFloatH.roundUpToMultiple(v.y, mult.y));
    }

    /**
     * Static function to round down all the elements to a near multiple
     * @param v initial {@link JGMPVector2}
     * @param mult multiple {@link JGMPVector2}
     * @return {@link JGMPVector2} with elements rounded down to a near multiple
     */
    public static JGMPVector2 roundDownToMultiple(JGMPVector2 v, JGMPVector2 mult) {
        return new JGMPVector2(JGMPFloatH.roundDownToMultiple(v.x, mult.x), JGMPFloatH.roundDownToMultiple(v.y, mult.y));
    }

    /**
     * Returns a {@link JGMPVector2} with the signs of the elements
     * @return {@link JGMPVector2} with signed elements
     */
    public JGMPVector2 sign() { return new JGMPVector2(JGMPFloatH.sign(this.x), JGMPFloatH.sign(this.y)); }

    /**
     * Returns a {@link JGMPVector2} with the absolute value of the elements
     * @return {@link JGMPVector2} with absolute value of the elements
     */
    public JGMPVector2 abs() { return new JGMPVector2(Math.abs(this.x), Math.abs(this.y)); }

    /**
     * Returns a {@link JGMPVector2} with the floored value of the elements
     * @return {@link JGMPVector2} with the floored values as the elements
     */
    public JGMPVector2 floor() { return new JGMPVector2((float)Math.floor(this.x), (float)Math.floor(this.y)); }

    /**
     * Returns a {@link JGMPVector2} with the ceiled value of the elements
     * @return {@link JGMPVector2} with the ceiled values as the elements
     */
    public JGMPVector2 ceil() { return new JGMPVector2((float)Math.ceil(this.x), (float)Math.ceil(this.y)); }

    /**
     * Returns a {@link JGMPVector2} with rounded elements
     * @return {@link JGMPVector2} with rounded elements
     */
    public JGMPVector2 round() { return new JGMPVector2(Math.round(this.x), Math.round(this.y)); }

    /**
     * Checks whether passed {@link JGMPVector2} is approximately equal to the current {@link JGMPVector2} by a relative error of 0.001
     * @param v second {@link JGMPVector2} to compare
     * @return boolean indicating whether the 2 {@link JGMPVector2} are approximately equal
     */
    public boolean approxEqual(JGMPVector2 v) { return JGMPFloatH.approxEqual(this.x, v.x) && JGMPFloatH.approxEqual(this.y, v.y); }

    /**
     * Returns a string representation of the {@link JGMPVector2} object
     * @return string representation
     */
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

}
