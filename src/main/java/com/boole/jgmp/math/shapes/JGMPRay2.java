package com.boole.jgmp.math.shapes;

import com.boole.jgmp.math.helpers.JGMPCollisionH;
import com.boole.jgmp.math.vectors.JGMPVector2;

/**
 * 2D Ray Shape Model for the JGMP Library. <br>
 * Includes many optimized tools for not only Rays (line segments) but also lines. <br>
 * Basic Linear Algebra functions and utilities avaialable.
 */
public class JGMPRay2 {

    /**
     * Length of the 2D Ray
     */
    public float length;

    /**
     * {@link JGMPVector2} indicating the starting point of the {@link JGMPRay2}
     */
    public JGMPVector2 start;

    /**
     * {@link JGMPVector2} indicating the ending point of the {@link JGMPRay2}
     */
    public JGMPVector2 end;

    /**
     * {@link JGMPVector2} indicating the direction the ray is pointing to from the starting point to the ending point.
     */
    public JGMPVector2 direction;

    /**
     * Initialize {@link JGMPRay2} objects given starting point, distance and direction. <br>
     * Based on the given information, the end point will be automatically calculated and set.
     * @param distance distance float value
     * @param start {@link JGMPVector2} starting point
     * @param direction {@link JGMPVector2} ending point
     */
    public JGMPRay2(float distance, JGMPVector2 start, JGMPVector2 direction) {
        this.length = distance;
        this.start = start;
        this.direction = direction;
        generateEndPoint();
    }

    /**
     * Initialize {@link JGMPRay2} objects given starting point, ending point. <br>
     * Based on the given information, the length of the line and the direction from the starting point to the ending point
     * will be automatically calculated and set.
     * @param start {@link JGMPVector2} starting point
     * @param end {@link JGMPVector2} ending point
     */
    public JGMPRay2(JGMPVector2 start, JGMPVector2 end) {
        this.start = start;
        this.end = end;
        JGMPVector2 point = end.copy();
        point.x -= start.x; point.y -= start.y;
        float angle = point.angle();
        this.direction = new JGMPVector2((float)Math.cos(angle), (float)Math.sin(angle));
        this.length = start.distanceFrom(end);
    }

    private void generateEndPoint() {
        float angle = direction.angle();
        float x = this.start.x + (float)Math.cos(angle) * length;
        float y = this.start.y + (float)Math.sin(angle) * length;
        end = new JGMPVector2(x, y);
    }

    /**
     * Copies the {@link JGMPRay2} object's contents into another object.
     * @return {@link JGMPRay2} 2D Ray copy
     */
    public JGMPRay2 copy() { return new JGMPRay2(this.start, this.end); }

    /**
     * Calculates the shortest distance between the current line segment and a different given line segment. <br>
     * Gets the pair of the 2 closest points between the 2 lines, rotates the graph to align one of the lines to
     * the x-axis and one of the points to the origin. and draws a line between them and 2 perpendicular lines at
     * each selected point. The shortest distance among all the 3 lines will be the shortest distance between the 2 given lines.
     * @param line {@link JGMPRay2} Second line segment to find the distance from the current {@link JGMPRay2}.
     * @return shortest distance float value
     */
    public float shortestDistanceFrom(JGMPRay2 line) {
        // If the 2 lines are intersecting, the shortest distance between them is 0
        if(JGMPCollisionH.isIntersecting(this, line)) return 0;

        // Generates copies so messing with values won't manipulate the original object
        JGMPRay2 a = this.copy();
        JGMPRay2 b = line.copy();

        // Setting all the points to be checked and minimum distance variable
        JGMPVector2[] fps = {a.start, a.end};
        JGMPVector2[] sps = {b.start, b.end};
        JGMPVector2[] all = {a.start, a.end, b.start, b.end};
        float minDistance = Float.MAX_VALUE;

        // Finding the shortest distance between 2 points of the 2 line segments
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

        // Rotating and aligning one of the line segments to the x-axis and setting one of the points to the origin
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

        // Constructing the perpendicular / normal lines at each of the 2 selected points
        JGMPRay2 nl1 = new JGMPRay2(1000000f, fp, JGMPVector2.UP);
        JGMPRay2 nl2 = new JGMPRay2(1000000f, sp, JGMPVector2.UP);

        // Finding the minimum distance between all 3 line segments.
        if(JGMPCollisionH.isIntersecting(b, nl1)) minDistance = Math.min(minDistance, b.shortestDistanceFrom(fp));
        if(JGMPCollisionH.isIntersecting(b, nl2)) minDistance = Math.min(minDistance, b.shortestDistanceFrom(sp));

        return minDistance;
    }

    /**
     * Calculates the shortest distance between the current line segment and a different given point. <br>
     * This function will treat the {@link JGMPRay2} as a straight line where both endpoints will be infinitely extended just like a line.
     * @param point {@link JGMPVector2} A point to find the distance from the current 2D Ray.
     * @return shortest distance float value
     */
    public float shortestDistanceFrom(JGMPVector2 point) {
        // Given LINE
        float m = (this.end.y-this.start.y)/(this.end.x-this.start.x);
        float b = this.start.y - (m*this.start.x);

        if(m == 0) return Math.abs(point.y-b);

        // Normal LINE
        float nm = -1f/m;
        float nb = point.y - (nm*point.x);

        // Intersection Point
        float x = (b-nb) / (nm-m);
        float y = m * x + b;
        JGMPVector2 intersectionPoint = new JGMPVector2(x, y).subtract(point);

        return intersectionPoint.length();
    }

}
