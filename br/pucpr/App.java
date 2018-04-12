package br.pucpr;

import javax.swing.*;
import java.awt.*;

public class App extends JComponent {
    private boolean isDrawingCircle = false;
    private boolean isDrawingSquare = false;

    private Button btnCircle = new Button(100, 100, 100, 50);
    private Button btnSquare = new Button(300, 100, 100, 50);

    public App() {
        btnCircle.setListener(btn -> {
            isDrawingCircle = !isDrawingCircle;
            repaint();
        });
        btnSquare.setListener(btn -> {
            isDrawingSquare = !isDrawingSquare;
            repaint();
        });
        addMouseListener(btnCircle);
        addMouseListener(btnSquare);
        addMouseMotionListener(btnCircle);
        addMouseMotionListener(btnSquare);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        btnCircle.paint(g);
        btnSquare.paint(g);

        if (isDrawingCircle) {
            g.setColor(new Color(0, 0, 255));
            g.fillOval(btnCircle.getX(),
                    btnCircle.getY() + btnCircle.getH() + 50,
                    25, 25);
        }

        if (isDrawingSquare) {
            g.setColor(new Color(255, 0, 0));
            g.fillRect(
                    btnSquare.getX(),
                    btnSquare.getY() + btnSquare.getH() + 50,
                    25,
                    25
            );
        }
    }
}
