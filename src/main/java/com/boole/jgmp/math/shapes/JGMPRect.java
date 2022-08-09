package com.boole.jgmp.math.shapes;

import com.boole.jgmp.math.vectors.JGMPVector2;

/**
 * 2D Rectangle Shape Model for the JGMP Library. <br>
 * Includes many optimized tools for Quadrilateral Mathematics.
 */
public class JGMPRect {

    /**
     * X-Coordinate of the {@link JGMPRect}
     */
    public float x;

    /**
     * Y-Coordinate of the {@link JGMPRect}
     */
    public float y;

    /**
     * Ending X-Coordinate of the {@link JGMPRect}
     */
    public float ex;

    /**
     * Ending Y-Coordinate of the {@link JGMPRect}
     */
    public float ey;

    /**
     * Top Left Corner of the {@link JGMPRect} (x,y)
     */
    public JGMPVector2 topLeft;

    /**
     * Top Right Corner of the {@link JGMPRect} (ex,y)
     */
    public JGMPVector2 topRight;

    /**
     * Bottom Left Corner of the {@link JGMPRect} (x,ry)
     */
    public JGMPVector2 bottomLeft;

    /**
     * Bottom Right Corner of the {@link JGMPRect} (ex,yx)
     */
    public JGMPVector2 bottomRight;
    private void initPoints() {
        topLeft = new JGMPVector2(x,y);
        topRight = new JGMPVector2(ex,y);
        bottomLeft = new JGMPVector2(x,ey);
        bottomRight = new JGMPVector2(ex,ey);
    }

    /**
     * Centor of the {@link JGMPRect}
     */
    public JGMPVector2 center;
    private void initCenter() {
        center = new JGMPVector2((x+ex)/2, (y+ey)/2);
    }

    /**
     * Size of the {@link JGMPRect} in {@link JGMPVector2}
     */
    public JGMPVector2 size;

    /**
     * Half of the size of the {@link JGMPRect} in {@link JGMPVector2}
     */
    public JGMPVector2 halfSize;
    private void initSize() {
        size = new JGMPVector2(Math.abs(ex-x), Math.abs(y-ey));
        halfSize = size.copy(); halfSize.divideScalar(2f);
    }

    /**
     * The top side of the {@link JGMPRect}
     */
    public JGMPRay2 top;

    /**
     * The right side of the {@link JGMPRect}
     */
    public JGMPRay2 right;

    /**
     * The bottom side of the {@link JGMPRect}
     */
    public JGMPRay2 bottom;

    /**
     * The left side of the {@link JGMPRect}
     */
    public JGMPRay2 left;
    private void initSides() {
        top = new JGMPRay2(size.x, topLeft, JGMPVector2.RIGHT);
        right = new JGMPRay2(size.y, bottomRight, JGMPVector2.UP);
        bottom = new JGMPRay2(size.x, bottomLeft, JGMPVector2.RIGHT);
        left = new JGMPRay2(size.y, bottomLeft, JGMPVector2.UP);
    }

    private void init() { initPoints(); initCenter(); initSize(); initSides(); }

    /**
     * Initialize the {@link JGMPRect} given the coodinates of the top left and bottom right corner coordinates
     * @param x x-coordinate of the top left vertex of the {@link JGMPRect}
     * @param y y-coordinate of the top left vertex of the {@link JGMPRect}
     * @param ex x-coordinate of the bottom right vertex of the {@link JGMPRect}
     * @param ey y-coordinate of the bottom right vertex of the {@link JGMPRect}
     */
    public JGMPRect(float x, float y, float ex, float ey) {
        this.x = x;
        this.y = y;
        this.ex = ex;
        this.ey = ey;
        init();
    }

    /**
     * Initialize the {@link JGMPRect} given the coodinates of the top left and bottom right vertices
     * @param topLeft top left vertex of the {@link JGMPRect}
     * @param bottomRight bottom right vertex of the {@link JGMPRect}
     */
    public JGMPRect(JGMPVector2 topLeft, JGMPVector2 bottomRight) {
        this.x = topLeft.x;
        this.y = topLeft.y;
        this.ex = bottomRight.x;
        this.ey = bottomRight.y;
        init();
    }

    /**
     * Initialize the {@link JGMPRect} given the top left vertex and the width and height of the {@link JGMPRect}
     * @param x x-coordinate of the top left vertex of the {@link JGMPRect}
     * @param y y-coordinate of the top left vertex of the {@link JGMPRect}
     * @param w width of the {@link JGMPRect}
     * @param h height of the {@link JGMPRect}
     */
    public JGMPRect(float x, float y, int w, int h) {
        this.x = x;
        this.y = y;
        this.ex = x+w;
        this.ey = y-h;
        init();
    }

    /**
     * Returns the width of the {@link JGMPRect}
     * @return width float value
     */
    public float width() { return size.x; }

    /**
     * Returns the height of the {@link JGMPRect}
     * @return height float value
     */
    public float height() { return size.y; }

    /**
     * Returns the surface area of the {@link JGMPRect}
     * @return surface area float value
     */
    public float area() { return size.dot(new JGMPVector2(this.y, 0)); }

    /**
     * Returns the perimeter of the {@link JGMPRect}
     * @return perimeter float value
     */
    public float perimeter() { return 2*(size.dot(JGMPVector2.ONE)); }

}
