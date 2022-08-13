package com.boole.jgpm.math.helpers;

import com.boole.jgmp.math.helpers.JGMPFloatH;
import org.junit.Assert;
import org.junit.Test;

public class JGMPFloatHTest {

    private static float epsilon = 0.0001f;

    @Test
    public void floatTests() {
        Assert.assertEquals("error in min()", 3, JGMPFloatH.min(3,5), epsilon);
        Assert.assertEquals("error in min()", -5, JGMPFloatH.min(3,-5), epsilon);
        Assert.assertEquals("error in max()", 5, JGMPFloatH.max(3,5), epsilon);
        Assert.assertEquals("error in max()", 3, JGMPFloatH.max(3,-5), epsilon);
        Assert.assertEquals("error in clamp()", 2, JGMPFloatH.clamp(3,-2, 2), epsilon);
        Assert.assertEquals("error in clamp()", 3, JGMPFloatH.clamp(3,-5, 7), epsilon);
        Assert.assertEquals("error in lerp()", JGMPFloatH.lerp(3,5, 5), 13, epsilon);
        Assert.assertEquals("error in inverseLerp()", JGMPFloatH.inverseLerp(3,5, 5), 1, epsilon);
        Assert.assertEquals("error in sign()", 1, JGMPFloatH.sign(3), epsilon);
        Assert.assertEquals("error in sign()", -1, JGMPFloatH.sign(-3), epsilon);
        Assert.assertEquals("error in sign()", 0, JGMPFloatH.sign(0), epsilon);
        Assert.assertEquals("error in roundToMultiple()", 15, JGMPFloatH.roundToMultiple(14, 3), 3);
        Assert.assertTrue("error in approxEqual()", JGMPFloatH.approxEqual(3f, 2.9999f));
    }

}
