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

        if (model.isOutOfBounds()) {
            String message = "Out-of-Bounds";
            FontMetrics fm = g.getFontMetrics();
            int messageWidth = fm.stringWidth(message);
            int messageHeight = fm.getHeight();

            //Calculate the postion for the message
            int x = (getWidth() - messageWidth) / 2;
            int y = (getHeight() + messageHeight) / 2;

            //Draw the gray transparent box
            g.setColor(new Color(128, 128, 128, 128)); //Gray with transparency
            g.fillRect(x - 10, y - messageHeight, messageWidth + 20, messageHeight + 10);

            //Draw the black text
            g.setColor(Color.BLACK);
            g.drawString(message, x, y);
        }
    }
}
