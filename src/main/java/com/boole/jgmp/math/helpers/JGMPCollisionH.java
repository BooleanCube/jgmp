package com.boole.jgmp.math.helpers;

import com.boole.jgmp.math.shapes.JGMPCircle;
import com.boole.jgmp.math.shapes.JGMPRay2;
import com.boole.jgmp.math.shapes.JGMPRect;

/**
 * Collision Checking Helper with optimized collision checking methods between provided shapes in the JGMP Library. <br>
 * Provided Shapes: {@link JGMPRay2}, {@link JGMPCircle}, {@link JGMPRect} <br>
 * Source Code for the Shape Models can be found in <a href="https://github.com/BooleanCube/jgmp/tree/main/src/main/java/com/boole/jgmp/math/shapes">~/com/boole/jgmp/math/shapes/</a>
 */
public class JGMPCollisionH {

    /**
     * Static collision check method to check whether 2 Lines are intersecting each other. <br>
     * If there is a solution between the equations of the 2 lines then they are colliding.
     * @param a {@link JGMPRay2} - Ray2D a
     * @param b {@link JGMPRay2} - Ray2D b
     * @return boolean indicating whether the 2 lines are intersecting each other.
     */
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

    /**
     * Static collision check method to check whether two 2D Rectangles are colliding with each other or not. <br>
     * Compares all 4 points of both rectangles to see whether the 2 rectangles are colliding or not.
     * @param a {@link JGMPRect} - Rectangle A
     * @param b {@link JGMPRect} - Rectangle B
     * @return boolean indicating whether 2 rectangles are colliding.
     */
    public static boolean isColliding(JGMPRect a, JGMPRect b) {
        if(a.topRight.y < b.bottomLeft.y || a.bottomLeft.y > b.topRight.y) return false;
        if(a.topRight.x < b.bottomLeft.x || a.bottomLeft.x > b.topRight.x) return false;
        return true;
    }

    /**
     * Static collision check method to check whether a 2D Rectangle and a 2D Ray are colliding with each other. <br>
     * If any of the 4 sides of the rectangle are intersecting with a 2d Ray, the whole Rectangle is colliding with the 2D Ray.
     * @param a {@link JGMPRect} - Rectangle A
     * @param b {@link JGMPRay2} - Ray2D b
     * @return boolean indicating whether a rectangle and a line collide with each other.
     */
    public static boolean isColliding(JGMPRect a, JGMPRay2 b) {
        return isIntersecting(a.top, b) ||
                isIntersecting(a.right, b) ||
                isIntersecting(a.bottom, b) ||
                isIntersecting(a.left, b);
    }

    /**
     * Static collision check method to check whether a Circle and a Line are colliding with each other. <br>
     * If the shortest distance from the center of the circle and the line is less than or equal to the radius
     * then the line and circle must intersect at some point. <br>
     * The ray that is passed in will be treated as a line, meaning that both endpoints of the ray will be
     * extended infinitely like a line.
     * @param a {@link JGMPCircle} - Circle a
     * @param b {@link JGMPRay2} - Ray2D b (as a line and NOT a line segment which means that both points are extended infinitely)
     * @return boolean indicating whether the circle and line are colliding with each other.
     */
    public static boolean isColliding(JGMPCircle a, JGMPRay2 b) {
        float distance = b.shortestDistanceFrom(a.center);
        return a.radius >= distance;
    }

    /**
     * Static collision check method to check whether the given Line is tangent with the Circle. <br>
     * If the shortest distance from the center of the circle and the line is equal to the radius then the line is tangent. <br>
     * The ray that is passed in will be treated as a line, meaning that both endpoints of the ray will be
     * extended infinitely like a line.
     * @param a {@link JGMPCircle} - Circle a
     * @param b {@link JGMPRay2} - Ray2D b (as a line and NOT a line segment which means that both points are extended infinitely)
     * @return boolean indicating whether the line is tangent to the circle.
     */
    public static boolean isTangent(JGMPCircle a, JGMPRay2 b) {
        float distance = b.shortestDistanceFrom(a.center);
        return a.radius == distance;
    }

    /**
     * Static collision check method to check whether a Circle and a 2D Rectangle are colliding with each other. <br>
     * If any of the sides of the rectangle are colliding with the circle then the rectangle is also colliding with the circle
     * @param a {@link JGMPCircle} - Circle a
     * @param b {@link JGMPRect} - Rectangle b
     * @return boolean indicating whether the circle and rectangle are colliding with each other.
     */
    public static boolean isColliding(JGMPCircle a, JGMPRect b) {
        return isColliding(a, b.top) ||
                isColliding(a, b.right) ||
                isColliding(a, b.bottom) ||
                isColliding(a, b.left);
    }

    /**
     * Static collision check method to check whether 2 circles are colliding with each other. <br>
     * If the distance between the 2 centers are less than or equal to the sum of the radii, then the circles must be colliding.
     * @param a {@link JGMPCircle} - Circle a
     * @param b {@link JGMPRay2} - Ray2D b
     * @return boolean indicating whether the circle and 2D ray are colliding with each other.
     */
    public static boolean isColliding(JGMPCircle a, JGMPCircle b) {
        float distance = a.center.distanceFrom(b.center);
        return (a.radius+b.radius) >= distance;
    }

}
