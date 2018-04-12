package br.pucpr;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Button implements MouseListener, MouseMotionListener {
    private int x, y, w, h;
    private boolean isDown = false;
    private ButtonListener listener;
    private boolean isHovered;

    public Button(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    private boolean isHovered() {
        return isHovered;
    }

    private void fireButtonClicked() {
        if (listener != null) {
            listener.onClick(this);
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        int t = isDown ? 220 : 255;
        g2d.setColor(new Color(t,t,t));
        g2d.fillRect(x, y, w, h);
        g2d.dispose();

    }

    public void setListener(ButtonListener listener) {
        this.listener = listener;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        isDown = isHovered();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (isDown && isHovered()) {
            fireButtonClicked();
        }
        isDown = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        isHovered = e.getX() > x && e.getX() < (x + w)
                && e.getY() > y && e.getY() < (y + h);
    }
}
