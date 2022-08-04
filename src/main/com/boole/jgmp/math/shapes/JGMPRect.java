package main.com.boole.jgmp.math.shapes;

import main.com.boole.jgmp.math.vectors.JGMPVector2;

public class JGMPRect {

    public float x, y, ex, ey;
    public JGMPVector2 min, max;

    public JGMPVector2 topLeft, topRight, bottomLeft, bottomRight;
    private void initPoints() {
        topLeft = new JGMPVector2(x,y);
        topRight = new JGMPVector2(ex,y);
        bottomLeft = new JGMPVector2(x,ey);
        bottomRight = new JGMPVector2(ex,ey);
    }

    public JGMPVector2 center;
    private void initCenter() {
        center = new JGMPVector2((x+ex)/2, (y+ey)/2);
    }

    public JGMPVector2 size, halfSize;
    private void initSize() {
        size = new JGMPVector2(Math.abs(ex-x), Math.abs(y-ey));
        halfSize = size.copy(); halfSize.divideScalar(2f);
    }

    public JGMPRay2 top, right, bottom, left;
    private void initSides() {
        top = new JGMPRay2(size.x, topLeft, JGMPVector2.RIGHT);
        right = new JGMPRay2(size.y, bottomRight, JGMPVector2.UP);
        bottom = new JGMPRay2(size.x, bottomLeft, JGMPVector2.RIGHT);
        left = new JGMPRay2(size.y, bottomLeft, JGMPVector2.UP);
    }

    private void init() { initPoints(); initCenter(); initSize(); initSides(); }

    public JGMPRect(float x, float y, float ex, float ey) {
        this.x = x;
        this.y = y;
        this.ex = ex;
        this.ey = ey;
        init();
    }
    public JGMPRect(float x, float y, int w, int h) {
        this.x = x;
        this.y = y;
        this.ex = x+w;
        this.ey = y-h;
        init();
    }

    public float width() { return size.x; }
    public float height() { return size.y; }
    public float area() { return size.dot(new JGMPVector2(this.y, 0)); }
    public float perimeter() { return 2*(size.dot(JGMPVector2.ONE)); }

}
