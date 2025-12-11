package prac10_to_19.prac12.Rand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.Random;
import java.util.ArrayList;

public class Window extends JFrame {
    private DrawingPanel drawingPanel;
    private JSpinner shapeCountSpinner;
    private int shapeCount = 15;
    private Random random = new Random();
    private ArrayList<ShapeData> shapes = new ArrayList<>();
    private int initialWidth = 900;
    private int initialHeight = 700;

    private class ShapeData {
        int type;
        double relX, relY;
        double relWidth, relHeight;
        Color color;
        float rotation;

        ShapeData(int type, double relX, double relY, double relWidth, double relHeight, Color color) {
            this.type = type;
            this.relX = relX;
            this.relY = relY;
            this.relWidth = relWidth;
            this.relHeight = relHeight;
            this.color = color;
            this.rotation = random.nextFloat() * 20 - 10;
        }

        int getX(int currentWidth) { return (int)(relX * currentWidth); }
        int getY(int currentHeight) { return (int)(relY * currentHeight); }
        int getWidth(int currentWidth) { return (int)(relWidth * currentWidth); }
        int getHeight(int currentHeight) { return (int)(relHeight * currentHeight); }
    }

    public Window() {
        setTitle("Фигуры");
        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.setBackground(new Color(240, 240, 240));

        JLabel label = new JLabel("Количество:");
        label.setFont(new Font("Arial", Font.BOLD, 14));
        controlPanel.add(label);

        SpinnerModel spinnerModel = new SpinnerNumberModel(15, 1, 200, 1);
        shapeCountSpinner = new JSpinner(spinnerModel);
        shapeCountSpinner.setPreferredSize(new Dimension(70, 30));
        shapeCountSpinner.setFont(new Font("Arial", Font.PLAIN, 14));

        shapeCountSpinner.addChangeListener(e -> {
            shapeCount = (int) shapeCountSpinner.getValue();
            generateRandomShapes();
            drawingPanel.repaint();
        });

        controlPanel.add(shapeCountSpinner);

        JButton randomButton = new JButton("Новые");
        randomButton.setFont(new Font("Arial", Font.BOLD, 14));
        randomButton.setBackground(new Color(70, 130, 180));
        randomButton.setForeground(Color.WHITE);
        randomButton.setFocusPainted(false);
        randomButton.addActionListener(e -> {
            generateRandomShapes();
            drawingPanel.repaint();
        });
        controlPanel.add(randomButton);

        add(controlPanel, BorderLayout.NORTH);

        drawingPanel = new DrawingPanel();
        drawingPanel.setBackground(new Color(245, 245, 245));
        add(drawingPanel, BorderLayout.CENTER);

        generateRandomShapes();

        setSize(initialWidth, initialHeight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private Color getRandomColor() {
        return new Color(
                random.nextInt(200) + 55,
                random.nextInt(200) + 55,
                random.nextInt(200) + 55,
                180 + random.nextInt(75)
        );
    }

    private void generateRandomShapes() {
        shapes.clear();

        for (int i = 0; i < shapeCount; i++) {
            int type = random.nextInt(2);
            double relX = random.nextDouble() * 0.95;
            double relY = random.nextDouble() * 0.95;
            double minSize = 0.03;
            double maxSize = 0.25;
            double relWidth = minSize + random.nextDouble() * (maxSize - minSize);
            double relHeight = minSize + random.nextDouble() * (maxSize - minSize);

            if (type == 0) {
                double size = Math.min(relWidth, relHeight);
                relWidth = size;
                relHeight = size;
            }

            if (relX + relWidth > 0.98) {
                relWidth = 0.98 - relX;
            }
            if (relY + relHeight > 0.98) {
                relHeight = 0.98 - relY;
            }

            Color color = getRandomColor();
            shapes.add(new ShapeData(type, relX, relY, relWidth, relHeight, color));
        }
    }

    private class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            int currentWidth = getWidth();
            int currentHeight = getHeight();
            int circlesCount = 0;
            int rectanglesCount = 0;

            for (ShapeData shape : shapes) {
                int x = shape.getX(currentWidth);
                int y = shape.getY(currentHeight);
                int width = shape.getWidth(currentWidth);
                int height = shape.getHeight(currentHeight);

                if (width < 3 || height < 3) continue;

                AffineTransform oldTransform = g2d.getTransform();
                g2d.setColor(shape.color);

                if (shape.type == 0) {
                    g2d.fillOval(x, y, width, height);
                    g2d.setColor(shape.color.darker().darker());
                    g2d.setStroke(new BasicStroke(1.5f));
                    g2d.drawOval(x, y, width, height);
                    circlesCount++;
                } else {
                    g2d.rotate(Math.toRadians(shape.rotation),
                            x + width/2.0,
                            y + height/2.0);

                    int arcSize = Math.min(width, height) / 4;
                    if (arcSize < 5) arcSize = 5;

                    g2d.fillRoundRect(x, y, width, height, arcSize, arcSize);
                    g2d.setColor(shape.color.darker().darker());
                    g2d.setStroke(new BasicStroke(1.5f));
                    g2d.drawRoundRect(x, y, width, height, arcSize, arcSize);
                    rectanglesCount++;
                    g2d.setTransform(oldTransform);
                }

                g2d.setStroke(new BasicStroke(1));
            }

            g2d.setColor(Color.DARK_GRAY);
            g2d.setFont(new Font("Arial", Font.BOLD, 16));
            String info = "Фигур: " + shapes.size();
            g2d.drawString(info, 20, 30);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Window().setVisible(true);
        });
    }
}