package com.boole.jgmp.math.shapes;

import com.boole.jgmp.math.vectors.JGMPVector2;

public class JGMPCircle {

    public JGMPVector2 center;
    public float radius, diameter;

    public JGMPRay2 up, right, down, left;
    private void initRays() {
        up = new JGMPRay2(radius, center, JGMPVector2.UP);
        right = new JGMPRay2(radius, center, JGMPVector2.RIGHT);
        down = new JGMPRay2(radius, center, JGMPVector2.DOWN);
        left = new JGMPRay2(radius, center, JGMPVector2.LEFT);
    }

    private void init() { initRays(); }

    public JGMPCircle(JGMPVector2 center, float radius) {
        this.center = center;
        this.radius = radius;
        this.diameter = radius*2;
        init();
    }

    public float area() { return (float)(Math.PI*Math.pow(radius,2)); }
    public float perimeter() { return (float)Math.PI*diameter; }

}
