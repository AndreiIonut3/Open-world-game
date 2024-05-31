package model;

import java.awt.Dimension;

public class SquareModel {
    private int x = 50;
    private int y = 50;
    private final int size = 20;
    private int vx = 0;
    private int vy = 0;
    private boolean outOfBounds = false;

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

    public boolean isOutOfBounds() {
        return outOfBounds;
    }

    public void updatePosition(Dimension bounds) {
        x += vx;
        y += vy;

        // handle boundaries and update out-of-bounds state
       outOfBounds = false;
       if (x < 0 || x + size > bounds.width || y < 0 || y + size > bounds.height) {
        outOfBounds = true;
        //Adjust the position to stay within bounds if needed
        x = Math.max(0, Math.min(x, bounds.width - size));
        y = Math.max(0, Math.min(y, bounds.height - size));
       }
    }
}
