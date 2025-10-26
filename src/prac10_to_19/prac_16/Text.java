package prac10_to_19.prac_16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Text extends JFrame implements ActionListener {
    private JTextArea textArea;

    public Text() {
        setTitle("Текстовый редактор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        initializeComponents();
        setVisible(true);
    }

    private void initializeComponents() {
        textArea = new JTextArea();
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        createMenu();
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu colorMenu = new JMenu("Цвет");
        String[] colors = {"Синий", "Красный", "Черный"};
        for (String color : colors) {
            JMenuItem item = new JMenuItem(color);
            item.addActionListener(this);
            colorMenu.add(item);
        }

        JMenu fontMenu = new JMenu("Шрифт");
        String[] fonts = {"Times New Roman", "MS Sans Serif", "Courier New"};
        for (String font : fonts) {
            JMenuItem item = new JMenuItem(font);
            item.addActionListener(this);
            fontMenu.add(item);
        }

        menuBar.add(colorMenu);
        menuBar.add(fontMenu);
        setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Синий":
                textArea.setForeground(Color.BLUE);
                break;
            case "Красный":
                textArea.setForeground(Color.RED);
                break;
            case "Черный":
                textArea.setForeground(Color.BLACK);
                break;
            case "Times New Roman":
                setFont("Times New Roman");
                break;
            case "MS Sans Serif":
                setFont("MS Sans Serif");
                break;
            case "Courier New":
                setFont("Courier New");
                break;
        }
    }

    private void setFont(String fontName) {
        Font currentFont = textArea.getFont();
        textArea.setFont(new Font(fontName, currentFont.getStyle(), currentFont.getSize()));
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new Text());
    }
}