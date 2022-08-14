package com.boole.jgpm.math.helpers;

import com.boole.jgmp.math.helpers.JGMPCollisionH;
import com.boole.jgmp.math.shapes.JGMPCircle;
import com.boole.jgmp.math.shapes.JGMPRay2;
import com.boole.jgmp.math.shapes.JGMPRect;
import com.boole.jgmp.math.vectors.JGMPVector2;
import org.junit.Assert;
import org.junit.Test;

public class JGMPCollisionHTest {

    @Test
    public void collisionTests() {
        JGMPCircle circle = new JGMPCircle(JGMPVector2.zero(), 5);
        JGMPRect rect = new JGMPRect(0f, 0f, 6f, 6f);
        JGMPRay2 ray = new JGMPRay2(new JGMPVector2(-5f, -5f), new JGMPVector2(5f, 5f));
        JGMPRay2 tangent = new JGMPRay2(4, new JGMPVector2(-2f,-5f), JGMPVector2.right());

        Assert.assertTrue("Circle vs Rectangle", JGMPCollisionH.isColliding(circle, rect));
        Assert.assertFalse("Circle vs Ray Tangent", JGMPCollisionH.isTangent(circle, ray));
        Assert.assertTrue("Circle vs Tangent", JGMPCollisionH.isTangent(circle, tangent));
        Assert.assertTrue("Circle vs Ray Colliding", JGMPCollisionH.isColliding(circle, ray));
        Assert.assertTrue("Circle vs Tangent Colliding", JGMPCollisionH.isColliding(circle, tangent));
        Assert.assertFalse("Circle vs Outside Ray", JGMPCollisionH.isColliding(circle, rect.right));
        Assert.assertTrue("Ray vs Rectangle", JGMPCollisionH.isColliding(rect, ray));
    }

}
