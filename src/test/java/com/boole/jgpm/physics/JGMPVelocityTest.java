package com.boole.jgpm.physics;

import com.boole.jgmp.math.vectors.JGMPVector2;
import com.boole.jgmp.physics.JGMPVelocity;
import org.junit.Assert;
import org.junit.Test;

public class JGMPVelocityTest {

    private static final float epsilon = 0.001f;

    @Test
    public void velocityTests() {
        JGMPVelocity velocity = new JGMPVelocity(JGMPVector2.right(), 4f);

        Assert.assertEquals("Initializing velocity does not work!", 4f, velocity.velocity, epsilon);
        velocity.stopXVelocity();
        Assert.assertEquals("Stopping velocity x does not work!", 0f, velocity.direction.x, epsilon);
        velocity.stopYVelocity();
        Assert.assertEquals("Stopping velocity y does not work!", 0f, velocity.direction.y, epsilon);
    }


}
