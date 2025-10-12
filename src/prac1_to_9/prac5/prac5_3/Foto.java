package prac1_to_9.prac5.prac5_3;

import javax.swing.*;
import java.awt.*;

public class Foto extends JFrame {
    private String imagepath;

    public Foto(String imagepath) {
        this.imagepath = imagepath;

        setTitle("Картинка");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (imagepath != null && !imagepath.isEmpty()) {
            ImageIcon icon = new ImageIcon(imagepath);
            Image image = icon.getImage();

            if (image.getWidth(null) != -1) {
                g.drawImage(image, 50, 50, this);
            } else {
                g.drawString("Image not found: " + imagepath, 50, 50);
            }
        } else {
            g.drawString("No image path provided", 50, 50);
        }
    }

        public static void main(String[] args) {
            String imagepath = args.length > 0 ? args[0] : "";

            SwingUtilities.invokeLater(() -> {
                new Foto(imagepath).setVisible(true);
            });
        }
    }