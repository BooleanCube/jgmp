package com.boole.jgmp.physics;

import com.boole.jgmp.math.vectors.JGMPVector2;

public class JGMPGravity {

    public static float acceleration = 9.8f;
    public final static JGMPForce gravity = new JGMPForce(JGMPVector2.DOWN, acceleration);

    public static void setAcceleration(float acceleration) {
        JGMPGravity.acceleration = acceleration;
        JGMPGravity.gravity.force = JGMPGravity.acceleration;
    }

}
