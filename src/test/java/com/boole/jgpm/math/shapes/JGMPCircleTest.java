package com.boole.jgpm.math.shapes;

import com.boole.jgmp.math.shapes.JGMPCircle;
import com.boole.jgmp.math.vectors.JGMPVector2;
import org.junit.Assert;
import org.junit.Test;

public class JGMPCircleTest {

    private static final float epsilon = 0.001f;

    @Test
    public void circleTests() {
        JGMPCircle circle = new JGMPCircle(JGMPVector2.zero(), 5f);

        Assert.assertEquals("error in radius assignment", 5f, circle.radius, epsilon);
        Assert.assertEquals("error in diameter assignment", 10f, circle.diameter, epsilon);
        Assert.assertEquals("error in center assignment", 0f, circle.center.x, epsilon);
        Assert.assertEquals("error in center assignment", 0f, circle.center.y, epsilon);
        Assert.assertEquals("error in surface area calculation", Math.PI*25f, circle.area(), epsilon);
        Assert.assertEquals("error in perimeter calculation", Math.PI*10f, circle.perimeter(), epsilon);
    }

}
