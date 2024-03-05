import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Coolculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    RoundedButton[] numberButtons = new RoundedButton[10];
    RoundedButton[] functionButtons = new RoundedButton[10];
    RoundedButton addButton, subButton, mulButton, divButton;
    RoundedButton decButton, equButton, delButton, clrButton, negButton, perButton;
    JPanel panel;

    Font myFont = new Font("Helvetica Neue", Font.PLAIN, 24);
    Font textFieldFont = new Font("Helvetica Neue", Font.BOLD, 30);
    Dimension buttonSize = new Dimension(75, 75);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Coolculator() {
        frame = new JFrame("Coolculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setBackground(Color.BLACK);
        textField.setEditable(false);
        textField.setBorder(null);
        textField.setText("0");
        textField.setFont(textFieldFont);
        textField.setForeground(Color.WHITE);

        addButton = new RoundedButton("+");
        subButton = new RoundedButton("\u2212");
        mulButton = new RoundedButton("\u00D7");
        divButton = new RoundedButton("\u00F7");
        decButton = new RoundedButton(".");
        perButton = new RoundedButton("%");
        delButton = new RoundedButton("D");
        clrButton = new RoundedButton("C");
        negButton = new RoundedButton("+/-");
        equButton = new RoundedButton("=");


        addButton.setBackground(new Color(255, 204, 0));
        addButton.setForeground(Color.WHITE);
        subButton.setBackground(new Color(255, 204, 0));
        subButton.setForeground(Color.WHITE);
        mulButton.setBackground(new Color(255, 204, 0));
        mulButton.setForeground(Color.WHITE);
        divButton.setBackground(new Color(255, 204, 0));
        divButton.setForeground(Color.WHITE);
        perButton.setBackground(new Color(150, 150, 150));
        perButton.setForeground(Color.BLACK);
        delButton.setBackground(new Color(50, 50, 50));
        delButton.setForeground(Color.WHITE);
        clrButton.setBackground(new Color(150, 150, 150));
        negButton.setBackground(new Color(150, 150, 150));
        equButton.setBackground(new Color(255, 204, 0));
        equButton.setForeground(Color.WHITE);
        decButton.setBackground(new Color(50, 50, 50));
        decButton.setForeground(Color.WHITE);

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = perButton;

        for (int i = 0; i < 10; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);

        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new RoundedButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(new Color(50, 50, 50));
            numberButtons[i].setForeground(Color.WHITE);
        }

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 375);
        panel.setLayout(new GridLayout(5, 5, 10, 10));
        panel.setBackground(Color.black);

        panel.add(clrButton);
        panel.add(negButton);
        panel.add(perButton);
        panel.add(divButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[0]); // 0 button
        panel.add(decButton); // Decimal button
        panel.add(delButton);
        panel.add(equButton); // Equal button


        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Coolculator calc = new Coolculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(textField.getText().equals("0") && e.getSource() != clrButton && e.getSource() != delButton) {
            textField.setText("");
        }

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            double percentValue = 0.0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            result += percentValue;
            if (result % 1 == 0) {

                textField.setText(String.valueOf((int) result));
            } else {
                textField.setText(String.valueOf(result));

            }

            num1 = result;
        }

        if (e.getSource() == clrButton) {
            textField.setText("0");
        }

        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");

            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }

            if (textField.getText().isEmpty()) {
                textField.setText("0");

            }
        }

        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }

        if(e.getSource() == perButton) {
            double currentNumber = Double.parseDouble(textField.getText());
            double percentValue  = currentNumber * .01 * num1;

            if (percentValue % 1 == 0) {
                textField.setText(String.valueOf((int) percentValue));
            } else {
                textField.setText(String.valueOf(percentValue));
            }

        }

    }
}

