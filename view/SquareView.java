package view;

import javax.swing.*;

import model.SquareModel;

import java.awt.*;

public class SquareView extends JPanel {
    private final SquareModel model;

    public SquareView(SquareModel model) {
        this.model = model;
        setPreferredSize(new Dimension(300, 300));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(model.getX(), model.getY(), model.getSize(), model.getSize());
    }
}
