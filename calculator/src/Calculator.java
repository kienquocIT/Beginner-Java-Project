import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField textField;
    private String operator = "";
    private double firstNumber = 0;
    private boolean isOperatorClicked = false;

    public Calculator() {
        // Main window
        setTitle("Calculator");
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Display result
        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        add(textField, BorderLayout.NORTH);

        // Panel includes button
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
          "7","8","9","/",
          "4","5","6","*",
          "1","2","3","-",
          "0","C","=","+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("\\d")) {
            if (isOperatorClicked) {
                textField.setText(command);
                isOperatorClicked = false;
            } else {
                textField.setText(textField.getText() + command);
            }
        } else if (command.matches("[+\\-*/]")) {
            operator = command;
            firstNumber = Double.parseDouble(textField.getText());
            isOperatorClicked = true;
        } else if (command.equals("=")) {
            double secondNumber = Double.parseDouble(textField.getText());
            double result = 0;

            switch (operator) {
                case "+": result = firstNumber + secondNumber; break;
                case "-": result = firstNumber - secondNumber; break;
                case "*": result = firstNumber * secondNumber; break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero");
                        return;
                    }
                    break;
            }
            textField.setText(String.valueOf(result));
            isOperatorClicked = true;
        } else if (command.equals("C")) {
            textField.setText("");
            operator = "";
            firstNumber = 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new Calculator().setVisible(true);
        });
    }
}