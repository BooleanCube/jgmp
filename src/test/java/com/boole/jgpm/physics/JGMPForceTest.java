package com.boole.jgpm.physics;

import com.boole.jgmp.math.vectors.JGMPVector2;
import com.boole.jgmp.physics.JGMPForce;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JGMPForceTest {

    private static final float epsilon = 0.001f;

    @Test
    public void forceTests() {
        JGMPForce force1 = new JGMPForce(JGMPVector2.up(), 2f);
        JGMPForce force2 = new JGMPForce(JGMPVector2.right(), 2f);
        JGMPForce force3 = new JGMPForce(JGMPVector2.down(), 3f);
        JGMPForce force4 = force1.addForce(force2);
        JGMPForce force5 = JGMPForce.netForce(List.of(new JGMPForce[]{force1, force2, force3, force4}));

        Assert.assertEquals("Error occurred in scalar addition of forces", 0.70710677f, force4.direction.x, epsilon);
        Assert.assertEquals("Error occurred in scalar addition of forces", 0.70710677f, force4.direction.x, epsilon);
        Assert.assertEquals("Error occurred in scalar addition of forces", 2.828427, force4.force, epsilon);
        Assert.assertEquals("Error occurred in calculation of net force", 4.1231055f, force5.force, epsilon);
        Assert.assertEquals("Error occurred in calculation of net force", 0.97014254f, force5.direction.x, epsilon);
        Assert.assertEquals("Error occurred in calculation of net force", 0.24253558f, force5.direction.y, epsilon);
    }

}
