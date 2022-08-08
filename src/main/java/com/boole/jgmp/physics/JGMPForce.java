package com.boole.jgmp.physics;

import com.boole.jgmp.math.vectors.JGMPVector2;

import java.util.List;

public class JGMPForce {

    public JGMPVector2 direction;
    public float force;

    public JGMPForce(JGMPVector2 direction, float force) {
        this.direction = direction;
        this.force = force;
    }

    public JGMPForce copy() { return new JGMPForce(this.direction, this.force); }

    public JGMPForce addForce(JGMPForce force) {
        JGMPVector2 current = this.direction.multiplyScalar(this.force); // End Point of the Force Ray
        JGMPVector2 addition = force.direction.multiplyScalar(this.force); // End Point of the Force Ray
        JGMPVector2 netForce = current.add(addition); // Adding up the end points of the forces
        JGMPVector2 dir = new JGMPVector2((float)Math.cos(netForce.angle()), (float)Math.sin(netForce.angle()));
        return new JGMPForce(dir, netForce.length());
    }

    public JGMPForce netForce(List<JGMPForce> forces) {
        JGMPForce netForce = forces.get(0);
        for(int i=1; i<forces.size(); i++) netForce = netForce.addForce(forces.get(i));
        return netForce;
    }

    public JGMPForce negativeForce() {
        JGMPForce oppositeForce = this.copy();
        oppositeForce.direction = oppositeForce.direction.negative();
        return oppositeForce;
    }

}
