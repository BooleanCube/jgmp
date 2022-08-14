package com.boole.jgmp.physics;

import com.boole.jgmp.math.vectors.JGMPVector2;

/**
 * Static Universal Gravity Force Model for the JGMP Library. <br>
 * If you plan to use more than 1 Gravity Model for your application, you will have to create your
 * own Static Gravity Model for each different one.
 */
public class JGMPGravity {

    /**
     * Static Float Acceleration for Universal Gravity Mode. <br>
     * Default acceleration = 9.8 m/s^2.
     */
    public static float acceleration = 9.8f;

    /**
     * Universal Static Gravity Force Model that uses the acceleration set. <br>
     * Default acceleration = 9.8 m/s^2
     */
    public final static JGMPForce gravity = new JGMPForce(JGMPVector2.down(), acceleration);

    /**
     * Static function to set the acceleration value for all the objects in this Gravity Field.
     * @param acceleration new acceleration float value
     */
    public static void setAcceleration(float acceleration) {
        JGMPGravity.acceleration = acceleration;
        JGMPGravity.gravity.force = JGMPGravity.acceleration;
    }

}
