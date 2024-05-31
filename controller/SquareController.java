package controller;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.SquareModel;

public class SquareController implements KeyListener {
    private final SquareModel model;
    private boolean wPressed, aPressed, sPressed, dPressed;

    public SquareController(SquareModel model) {
        this.model = model;
        wPressed = false;
        aPressed = false;
        sPressed = false;
        dPressed = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W -> {
                wPressed = true;
                updateVelocity();
            }
            case KeyEvent.VK_A -> {
                aPressed = true;
                updateVelocity();
            }
            case KeyEvent.VK_S -> {
                sPressed = true;
                updateVelocity();
            }
            case KeyEvent.VK_D -> {
                dPressed = true;
                updateVelocity();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W -> wPressed = false;
            case KeyEvent.VK_A -> aPressed = false;
            case KeyEvent.VK_S -> sPressed = false;
            case KeyEvent.VK_D -> dPressed = false;
        }
        updateVelocity();
    }

    private void updateVelocity() {
        int vx= 0, vy = 0;
        if(wPressed && !sPressed) {
            vy = -5;
        } else if (sPressed && !wPressed) {
            vy= 5;
        }

        if (aPressed && !dPressed) {
            vx = -5;
        } else if (dPressed && !aPressed) {
            vx = 5;
        }
        // Check if two keys are pressed simultaneously
        if ((wPressed && aPressed) || (wPressed && dPressed) ||
            (sPressed && aPressed) || (sPressed && dPressed)) {
            vx /= 1.5;
            vy /= 1.5;
        }
        model.setVx(vx);
        model.setVy(vy);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // not used in this example
    }
}