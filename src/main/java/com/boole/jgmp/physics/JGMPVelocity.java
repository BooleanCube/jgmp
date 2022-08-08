package com.boole.jgmp.physics;

import com.boole.jgmp.math.vectors.JGMPVector2;

public class JGMPVelocity {

    public JGMPVector2 direction;
    public float velocity;

    public JGMPVelocity(float initialVelocity) {
        this.velocity = initialVelocity;
    }

    public void updateVelocity(JGMPForce netForce) {
        this.direction = netForce.direction;
        this.velocity += netForce.force;
    }

    public void stopVelocity() {
        this.direction = JGMPVector2.ZERO;
        this.velocity = 0f;
    }

    public void stopXVelocity() {
        float xForce = this.velocity * (float)Math.cos(this.direction.angle());
        this.velocity -= xForce;
        this.direction.x = 0f;
    }

    public void stopYVelocity() {
        float yForce = this.velocity * (float)Math.sin(this.direction.angle());
        this.velocity -= yForce;
        this.direction.y = 0f;
    }

}
