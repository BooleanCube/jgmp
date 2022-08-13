package com.boole.jgpm.math.shapes;

import com.boole.jgmp.math.shapes.JGMPRect;
import com.boole.jgmp.math.vectors.JGMPVector2;
import org.junit.Assert;
import org.junit.Test;

public class JGMPRectTest {

    private final static float epsilon = 0.001f;

    @Test
    public void rectangleTests() {
        JGMPRect rect = new JGMPRect(0, 0, 5, 5);
        JGMPRect rect2 = new JGMPRect(JGMPVector2.ONE, new JGMPVector2(3, 4));

        Assert.assertTrue("error in center init", rect.center.approxEqual(new JGMPVector2(2.5f, -2.5f)));
        Assert.assertTrue("error in point init", rect.bottomRight.approxEqual(new JGMPVector2(5f, -5f)));
        Assert.assertEquals("error in width()", 2f, rect2.width(), epsilon);
        Assert.assertEquals("error in height()", 3f, rect2.height(), epsilon);
        Assert.assertEquals("error in area()", 25f, rect.area(), epsilon);
        Assert.assertEquals("error in perimeter()", 20f, rect.perimeter(), epsilon);
    }

}
