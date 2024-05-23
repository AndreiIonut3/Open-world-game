package app;

import javax.swing.*;

import controller.SquareController;
import model.SquareModel;
import view.SquareView;

import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SquareModel model = new SquareModel();
            SquareView view = new SquareView(model);
            SquareController controller = new SquareController(model);

            JFrame frame = new JFrame("Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(view);
            frame.pack();
            frame.setVisible(true);

            view.addKeyListener(controller);
            view.setFocusable(true);

            Timer timer = new Timer(20, (ActionEvent e) -> {
                model.updatePosition(view.getSize());
                view.repaint();
            });
            timer.start();
        });
    }
}
