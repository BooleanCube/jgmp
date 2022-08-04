package main.com.boole.jgmp.math;

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
    public static JGMPVector2 INF = new JGMPVector2(Float.MAX_VALUE, Float.MAX_VALUE);
    public static JGMPVector2 NEG_INF = new JGMPVector2(Float.MIN_VALUE, Float.MIN_VALUE);

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

}
