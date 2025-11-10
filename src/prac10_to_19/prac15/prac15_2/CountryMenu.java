package prac10_to_19.prac15.prac15_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountryMenu extends JFrame implements ActionListener {
    private JComboBox<String> countryComboBox;
    private JTextArea infoTextArea;

    private String[] countries = {"Australia", "China", "England", "Russia"};
    private String[] countryInfo = {
            "Австралия:\nСтолица: Канберра\nНаселение: 26 млн\nЯзык: Английский\nКонтинент: Австралия и Океания",
            "Китай:\nСтолица: Пекин\nНаселение: 1.4 млрд\nЯзык: Китайский\nКонтинент: Азия",
            "Англия:\nСтолица: Лондон\nНаселение: 56 млн\nЯзык: Английский\nКонтинент: Европа",
            "Россия:\nСтолица: Москва\nНаселение: 144 млн\nЯзык: Русский\nКонтинент: Европа/Азия"
    };

    public CountryMenu() {
        setTitle("Выбор страны");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        initializeComponents();
        setVisible(true);
    }

    private void initializeComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Hello Swing");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel comboBoxPanel = new JPanel(new FlowLayout());
        JLabel chooseLabel = new JLabel("Выберите страну:");
        countryComboBox = new JComboBox<>(countries);
        countryComboBox.addActionListener(this);

        comboBoxPanel.add(chooseLabel);
        comboBoxPanel.add(countryComboBox);
        mainPanel.add(comboBoxPanel, BorderLayout.CENTER);

        infoTextArea = new JTextArea(8, 30);
        infoTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        infoTextArea.setLineWrap(true);
        infoTextArea.setWrapStyleWord(true);
        infoTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(infoTextArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Информация о стране"));
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        infoTextArea.setText(countryInfo[0]);

        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countryComboBox) {
            int selectedIndex = countryComboBox.getSelectedIndex();
            if (selectedIndex >= 0 && selectedIndex < countryInfo.length) {
                infoTextArea.setText(countryInfo[selectedIndex]);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CountryMenu());
    }
}
