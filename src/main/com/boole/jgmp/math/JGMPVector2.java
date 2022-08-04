package main.com.boole.jgmp.math;

public class JGMPVector2<K, V> {

    // Vector Key and Value
    public K x;
    public V y;

    public JGMPVector2(K x, V y) {
        this.x = x;
        this.y = y;
    }

    public JGMPVector2<JGMPFloat16, JGMPFloat16> toFloat16() {
        return new JGMPVector2<>(new JGMPFloat16((float) this.x), new JGMPFloat16((float) this.y));
    }
    public boolean equals(JGMPVector2<K, V> v) { return this.x.equals(v.x) && this.y.equals(v.y); }
    public int compareTo(JGMPVector2<Integer, Integer> v) {
        if(this.x.equals(v.x)) return Integer.compare((int)this.y, v.y);
        return Integer.compare((int)this.x, v.x);
    }

    public static JGMPVector2<Integer, Integer> ZERO = new JGMPVector2<>(0, 0);
    public static JGMPVector2<Integer, Integer> INF = new JGMPVector2<>(Integer.MAX_VALUE, Integer.MAX_VALUE);
    public static JGMPVector2<Integer, Integer> NEG_INF = new JGMPVector2<>(Integer.MIN_VALUE, Integer.MIN_VALUE);

    public static JGMPVector2<Integer, Integer> add(JGMPVector2<Integer, Integer> a, JGMPVector2<Integer, Integer> b) {
        return new JGMPVector2<>(a.x+b.x, a.y+b.y);
    }
    public static JGMPVector2<Integer, Integer> subtract(JGMPVector2<Integer, Integer> a, JGMPVector2<Integer, Integer> b) {
        return new JGMPVector2<>(a.x-b.x, a.y-b.y);
    }
    public static JGMPVector2<Integer, Integer> multiply(JGMPVector2<Integer, Integer> a, JGMPVector2<Integer, Integer> b) {
        return new JGMPVector2<>(a.x*b.x, a.y*b.y);
    }
    public static JGMPVector2<Integer, Integer> divide(JGMPVector2<Integer, Integer> a, JGMPVector2<Integer, Integer> b) {
        return new JGMPVector2<>(a.x/b.x, a.y/b.y);
    }
    public static JGMPVector2<Float, Float> add(JGMPVector2<Float, Float> a, JGMPVector2<Float, Float> b) {
        return new JGMPVector2<>(a.x+b.x, a.y+b.y);
    }
    public static JGMPVector2<Float, Float> subtract(JGMPVector2<Float, Float> a, JGMPVector2<Float, Float> b) {
        return new JGMPVector2<>(a.x-b.x, a.y-b.y);
    }
    public static JGMPVector2<Float, Float> multiply(JGMPVector2<Float, Float> a, JGMPVector2<Float, Float> b) {
        return new JGMPVector2<>(a.x*b.x, a.y*b.y);
    }
    public static JGMPVector2<Float, Float> divide(JGMPVector2<Float, Float> a, JGMPVector2<Float, Float> b) {
        return new JGMPVector2<>(a.x/b.x, a.y/b.y);
    }

}
