package com.boole.jgpm.physics;

import com.boole.jgmp.physics.JGMPGravity;
import org.junit.Assert;
import org.junit.Test;

public class JGMPGravityTest {

    private static final float epsilon = 0.001f;

    @Test
    public void gravityTests() {
        Assert.assertEquals("Default acceleration is not 9.8 m/s/s", 9.8f, JGMPGravity.gravity.force, epsilon);

        JGMPGravity.setAcceleration(6.9f);
        Assert.assertEquals("Changing acceleration is erroring", 6.9f, JGMPGravity.gravity.force, epsilon);
    }

}
