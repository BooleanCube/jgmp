package com.boole.jgpm.math.shapes;

import com.boole.jgmp.math.shapes.JGMPRay2;
import com.boole.jgmp.math.vectors.JGMPVector2;
import org.junit.Assert;
import org.junit.Test;

public class JGMPRay2Test {

    private final static float epsilon = 0.001f;

    @Test
    public void rayTests() {
        JGMPRay2 ray = new JGMPRay2(JGMPVector2.ZERO, JGMPVector2.ONE);
        JGMPRay2 ray2 = new JGMPRay2(2f, new JGMPVector2(1,0), JGMPVector2.UP);
        JGMPRay2 ray3 = new JGMPRay2(3f, new JGMPVector2(2, 0), JGMPVector2.UP);

        Assert.assertEquals("error in shortestDistanceFrom(ray)", 0f, ray.shortestDistanceFrom(ray2), epsilon);
        Assert.assertEquals("error in shortestDistanceFrom(ray)", 1f, ray.shortestDistanceFrom(ray3), epsilon);
        Assert.assertEquals("error in shortestDistanceFrom(ray)", 1f, ray3.shortestDistanceFrom(ray2), epsilon);
        Assert.assertEquals("error in shortestDistanceFrom(point)", 0f, ray.shortestDistanceFrom(JGMPVector2.ONE), epsilon);
        Assert.assertEquals("error in shortestDistanceFrom(point)", 1f, ray3.shortestDistanceFrom(JGMPVector2.ONE), epsilon);
        Assert.assertEquals("error in end point init", 1f, ray2.end.x, epsilon);
        Assert.assertEquals("error in end point init", 2f, ray2.end.y, epsilon);
        Assert.assertEquals("error in distance measurement", 1f, ray2.end.x, epsilon);
        Assert.assertEquals("error in distance measurement", Math.sqrt(2f), ray.length, epsilon);
    }

}
