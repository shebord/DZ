package prac20_24.prac22;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task2 extends JFrame {
    private JTextField display;
    private StringBuilder currentInput = new StringBuilder();
    private boolean lastWasOperator = false;
    private boolean lastWasEquals = false;

    public Task2() {
        setTitle("какулятор");
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 50));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
                "C", "<", "^", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "+",
                "1", "2", "3", "-",
                "", "0", ".", "=",
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));

            if (!text.isEmpty()) {
                button.addActionListener(new ButtonListener());
            } else {
                button.setEnabled(false);
                button.setVisible(false);
            }

            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setSize(300, 400);
        setLocationRelativeTo(null);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = ((JButton) e.getSource()).getText();

            switch (command) {
                case "=":
                    calculateResult();
                    lastWasEquals = true;
                    break;

                case "C":
                    currentInput.setLength(0);
                    display.setText("");
                    lastWasOperator = false;
                    lastWasEquals = false;
                    break;

                case "<":
                    if (currentInput.length() > 0) {
                        char lastChar = currentInput.charAt(currentInput.length() - 1);
                        currentInput.deleteCharAt(currentInput.length() - 1);
                        display.setText(currentInput.toString());
                        lastWasOperator = isOperator(lastChar);
                    }
                    break;

                default:
                    handleInput(command);
                    break;
            }
        }
    }

    private void handleInput(String command) {
        if (lastWasEquals) {
            currentInput.setLength(0);
            lastWasEquals = false;
        }

        char inputChar = command.charAt(0);

        if (Character.isDigit(inputChar) || inputChar == '.') {
            if (inputChar == '.') {
                int i = currentInput.length() - 1;
                while (i >= 0) {
                    char c = currentInput.charAt(i);
                    if (c == '.') {
                        return; // Уже есть точка в этом числе
                    }
                    if (isOperator(c)) {
                        break;
                    }
                    i--;
                }
            }
            currentInput.append(command);
            lastWasOperator = false;
        } else if (isOperator(inputChar)) {
            // Оператор
            if (currentInput.length() == 0 && inputChar != '-') {
                return;
            }

            if (lastWasOperator && inputChar == '-') {
                currentInput.append(command);
                lastWasOperator = false;
            } else if (!lastWasOperator) {
                currentInput.append(command);
                lastWasOperator = true;
            } else {
                currentInput.deleteCharAt(currentInput.length() - 1);
                currentInput.append(command);
            }
        }

        display.setText(currentInput.toString());
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private void calculateResult() {
        try {
            String expression = currentInput.toString();

            if (expression.isEmpty()) {
                display.setText("0");
                return;
            }

            double result = evaluateWithJavaScript(expression);

            result = Math.round(result * 1000.0) / 1000.0;

            if (result == (int)result) {
                currentInput.setLength(0);
                currentInput.append((int)result);
            } else {
                currentInput.setLength(0);
                currentInput.append(result);
            }

            display.setText(currentInput.toString());

        } catch (Exception ex) {
            display.setText("Ошибка");
            currentInput.setLength(0);
        }
    }

    private double evaluateWithJavaScript(String expression) {
        try {
            String jsExpression = expression
                    .replace("^", "**")  // Заменяем ^ на ** для JS
                    .replace(",", ".");   // Заменяем запятые на точки

            jsExpression = jsExpression.replaceAll("(?<=[\\+\\-*/])-", "m");
            jsExpression = jsExpression.replaceAll("^-", "m");
            jsExpression = jsExpression.replace("m", "-");

            return parseSimpleExpression(jsExpression);

        } catch (Exception e) {
            throw new RuntimeException("Ошибка вычисления: " + e.getMessage());
        }
    }

    private double parseSimpleExpression(String expr) {
        expr = expr.replaceAll("\\s+", "");

        while (expr.contains("**")) {
            int idx = expr.lastIndexOf("**");
            String left = getLeftOperand(expr, idx);
            String right = getRightOperand(expr, idx + 2);
            double leftVal = Double.parseDouble(left);
            double rightVal = Double.parseDouble(right);
            double result = Math.pow(leftVal, rightVal);
            expr = replacePart(expr, idx - left.length(), idx + 2 + right.length(), result);
        }

        while (expr.contains("*") || expr.contains("/")) {
            int mulIdx = expr.indexOf("*");
            int divIdx = expr.indexOf("/");
            int idx;

            if (mulIdx == -1) idx = divIdx;
            else if (divIdx == -1) idx = mulIdx;
            else idx = Math.min(mulIdx, divIdx);

            char op = expr.charAt(idx);
            String left = getLeftOperand(expr, idx);
            String right = getRightOperand(expr, idx + 1);
            double leftVal = Double.parseDouble(left);
            double rightVal = Double.parseDouble(right);
            double result;

            if (op == '*') {
                result = leftVal * rightVal;
            } else {
                if (rightVal == 0) throw new ArithmeticException("Деление на ноль");
                result = leftVal / rightVal;
            }

            expr = replacePart(expr, idx - left.length(), idx + 1 + right.length(), result);
        }

        while (expr.contains("+") || (expr.contains("-") && expr.length() > 1 && !expr.startsWith("-"))) {
            for (int i = 1; i < expr.length(); i++) {
                char c = expr.charAt(i);
                if (c == '+' || c == '-') {
                    String left = getLeftOperand(expr, i);
                    String right = getRightOperand(expr, i + 1);
                    double leftVal = Double.parseDouble(left);
                    double rightVal = Double.parseDouble(right);
                    double result = (c == '+') ? leftVal + rightVal : leftVal - rightVal;
                    expr = replacePart(expr, i - left.length(), i + 1 + right.length(), result);
                    break;
                }
            }
        }

        return Double.parseDouble(expr);
    }

    private String getLeftOperand(String expr, int operatorIdx) {
        int start = operatorIdx - 1;
        while (start >= 0) {
            char c = expr.charAt(start);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (start == 0 && c == '-') {
                    break;
                }
                if (start > 0 && expr.charAt(start - 1) != 'e' &&
                        !(expr.charAt(start - 1) == 'E')) {
                    break;
                }
            }
            start--;
        }
        return expr.substring(start + 1, operatorIdx);
    }

    private String getRightOperand(String expr, int operatorIdx) {
        int end = operatorIdx;
        boolean hasDecimal = false;

        while (end < expr.length()) {
            char c = expr.charAt(end);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (end == operatorIdx && c == '-') {
                    end++;
                    continue;
                }
                break;
            }
            end++;
        }
        return expr.substring(operatorIdx, end);
    }

    private String replacePart(String expr, int start, int end, double value) {
        String left = expr.substring(0, start);
        String right = expr.substring(end);
        String valStr = String.valueOf(value);

        if (valStr.endsWith(".0")) {
            valStr = valStr.substring(0, valStr.length() - 2);
        }

        return left + valStr + right;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Task2().setVisible(true);
        });
    }
}