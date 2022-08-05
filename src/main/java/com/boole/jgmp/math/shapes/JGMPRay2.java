package com.boole.jgmp.math.shapes;

import com.boole.jgmp.math.vectors.JGMPVector2;

public class JGMPRay2 {

    public float len;
    public JGMPVector2 start, end, dir;

    public JGMPRay2(float dis, JGMPVector2 start, JGMPVector2 dir) {
        this.len = dis;
        this.start = start;
        this.dir = dir;
        generateEndPoint();
    }

    public JGMPRay2(JGMPVector2 start, JGMPVector2 end, JGMPVector2 dir) {
        this.start = start;
        this.end = end;
        this.dir = dir;
        this.len = start.distanceFrom(end);
    }

    private void generateEndPoint() {
        float angle = dir.angle();
        float x = (float)Math.cos(angle) * len;
        float y = (float)Math.sin(angle) * len;
        end = new JGMPVector2(x, y);
    }

    public float distanceFrom(JGMPVector2 point) {
        
    }

}
