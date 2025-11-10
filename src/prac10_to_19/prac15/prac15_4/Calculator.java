package prac10_to_19.prac15.prac15_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private double firstNumber, result;
    private String operator;
    private boolean newInput;

    public Calculator() {
        setTitle("Калькулятор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        initializeComponents();
        setVisible(true);
    }

    private void initializeComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        mainPanel.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", ".", "+",
                "", "", "=", ""
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);

            if (text.equals("C") || text.equals("=")) {
                button.setBackground(Color.ORANGE);
            }

            buttonPanel.add(button);
        }

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (display.getText().equals("Ошибка") && !command.equals("C")) {
            display.setText("0");
            firstNumber = 0;
            operator = null;
            newInput = true;
        }

        if (command.equals("C")) {
            display.setText("0");
            firstNumber = 0;
            operator = null;
            newInput = true;
        }
        else if (command.equals("=")) {
            calculateResult();
        }
        else if (command.matches("[0-9]")) {
            if (display.getText().equals("0") || newInput) {
                display.setText(command);
                newInput = false;
            } else {
                display.setText(display.getText() + command);
            }
        }
        else if (command.equals(".")) {
            if (newInput) {
                display.setText("0.");
                newInput = false;
            } else if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }
        }
        else {
            if (!display.getText().isEmpty() && !display.getText().equals("Ошибка")) {
                firstNumber = Double.parseDouble(display.getText());
                operator = command;
                newInput = true;
            }
        }
    }

    private void calculateResult() {
        if (operator != null && !newInput) {
            double secondNumber = Double.parseDouble(display.getText());

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        display.setText("Ошибка");
                        operator = null;
                        newInput = true;
                        return;
                    }
                    break;
            }

            if (result == (int) result) {
                display.setText(String.valueOf((int) result));
            } else {
                display.setText(String.valueOf(result));
            }

            operator = null;
            newInput = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}