package prac10_to_19.prac12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class prac12_3 extends JPanel implements ActionListener {
    private Image sprite;
    private int frweight = 92;
    private int frheight = 129;
    private int totalframes = 8;
    private int currentframe = 0;
    private int x = 150;
    private int y = 100;
    private Timer timer;

    public prac12_3() {
        ImageIcon icon = new ImageIcon("C:\\Users\\palus\\Downloads\\photo_5454103262258134320_x.jpg");
        sprite = icon.getImage();

        timer = new Timer(100,this);
        timer.start();

        setPreferredSize(new Dimension(400,300));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (sprite != null) {
            int scrx = currentframe * frweight;
            int scry = 0;

            g.drawImage(sprite, x, y,x+frweight,y+frheight, scrx, scry,scrx+frweight,scry+frheight,this);
        }else {
            g.setColor(Color.RED);
            g.fillRect(x, y, frweight, frheight);
            g.setColor(Color.BLACK);
            g.drawString("Frame: " + currentframe, x, y - 10);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentframe = (currentframe + 1) %totalframes;
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Анимация");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new prac12_3());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}