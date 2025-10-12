package prac1_to_9.prac5.prac5_1;

import javax.swing.*;

public class Score extends JFrame{
    private int milan = 0;
    private int madrid = 0;

    private JLabel result = new JLabel("Счет: 0 : 0");
    private JLabel scorer = new JLabel("Последними забили: N/A");
    private JLabel winner = new JLabel("Подеждает: Ничья");

    public Score() {
        setTitle("Milan vs Madrid");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new java.awt.FlowLayout());

        JButton milanb = new JButton("AC Milan");
        JButton madridb = new JButton("Real Madrid");

        milanb.addActionListener(e -> {
            milan++;
            updateLables("AC Milan");
        });

        madridb.addActionListener(e -> {
            madrid++;
            updateLables("Real Madrid");
        });

        add(milanb);
        add(madridb);
        add(result);
        add(scorer);
        add(winner);
    }

    private void updateLables(String sc) {
        result.setText("Счет: " + milan + ":" + madrid);
        scorer.setText("Последними забили: " + sc);

        if (milan > madrid) {
            winner.setText("Подеждает: Milan");
        } else if (madrid > milan) {
            winner.setText("Подеждает: Madrid");
        } else {
            winner.setText("Подеждает: Ничья");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Score().setVisible(true);
        });
    }
}
