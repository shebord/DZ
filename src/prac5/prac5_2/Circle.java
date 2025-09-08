package prac5.prac5_2;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends MShape {
    private int r;

    public Circle(Color color, int x, int y, int r) {
        super(color, x, y);
        this.r = r;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, r*2, r*2);
    }
}