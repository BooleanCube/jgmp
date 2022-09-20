package com.boole.jgmp.physics;

import com.boole.jgmp.math.vectors.JGMPVector2;

import java.util.List;

/**
 * Kinematics Force Physics Model for the JGMP Library. <br>
 * Includes Vector Math and 2D Kinematics calculations.
 */
public class JGMPForce {

    /**
     * Direction the force.
     */
    public JGMPVector2 direction;

    /**
     * Magnitude of the given force. <br>
     * Force = mass * acceleration
     */
    public float force;

    /**
     * Initialize {@link JGMPForce} object representing a force done on an object.
     * @param direction direction of the {@link JGMPForce}
     * @param force magnitude of the {@link JGMPForce}
     */
    public JGMPForce(JGMPVector2 direction, float force) {
        this.direction = direction;
        this.force = force;
    }

    /**
     * Copies the {@link JGMPForce} object into another {@link JGMPForce} object and returns it.
     * @return copied {@link JGMPForce} object
     */
    public JGMPForce copy() { return new JGMPForce(this.direction, this.force); }

    /**
     * Returns the sum of 2 forces, to calculate the net force between 2 different forces on an object. <br>
     * (Vector addition and not scalar addition)
     * @param force second {@link JGMPForce} to add onto current {@link JGMPForce}
     * @return net force of the 2 forces added onto each other
     */
    public JGMPForce addForce(JGMPForce force) {
        JGMPVector2 current = this.direction.multiplyScalar(this.force); // End Point of the Force Ray
        JGMPVector2 addition = force.direction.multiplyScalar(this.force); // End Point of the Force Ray
        JGMPVector2 netForce = current.add(addition); // Adding up the end points of the forces
        JGMPVector2 dir = new JGMPVector2((float)Math.cos(netForce.angle()), (float)Math.sin(netForce.angle()));
        return new JGMPForce(dir, netForce.length());
    }

    /**
     * Returns the net force between a list of all forces. <br>
     * (Vector addition and not scalar addition)
     * @param forces list of all {@link JGMPForce} to be added.
     * @return net force of the list of forces added onto each other
     */
    public JGMPForce netForce(List<JGMPForce> forces) {
        JGMPForce netForce = forces.get(0);
        for(int i=1; i<forces.size(); i++) netForce = netForce.addForce(forces.get(i));
        return netForce;
    }

    /**
     * Returns the opposite force, which when added would cancel each other out and return a net force of 0.
     * @return negative/opposite force
     */
    public JGMPForce negativeForce() {
        JGMPForce oppositeForce = this.copy();
        oppositeForce.direction = oppositeForce.direction.negative();
        return oppositeForce;
    }

}
