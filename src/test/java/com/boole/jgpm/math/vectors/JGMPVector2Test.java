package com.boole.jgpm.math.vectors;

import com.boole.jgmp.math.vectors.JGMPVector2;
import org.junit.Assert;
import org.junit.Test;

public class JGMPVector2Test {

    private static final float epsilon = 0.001f;

    @Test
    public void vectorTests() {
        JGMPVector2 v1 = new JGMPVector2(1f, 2f);
        JGMPVector2 v2 = JGMPVector2.left();

        Assert.assertEquals("error in dot()", 3f, v1.dot(JGMPVector2.one()), epsilon);
        Assert.assertEquals("error in dot()", 2f, v1.dot(new JGMPVector2(v1.y, 0f)), epsilon);
        Assert.assertEquals("error in cross()", 3f, v1.dot(JGMPVector2.one()), epsilon);
        Assert.assertEquals("error in angle()", (float)Math.PI, v2.angle(), epsilon);

        v1.rotate((float)Math.PI);
        Assert.assertEquals("error in rotate()", 2f, v1.x, epsilon);
        Assert.assertEquals("error in rotate()", -1f, v1.y, epsilon);
    }

}
