package com.boole.jgm.math;

public class JGMVector2<K, V> {

    // Vector Key and Value
    public K x;
    public V y;

    public JGMVector2(K x, V y) {
        this.x = x;
        this.y = y;
    }

    public JGMVector2<JGMFloat16, JGMFloat16> toFloat16() {
        return new JGMVector2<>(new JGMFloat16((float) this.x), new JGMFloat16((float) this.y));
    }
    public boolean equals(JGMVector2<K, V> v) { return this.x.equals(v.x) && this.y.equals(v.y); }
    public int compareTo(JGMVector2<Integer, Integer> v) {
        if(this.x.equals(v.x)) return Integer.compare((int)this.y, v.y);
        return Integer.compare((int)this.x, v.x);
    }

    public static JGMVector2<Integer, Integer> ZERO = new JGMVector2<>(0, 0);
    public static JGMVector2<Integer, Integer> INF = new JGMVector2<>(Integer.MAX_VALUE, Integer.MAX_VALUE);
    public static JGMVector2<Integer, Integer> NEG_INF = new JGMVector2<>(Integer.MIN_VALUE, Integer.MIN_VALUE);

    public static JGMVector2<Integer, Integer> add(JGMVector2<Integer, Integer> a, JGMVector2<Integer, Integer> b) {
        return new JGMVector2<>(a.x+b.x, a.y+b.y);
    }
    public static JGMVector2<Integer, Integer> subtract(JGMVector2<Integer, Integer> a, JGMVector2<Integer, Integer> b) {
        return new JGMVector2<>(a.x-b.x, a.y-b.y);
    }
    public static JGMVector2<Integer, Integer> multiply(JGMVector2<Integer, Integer> a, JGMVector2<Integer, Integer> b) {
        return new JGMVector2<>(a.x*b.x, a.y*b.y);
    }
    public static JGMVector2<Integer, Integer> divide(JGMVector2<Integer, Integer> a, JGMVector2<Integer, Integer> b) {
        return new JGMVector2<>(a.x/b.x, a.y/b.y);
    }
    public static JGMVector2<Float, Float> add(JGMVector2<Float, Float> a, JGMVector2<Float, Float> b) {
        return new JGMVector2<>(a.x+b.x, a.y+b.y);
    }
    public static JGMVector2<Float, Float> subtract(JGMVector2<Float, Float> a, JGMVector2<Float, Float> b) {
        return new JGMVector2<>(a.x-b.x, a.y-b.y);
    }
    public static JGMVector2<Float, Float> multiply(JGMVector2<Float, Float> a, JGMVector2<Float, Float> b) {
        return new JGMVector2<>(a.x*b.x, a.y*b.y);
    }
    public static JGMVector2<Float, Float> divide(JGMVector2<Float, Float> a, JGMVector2<Float, Float> b) {
        return new JGMVector2<>(a.x/b.x, a.y/b.y);
    }

}
