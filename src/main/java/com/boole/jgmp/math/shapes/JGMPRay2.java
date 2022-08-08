package com.boole.jgmp.math.shapes;

import com.boole.jgmp.math.helpers.JGMPCollisionH;
import com.boole.jgmp.math.vectors.JGMPVector2;

public class JGMPRay2 {

    public float length;
    public JGMPVector2 start, end, direction;

    public JGMPRay2(float distance, JGMPVector2 start, JGMPVector2 direction) {
        this.length = distance;
        this.start = start;
        this.direction = direction;
        generateEndPoint();
    }

    public JGMPRay2(JGMPVector2 start, JGMPVector2 end, JGMPVector2 direction) {
        this.start = start;
        this.end = end;
        this.direction = direction;
        this.length = start.distanceFrom(end);
    }

    private void generateEndPoint() {
        float angle = direction.angle();
        float x = (float)Math.cos(angle) * length;
        float y = (float)Math.sin(angle) * length;
        end = new JGMPVector2(x, y);
    }

    public JGMPRay2 copy() { return new JGMPRay2(this.start, this.end, this.direction); }

    public float shortestDistanceFrom(JGMPRay2 line) {
        if(JGMPCollisionH.isIntersecting(this, line)) return 0;

        JGMPRay2 a = this.copy();
        JGMPRay2 b = line.copy();

        JGMPVector2[] fps = {a.start, a.end};
        JGMPVector2[] sps = {b.start, b.end};
        JGMPVector2[] all = {a.start, a.end, b.start, b.end};
        float minDistance = Float.MAX_VALUE;

        JGMPVector2 fp = JGMPVector2.ZERO;
        JGMPVector2 fpb;
        JGMPVector2 sp = JGMPVector2.ZERO;
        for(JGMPVector2 p1 : fps) {
            for(JGMPVector2 p2 : sps) {
                float distance = p1.distanceFrom(p2);
                if(distance < minDistance) {
                    minDistance = distance;
                    fp = p1;
                    sp = p2;
                }
            }
        }
        fpb = fp == a.start ? a.end : a.start;

        float rx = fp.x, ry = fp.y;
        for(JGMPVector2 point : all) {
            point.x -= rx;
            point.y -= ry;
        }
        float angle = fpb.angle();
        JGMPVector2 center = fp;
        for(JGMPVector2 point : all) {
            if(point == center) continue;
            point.rotate(angle);
        }

        JGMPRay2 nl1 = new JGMPRay2(1000000f, fp, JGMPVector2.UP);
        JGMPRay2 nl2 = new JGMPRay2(1000000f, sp, JGMPVector2.UP);
        if(JGMPCollisionH.isIntersecting(b, nl1)) minDistance = Math.min(minDistance, b.shortestDistanceFrom(fp));
        if(JGMPCollisionH.isIntersecting(b, nl2)) minDistance = Math.min(minDistance, b.shortestDistanceFrom(sp));

        return minDistance;
    }

    public float shortestDistanceFrom(JGMPVector2 point) {
        // Given LINE
        float m = (this.end.y-this.start.y)/(this.end.x-this.start.x);
        float b = this.start.y - (m*this.start.x);

        // Normal LINE
        float nm = -1/m;
        float nb = point.y - (nm*point.x);

        // Intersection Point
        float x = (b-nb) / (nm-m);
        float y = m * x + b;
        JGMPVector2 intersectionPoint = new JGMPVector2(x, y).subtract(point);

        return intersectionPoint.length();
    }

}
