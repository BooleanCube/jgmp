package com.boole.jgmp.math.shapes;

import com.boole.jgmp.math.vectors.JGMPVector2;

/**
 * 2D Circle Shape Model for the JGMP Library. <br>
 * Contains lots of useful tools and functionalities to use related to circles.
 */
public class JGMPCircle {

    /**
     * Center of the {@link JGMPCircle}
     */
    public JGMPVector2 center;

    /**
     * Radius float value of the {@link JGMPCircle}
     */
    public float radius;

    /**
     * Diameter float value of the {@link JGMPCircle}<br>
     * Diameter = 2 * Radius
     */
    public float diameter;

    /**
     * Ray pointing to the top of the {@link JGMPCircle} from the center.
     */
    public JGMPRay2 up;

    /**
     * Ray pointing to the right of the {@link JGMPCircle} from the center.
     */
    public JGMPRay2 right;

    /**
     * Ray pointing to the bottom of the {@link JGMPCircle} from the center.
     */
    public JGMPRay2 down;

    /**
     * Ray pointing to the left of the {@link JGMPCircle} from the center.
     */
    public JGMPRay2 left;

    private void initRays() {
        up = new JGMPRay2(radius, center, JGMPVector2.UP);
        right = new JGMPRay2(radius, center, JGMPVector2.RIGHT);
        down = new JGMPRay2(radius, center, JGMPVector2.DOWN);
        left = new JGMPRay2(radius, center, JGMPVector2.LEFT);
    }

    private void init() { initRays(); }

    /**
     * Initialize {@link JGMPCircle} objects
     * @param center circle center point vector2
     * @param radius radius float value
     */
    public JGMPCircle(JGMPVector2 center, float radius) {
        this.center = center;
        this.radius = radius;
        this.diameter = radius*2;
        init();
    }

    /**
     * Calculates the total amount of surface area of the {@link JGMPCircle}. <br>
     * Surface Area = π * Radius^2
     * @return area float value
     */
    public float area() { return (float)(Math.PI*Math.pow(radius,2)); }

    /**
     * Calculates the perimeter of the {@link JGMPCircle}. <br>
     * Perimeter = π * Diameter
     * @return perimeter float value.
     */
    public float perimeter() { return (float)Math.PI*diameter; }

}
