package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.SquareModel;

public class SquareController implements KeyListener {
    private final SquareModel model;

    public SquareController(SquareModel model) {
        this.model = model;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W -> model.setVy(-5);
            case KeyEvent.VK_A -> model.setVx(-5);
            case KeyEvent.VK_S -> model.setVy(5);
            case KeyEvent.VK_D -> model.setVx(5);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W, KeyEvent.VK_S -> model.setVy(0);
            case KeyEvent.VK_A, KeyEvent.VK_D -> model.setVx(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // not used in this example
    }
}
