package com.boole.jgmp.math.helpers;

import com.boole.jgmp.math.shapes.JGMPCircle;
import com.boole.jgmp.math.shapes.JGMPRay2;
import com.boole.jgmp.math.shapes.JGMPRect;

public class JGMPCollisionH {

    public static boolean isColliding(JGMPRect a, JGMPRect b) {
        if(a.topRight.y < b.bottomLeft.y || a.bottomLeft.y > b.topRight.y) return false;
        if(a.topRight.x < b.bottomLeft.x || a.bottomLeft.x > b.topRight.x) return false;
        return true;
    }

    public static boolean isColliding(JGMPRect a, JGMPRay2 b) {
        return isIntersecting(a.top, b) ||
                isIntersecting(a.right, b) ||
                isIntersecting(a.bottom, b) ||
                isIntersecting(a.left, b);
    }

    public static boolean isIntersecting(JGMPRay2 a, JGMPRay2 b) {
        float s1x = a.end.x - a.start.x;
        float s1y = a.end.y - a.start.y;
        float s2x = b.end.x - b.start.x;
        float s2y = b.end.y - b.start.y;

        float v = -s2x * s1y + s1x * s2y;
        float s = (-s1y * (a.start.x-b.start.x) + s1x * (a.start.y-b.start.y)) / v;
        float t = (s2x * (a.start.y-b.start.y) - s2y * (a.start.x-b.start.x)) / v;

        return s >= 0 && s <= 1 && t >= 0 && t <= 1;
    }

    public static boolean isColliding(JGMPCircle a, JGMPRay2 b) {
        float distance = b.shortestDistanceFrom(a.center);
        return a.radius >= distance;
    }

    public static boolean isTangent(JGMPCircle a, JGMPRay2 b) {
        float distance = b.shortestDistanceFrom(a.center);
        return a.radius == distance;
    }

    public static boolean isColliding(JGMPCircle a, JGMPRect b) {
        return isColliding(a, b.top) ||
                isColliding(a, b.right) ||
                isColliding(a, b.bottom) ||
                isColliding(a, b.left);
    }

    public static boolean isColliding(JGMPCircle a, JGMPCircle b) {
        float distance = a.center.distanceFrom(b.center);
        return (a.radius+b.radius) >= distance;
    }

}
