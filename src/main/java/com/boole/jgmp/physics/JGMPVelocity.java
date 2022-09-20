package com.boole.jgmp.physics;

import com.boole.jgmp.math.vectors.JGMPVector2;

/**
 * Kinematics Velocity Physics Model for the JGMP Library. <br>
 * Includes Vector Math and 2D Kinematics calculations.
 */
public class JGMPVelocity {

    /**
     * Direction of the {@link JGMPVelocity}.
     */
    public JGMPVector2 direction;

    /**
     * Magnitude of the {@link JGMPVelocity}.
     */
    public float velocity;

    /**
     * Initialize {@link JGMPVelocity} object with the initial velocity and direction.
     * @param initialVelocity initial velocity an object starts with and initialDirection initial direction
     *                        an object starts with.
     */
    public JGMPVelocity(JGMPVector2 initialDirection, float initialVelocity) {
        this.direction = initialDirection;
        this.velocity = initialVelocity;
    }

    /**
     * Updates velocity according to the net force passed in.
     * @param netForce {@link JGMPForce} given to update {@link JGMPVelocity}
     */
    public void updateVelocity(JGMPForce netForce) {
        this.direction = netForce.direction;
        this.velocity += netForce.force;
    }

    /**
     * Resets the {@link JGMPVelocity} to 0 and sets the object in rest.
     */
    public void stopVelocity() {
        this.direction = JGMPVector2.zero();
        this.velocity = 0f;
    }

    /**
     * Cancels out any velocity in the x direction.
     */
    public void stopXVelocity() {
        float xForce = this.velocity * (float)Math.cos(this.direction.angle());
        this.velocity -= xForce;
        this.direction.x = 0f;
    }

    /**
     * Cancels out any velocity in the y direction.
     */
    public void stopYVelocity() {
        float yForce = this.velocity * (float)Math.sin(this.direction.angle());
        this.velocity -= yForce;
        this.direction.y = 0f;
    }

}
