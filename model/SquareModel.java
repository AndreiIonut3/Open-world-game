package model;

import java.awt.Dimension;

public class SquareModel {
    private int x = 50;
    private int y = 50;
    private final int size = 20;
    private int vx = 0;
    private int vy = 0;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public void updatePosition(Dimension bounds) {
        x += vx;
        y += vy;

        // handle boundaries
        if (x < 0)
            x = 0;
        if (y < 0)
            y = 0;
        if (x + size > bounds.width)
            x = bounds.width - size;
        if (y + size > bounds.height)
            y = bounds.height - size;
    }
}
